package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mbm.mbmjodhpur.R;

public class SettingActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    ImageView backimg;

    SwitchMaterial allswitch,deptswitch,clgswitch,notiswitch,newsswitch,placementswitch;

    RelativeLayout accountlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initviews();

        setSupportActionBar(toolbar);

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        accountlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this,ProfileActivity.class));
            }
        });


        allswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkswitches();
                }else {
                    checkswitches();
                }
            }
        });

    }

    public void checkswitches(){

        if (allswitch.isChecked()){
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

        backimg = findViewById(R.id.setting_backimg);

        accountlayout = findViewById(R.id.setting_mylayout);

        allswitch = findViewById(R.id.setting_allswitch);
        deptswitch = findViewById(R.id.setting_deptswitch);
        clgswitch = findViewById(R.id.setting_clgswitch);
        notiswitch = findViewById(R.id.setting_noticeswitch);
        newsswitch = findViewById(R.id.setting_newsswitch);
        placementswitch = findViewById(R.id.setting_placementswitch);

    }
}