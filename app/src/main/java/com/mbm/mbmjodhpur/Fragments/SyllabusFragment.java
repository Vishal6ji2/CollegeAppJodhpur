package com.mbm.mbmjodhpur.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.mbm.mbmjodhpur.Adapters.SyllabusAdapter;
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

public class SyllabusFragment extends Fragment {

    RecyclerView recyclerView;

    EditText edtSearch;

    ArrayList<StudentAppResponse.Data.Syllabus> arrStudSyllabusList = new ArrayList<>();

    ArrayList<StudentAppAdminResponse.Data.Syllabus> arrAdminSyllabusList = new ArrayList<>();

    SyllabusAdapter syllabusAdapter ;

    SwipeRefreshLayout refreshLayout;
    
    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;


    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);

        initViews(view);

        studentDashboardSession = new StudentDashboardSession(requireActivity());
        adminDashboardSession = new AdminDashboardSession(requireActivity());

        if (user.equals("admin")){
            getStudentAppAdminResponse(requireActivity());
        }else if (user.equals("student")){
            getStudentAppResponse(requireActivity());
        }

        refreshLayout.setOnRefreshListener(() -> {
            getSyllabusData();
            refreshLayout.setRefreshing(false);
            toast(requireActivity(),"refresh");
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(),DividerItemDecoration.VERTICAL));

        getSyllabusData();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        return view;
    }

    private void initViews(View view) {

        recyclerView = view.findViewById(R.id.syllabus_recyclerview);

        edtSearch = view.findViewById(R.id.syllabus_edtsearch);

        refreshLayout = view.findViewById(R.id.syllabus_refresh);
    }

    public void getSyllabusData(){
        
        arrAdminSyllabusList.clear();
        arrStudSyllabusList.clear();

        if (user.equals("admin")){
            arrAdminSyllabusList = adminDashboardSession.get_SyllabusList(requireActivity());
            syllabusAdapter = new SyllabusAdapter(arrAdminSyllabusList, requireActivity());
        }else if (user.equals("student")){
            arrStudSyllabusList = studentDashboardSession.get_SyllabusList(requireActivity());
            syllabusAdapter = new SyllabusAdapter(requireActivity(), arrStudSyllabusList);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.setAdapter(syllabusAdapter);
        
    }

    private void filter(String string) {

        if (user.equals("admin")){
            ArrayList<StudentAppAdminResponse.Data.Syllabus> filterAdminList = new ArrayList<>();
            for (StudentAppAdminResponse.Data.Syllabus syllabus : arrAdminSyllabusList){
                if (syllabus.getName().toLowerCase().contains(string.toLowerCase())){
                    filterAdminList.add(syllabus);
                }
            }
            syllabusAdapter.filterlist(filterAdminList, requireActivity());

        }else if (user.equals("student")){
            ArrayList<StudentAppResponse.Data.Syllabus> filterStudList = new ArrayList<>();

            for (StudentAppResponse.Data.Syllabus syllabus : arrStudSyllabusList){
                if (syllabus.getName().toLowerCase().contains(string.toLowerCase())){
                    filterStudList.add(syllabus);
                }
            }
            syllabusAdapter.filterlist(requireActivity(), filterStudList);
        }
    }

}