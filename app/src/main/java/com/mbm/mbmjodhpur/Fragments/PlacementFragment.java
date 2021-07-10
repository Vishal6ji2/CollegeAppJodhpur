package com.mbm.mbmjodhpur.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.mbm.mbmjodhpur.Adapters.PlacementNewsAdapter;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Sessions.AdminDashboardSession;
import com.mbm.mbmjodhpur.Sessions.StudentDashboardSession;

import java.util.ArrayList;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppAdminResponse;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;
import static com.mbm.mbmjodhpur.ViewUtils.toast;

public class PlacementFragment extends Fragment {

    RecyclerView recyclerView;

    ArrayList<StudentAppResponse.Data.NewsPlacement> arrStudPlacementList = new ArrayList<>();

    ArrayList<StudentAppAdminResponse.Data.Placement> arrAdminPlacementList = new ArrayList<>();

    SwipeRefreshLayout refreshLayout;

    ProgressBar progressBar;

    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;

    PlacementNewsAdapter placementNewsAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_placement, container, false);

        initViews(view);

        studentDashboardSession = new StudentDashboardSession(requireActivity());
        adminDashboardSession = new AdminDashboardSession(requireActivity());

        if (user.equals("student")){
            getStudentAppResponse(requireActivity());
        }else if (user.equals("admin")){
            getStudentAppAdminResponse(requireActivity());
        }

        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(),DividerItemDecoration.VERTICAL));

        getPlacementData();

        refreshLayout.setOnRefreshListener(() -> {

            toast(requireActivity(),"Refresh");
            getPlacementData();
            refreshLayout.setRefreshing(false);
        });

        return view;
    }

    private void getPlacementData() {

        progressBar.setVisibility(View.VISIBLE);

        arrAdminPlacementList.clear();
        arrStudPlacementList.clear();

        if (user.equals("admin")){
            arrAdminPlacementList = adminDashboardSession.get_PlacementList(requireActivity());
            placementNewsAdapter = new PlacementNewsAdapter(arrAdminPlacementList, requireActivity());
        }else if (user.equals("student")){
            arrStudPlacementList = studentDashboardSession.get_PlacementList(requireActivity());
            placementNewsAdapter = new PlacementNewsAdapter(requireActivity(), arrStudPlacementList);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.setAdapter(placementNewsAdapter);
        progressBar.setVisibility(View.GONE);

    }

    private void initViews(View view) {

        recyclerView = view.findViewById(R.id.placement_recyclerview);

        progressBar = view.findViewById(R.id.placement_progressbar);

        refreshLayout = view.findViewById(R.id.placement_refresh);
    }

}