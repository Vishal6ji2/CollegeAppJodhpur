package com.mbm.mbmjodhpur.Activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Sessions.AdminDashboardSession;
import com.mbm.mbmjodhpur.Sessions.StudentDashboardSession;

import java.util.ArrayList;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppAdminResponse;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;


public class TimetableActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    AppCompatSpinner spinbranch;

    ArrayList<String> arrbranch = new ArrayList<>();

    RecyclerView recyclerView;

    ArrayList<StudentAppResponse.Data.Timetable> arrStudTimeList = new ArrayList<>();

    ArrayList<StudentAppAdminResponse.Data.Timetable> arrAdminTimeList = new ArrayList<>();

    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

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

        addBranchspindata();

    }


    private void addBranchspindata() {

        ArrayAdapter<String> adapterbranch = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arrbranch);

        spinbranch.setAdapter(adapterbranch);

    }

    private void initviews() {

        recyclerView = findViewById(R.id.tt_recyclerview);

        toolbar = findViewById(R.id.tt_toolbar);

        spinbranch = findViewById(R.id.tt_spinner);

    }
}