package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.tabs.TabLayout;
import com.mbm.mbmjodhpur.Adapters.TabsViewpagerAdapter;
import com.mbm.mbmjodhpur.Fragments.PapersFragment;
import com.mbm.mbmjodhpur.Fragments.SyllabusFragment;
import com.mbm.mbmjodhpur.R;

public class PreviousPapersActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    TabLayout tabLayout;

    ViewPager viewpager;

    ImageView backimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_papers);

        initviews();

        setSupportActionBar(toolbar);

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TabsViewpagerAdapter viewpagerAdapter = new TabsViewpagerAdapter(getSupportFragmentManager());

        viewpagerAdapter.addFragment(new PapersFragment(),"Past papers");
        viewpagerAdapter.addFragment(new SyllabusFragment(),"Syllabus");

        viewpager.setAdapter(viewpagerAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    private void initviews() {

        backimg = findViewById(R.id.sp_backimg);

        toolbar = findViewById(R.id.sp_toolbar);

        viewpager = findViewById(R.id.sp_viewpager);
        tabLayout = findViewById(R.id.sp_tablayout);

    }
}