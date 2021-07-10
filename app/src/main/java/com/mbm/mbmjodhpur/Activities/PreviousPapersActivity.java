package com.mbm.mbmjodhpur.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.mbm.mbmjodhpur.Adapters.TabsViewpagerAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Sessions.AdminDashboardSession;
import com.mbm.mbmjodhpur.Sessions.StudentDashboardSession;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppAdminResponse;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;


public class PreviousPapersActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    TabLayout tabLayout;

    ViewPager2 viewpager;

    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_papers);


        initviews();

        adminDashboardSession = new AdminDashboardSession(this);
        studentDashboardSession = new StudentDashboardSession(this);

        if (user.equals("admin")){
            getStudentAppAdminResponse(this);
        }else if (user.equals("student")){
            getStudentAppResponse(this);
        }

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> finish());

        TabsViewpagerAdapter viewpagerAdapter = new TabsViewpagerAdapter(getSupportFragmentManager(),getLifecycle());

        viewpager.setAdapter(viewpagerAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Past Papers"));
        tabLayout.addTab(tabLayout.newTab().setText("Syllabus"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }

    private void initviews() {

        toolbar = findViewById(R.id.sp_toolbar);

        viewpager = findViewById(R.id.sp_viewpager);

        tabLayout = findViewById(R.id.sp_tablayout);

    }
}