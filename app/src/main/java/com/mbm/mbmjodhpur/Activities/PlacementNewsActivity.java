package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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


        //side bar menus

        //profile ids
        ImageView profileimg = findViewById(R.id.navigation_profileimg);
        TextView profilename = findViewById(R.id.navigation_profilename);
        TextView profilebranch = findViewById(R.id.navigation_branch);
        ImageView viewprofileimg = findViewById(R.id.navigation_viewimg);


        //menu ids
        RelativeLayout ebooklayout,syllabuspaperlayout,timetablelayout,sharelayout,settinglayout,contactlayout,aboutlayout,signoutlayout;

        ebooklayout = findViewById(R.id.navigation_ebooklayout);
        syllabuspaperlayout = findViewById(R.id.navigation_syllabuspaperlayout);
        timetablelayout = findViewById(R.id.navigation_ttlayout);
        sharelayout = findViewById(R.id.navigation_sharelayout);
        settinglayout = findViewById(R.id.navigation_settinglayout);
        contactlayout = findViewById(R.id.navigation_contactlayout);
        aboutlayout = findViewById(R.id.navigation_aboutlayout);
        signoutlayout = findViewById(R.id.navigation_signoutlayout);


        ebooklayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
//                slidingRootNav.closeMenu();
            }
        });

        syllabuspaperlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,PreviousPapersActivity.class));
//                slidingRootNav.closeMenu();
            }
        });

        timetablelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,TimetableActivity.class));
//                slidingRootNav.closeMenu();
            }
        });

        sharelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        settinglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        contactlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        aboutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        signoutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.chatmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.chatmenu){
            startActivity(new Intent(PlacementNewsActivity.this,ChatActivity.class));
            return true;
        }
        return false;
    }

    private void initviews() {

        bnv = findViewById(R.id.bnv);

        toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.placement_recyclerview);
    }
}