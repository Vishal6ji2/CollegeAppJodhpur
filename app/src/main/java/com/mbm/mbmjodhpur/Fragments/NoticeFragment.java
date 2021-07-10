package com.mbm.mbmjodhpur.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.mbm.mbmjodhpur.Adapters.NoticeAdapter;
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

public class NoticeFragment extends Fragment {
    
    RecyclerView noticeRecyclerview;

    ProgressBar progressBar;

    SwipeRefreshLayout refreshLayout;

    ArrayList<StudentAppResponse.Data.Noticeboard> arrStudNoticeList = new ArrayList<>();

    ArrayList<StudentAppAdminResponse.Data.Noticeboard> arrAdminNoticeList = new ArrayList<>();

    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;

    NoticeAdapter noticeAdapter;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        initViews(view);

        studentDashboardSession = new StudentDashboardSession(requireActivity());
        adminDashboardSession = new AdminDashboardSession(requireActivity());

        if (user.equals("student")){
            getStudentAppResponse(requireActivity());
        }else if (user.equals("admin")){
            getStudentAppAdminResponse(requireActivity());
        }

        getNoticeData();

        refreshLayout.setOnRefreshListener(() -> {

            toast(requireActivity(),"Refresh");
            getNoticeData();
            refreshLayout.setRefreshing(false);
        });

        return view;
    }

    private void getNoticeData() {

        progressBar.setVisibility(View.VISIBLE);

        arrStudNoticeList.clear();
        arrAdminNoticeList.clear();

        if (user.equals("admin")){
            arrAdminNoticeList = adminDashboardSession.get_NoticeList(requireActivity());
            noticeAdapter = new NoticeAdapter(arrAdminNoticeList, requireActivity());
        }else if (user.equals("student")){
            arrStudNoticeList = studentDashboardSession.get_NoticeList(requireActivity());
            noticeAdapter = new NoticeAdapter(requireActivity(), arrStudNoticeList);
        }

        noticeRecyclerview.setLayoutManager(new LinearLayoutManager(requireActivity()));
        noticeRecyclerview.setAdapter(noticeAdapter);
        progressBar.setVisibility(View.GONE);

    }

    private void initViews(View view) {

        noticeRecyclerview = view.findViewById(R.id.notice_recyclerview);

        progressBar = view.findViewById(R.id.notice_progressbar);

        refreshLayout = view.findViewById(R.id.notice_refresh);
    }

}