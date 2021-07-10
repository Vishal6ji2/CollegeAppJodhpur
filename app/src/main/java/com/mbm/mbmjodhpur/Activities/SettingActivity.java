package com.mbm.mbmjodhpur.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mbm.mbmjodhpur.R;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppAdminResponse;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;

public class SettingActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    SwitchMaterial allswitch,deptswitch,clgswitch,notiswitch,newsswitch,placementswitch;

    RelativeLayout accountlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initviews();

        setSupportActionBar(toolbar);

        if (user.equals("student")){
            getStudentAppResponse(this);
        }else if (user.equals("admin")){
            getStudentAppAdminResponse(this);
        }

        toolbar.setNavigationOnClickListener(v -> finish());

        accountlayout.setOnClickListener(v -> startActivity(new Intent(SettingActivity.this,ProfileActivity.class)));


        allswitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                checkswitches();
            }else {
                checkswitches();
            }
        });

    }

    public void checkswitches(){

        if (allswitch.isChecked()){

            deptswitch.setChecked(true);
            clgswitch.setChecked(true);
            notiswitch.setChecked(true);
            newsswitch.setChecked(true);
            placementswitch.setChecked(true);

            allswitch.setEnabled(true);
            deptswitch.setEnabled(false);
            clgswitch.setEnabled(false);
            notiswitch.setEnabled(false);
            newsswitch.setEnabled(false);
            placementswitch.setEnabled(false);

        }else {

            allswitch.setEnabled(true);
            deptswitch.setEnabled(true);
            clgswitch.setEnabled(true);
            notiswitch.setEnabled(true);
            newsswitch.setEnabled(true);
            placementswitch.setEnabled(true);

        }
    }

    private void initviews() {

        toolbar = findViewById(R.id.setting_toolbar);

        accountlayout = findViewById(R.id.setting_mylayout);

        allswitch = findViewById(R.id.setting_allswitch);
        deptswitch = findViewById(R.id.setting_deptswitch);
        clgswitch = findViewById(R.id.setting_clgswitch);
        notiswitch = findViewById(R.id.setting_noticeswitch);
        newsswitch = findViewById(R.id.setting_newsswitch);
        placementswitch = findViewById(R.id.setting_placementswitch);

    }
}