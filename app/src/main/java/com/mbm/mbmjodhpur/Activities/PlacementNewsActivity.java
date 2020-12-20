package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mbm.mbmjodhpur.Adapters.PlacementNewsAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.PlacementSuitcase;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

public class PlacementNewsActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    RecyclerView recyclerView;

    BottomNavigationView bnv;

    ArrayList<PlacementSuitcase> arrplacementlist = new ArrayList<>();

    SlidingRootNav slidingRootNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_news);

        initviews();

        slidingRootNav =  new SlidingRootNavBuilder(PlacementNewsActivity.this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withDragDistance(150)
                .withMenuLayout(R.layout.navigationlayout)
                .inject();

        bnv.setSelectedItemId(R.id.placementmenu);

        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");
        addData(R.drawable.musicianimg,"TCS","Off campus recruitment","12:11,12nov.2020","All the students of batch who are placed via off campus recruitment are requested to fill the given google form.");


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PlacementNewsAdapter(this,arrplacementlist));

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.newsmenu:
                        startActivity(new Intent(PlacementNewsActivity.this,PostNewsActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                    case R.id.noticemenu:
                        startActivity(new Intent(PlacementNewsActivity.this, NoticeBoardActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                    case R.id.placementmenu:
                        return true;
                }

                return true;
            }
        });

    }

    private void addData(int cmpimg,String cmpname,String cmptitle,String cmptime,String cmpnews) {

        PlacementSuitcase placementSuitcase = new PlacementSuitcase();
        placementSuitcase.companyname = cmpname;
        placementSuitcase.cmptime = cmptime;
        placementSuitcase.companyimg = cmpimg;
        placementSuitcase.placementtitle = cmptitle;
        placementSuitcase.placementnews = cmpnews;


        arrplacementlist.add(placementSuitcase);
    }

    private void initviews() {

        bnv = findViewById(R.id.bnv);

        toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.placement_recyclerview);
    }
}