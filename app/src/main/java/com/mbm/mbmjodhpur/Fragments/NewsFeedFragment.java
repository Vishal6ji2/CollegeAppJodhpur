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

import com.mbm.mbmjodhpur.Adapters.NewsPostAdapter;
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

public class NewsFeedFragment extends Fragment {

    RecyclerView postsrecyclerview;

    ProgressBar progressBar;

    SwipeRefreshLayout refreshLayout;

    ArrayList<StudentAppResponse.Data.News> arrStudNewsList = new ArrayList<>();

    ArrayList<StudentAppAdminResponse.Data.News> arrAdminNewsList = new ArrayList<>();

    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;

    NewsPostAdapter newsPostAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for the NewsFeed fragment

        View view = inflater.inflate(R.layout.fragment_newsfeed, container, false);

        initViews(view);

        studentDashboardSession = new StudentDashboardSession(requireActivity());
        adminDashboardSession = new AdminDashboardSession(requireActivity());

        if (user.equals("student")){
            getStudentAppResponse(requireActivity());
        }else if (user.equals("admin")){
            getStudentAppAdminResponse(requireActivity());
        }

        getNewsFeedData();

        refreshLayout.setOnRefreshListener(() -> {

            toast(requireActivity(),"Refresh");
            getNewsFeedData();
            refreshLayout.setRefreshing(false);
        });

        return view;
    }

    private void getNewsFeedData() {

        progressBar.setVisibility(View.VISIBLE);

        arrAdminNewsList.clear();
        arrStudNewsList.clear();

        if (user.equals("admin")){
            arrAdminNewsList = adminDashboardSession.get_NewsFeedList(requireActivity());
            newsPostAdapter = new NewsPostAdapter(arrAdminNewsList, requireActivity());
        }else if (user.equals("student")){
            arrStudNewsList = studentDashboardSession.get_NewsFeedList(requireActivity());
            newsPostAdapter = new NewsPostAdapter(requireActivity(), arrStudNewsList);
        }

        postsrecyclerview.setLayoutManager(new LinearLayoutManager(requireActivity()));
        postsrecyclerview.setAdapter(newsPostAdapter);
        progressBar.setVisibility(View.GONE);

    }

    private void initViews(View view) {

        postsrecyclerview = view.findViewById(R.id.newsfeed_recyclerview);

        progressBar = view.findViewById(R.id.newsfeed_progressbar);

        refreshLayout = view.findViewById(R.id.newsfeed_refresh);
    }

}