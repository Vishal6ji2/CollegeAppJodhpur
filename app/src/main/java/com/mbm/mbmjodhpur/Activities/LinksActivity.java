package com.mbm.mbmjodhpur.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.LinksAdapter;
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

public class LinksActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    MaterialToolbar toolbar;

    ArrayList<StudentAppResponse.Data.Link> arrStudLinksList = new ArrayList<>();

    ArrayList<StudentAppAdminResponse.Data.Link> arrAdminLinksList = new ArrayList<>();

    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;

    SwipeRefreshLayout refreshLayout;

    LinksAdapter linksAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        initviews();

        studentDashboardSession = new StudentDashboardSession(this);
        adminDashboardSession = new AdminDashboardSession(this);

        if (user.equals("student")){
            getStudentAppResponse(this);
        }else if (user.equals("admin")){
            getStudentAppAdminResponse(this);
        }

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        getLinksData();

        refreshLayout.setOnRefreshListener(() -> {

            toast(LinksActivity.this,"Refresh");

            getLinksData();

            refreshLayout.setRefreshing(false);
        });

    }

    private void getLinksData() {

        arrStudLinksList.clear();
        arrAdminLinksList.clear();

        if(user.equals("student")){
            arrStudLinksList = studentDashboardSession.get_LinksList(this);
            linksAdapter = new LinksAdapter(this,arrStudLinksList);
        }else if (user.equals("admin")){
            arrAdminLinksList = adminDashboardSession.get_LinksList(this);
            linksAdapter = new LinksAdapter(arrAdminLinksList,this);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(linksAdapter);

    }

    private void initviews() {

        recyclerView = findViewById(R.id.links_recyclerview);

        toolbar = findViewById(R.id.links_toolbar);

        refreshLayout = findViewById(R.id.links_refresh);

    }
}