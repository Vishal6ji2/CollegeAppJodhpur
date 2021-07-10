package com.mbm.mbmjodhpur.Activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.EbooksAdapter;
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

public class EbooksActivity extends AppCompatActivity {


    EditText edtsearch;

    RecyclerView recyclerView;

    MaterialToolbar toolbar;

    SwipeRefreshLayout refreshLayout;

    ArrayList<StudentAppResponse.Data.Library> arrEbookList = new ArrayList<>();

    ArrayList<StudentAppAdminResponse.Data.Library> arrAdminEbookList = new ArrayList<>();

    EbooksAdapter ebooksAdapter;

    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks);


        initviews();

        setSupportActionBar(toolbar);


        studentDashboardSession = new StudentDashboardSession(this);
        adminDashboardSession = new AdminDashboardSession(this);

        if (user.equals("student")){
            getStudentAppResponse(this);
        }else if (user.equals("admin")){
            getStudentAppAdminResponse(this);
        }

        toolbar.setNavigationOnClickListener(v -> finish());

        refreshLayout.setOnRefreshListener(() -> {
            toast(this,"Refresh");
            getEbooksData();
            refreshLayout.setRefreshing(false);
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        getEbooksData();

        edtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());

            }
        });

    }
    
    
    public void getEbooksData(){

        arrEbookList.clear();
        arrAdminEbookList.clear();

        if (user.equals("student")){
            arrEbookList = studentDashboardSession.get_LibraryList(this);
            ebooksAdapter = new EbooksAdapter(arrEbookList,this);

        }else if (user.equals("admin")){
            arrAdminEbookList = adminDashboardSession.get_LibraryList(this);
            ebooksAdapter = new EbooksAdapter(this,arrAdminEbookList);

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ebooksAdapter);
        
    }

    private void filter(String string) {

        if (user.equals("student")){
            ArrayList<StudentAppResponse.Data.Library> filterlist = new ArrayList<>();

            for (StudentAppResponse.Data.Library library : arrEbookList){
                if (library.getName().toLowerCase().contains(string.toLowerCase())){
                    filterlist.add(library);
                }
            }
            ebooksAdapter.filterlist(filterlist,this);

        }else if (user.equals("admin")){
            ArrayList<StudentAppAdminResponse.Data.Library> filterlist = new ArrayList<>();

            for (StudentAppAdminResponse.Data.Library library : arrAdminEbookList){
                if (library.getName().toLowerCase().contains(string.toLowerCase())){
                    filterlist.add(library);
                }
            }
            ebooksAdapter.filterlist(this,filterlist);

        }

      }


    private void initviews() {

        refreshLayout = findViewById(R.id.ebook_refresh);

        toolbar = findViewById(R.id.ebook_toolbar);

        recyclerView = findViewById(R.id.ebook_recyclerview);
        
        edtsearch = findViewById(R.id.ebook_edtsearch);

    }
}