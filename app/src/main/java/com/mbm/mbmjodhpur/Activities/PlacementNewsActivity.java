package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
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

    ArrayList<PlacementSuitcase> arrplacementlist = new ArrayList<>();

    SlidingRootNav slidingRootNav;

    MenuItem menuItem;

    TextView menunoti;

    int pendingnoti = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_news);

        initviews();

        setSupportActionBar(toolbar);

        BottomNavigationView bnv = findViewById(R.id.bnv);

        bnv.setSelectedItemId(R.id.placementmenu);

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

        slidingRootNav =  new SlidingRootNavBuilder(PlacementNewsActivity.this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withDragDistance(150)
                .withMenuLayout(R.layout.navigationlayout)
                .inject();



        //side bar menus

        //profile ids
        ImageView profileimg = findViewById(R.id.navigation_profileimg);
        TextView profilename = findViewById(R.id.navigation_profilename);
        TextView profilebranch = findViewById(R.id.navigation_branch);
        ImageView viewprofileimg = findViewById(R.id.navigation_viewimg);

        profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,ProfileActivity.class));
            }
        });

        profilename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,ProfileActivity.class));
            }
        });

        profilebranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,ProfileActivity.class));
            }
        });

        viewprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,ProfileActivity.class));
            }
        });


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

            }
        });

        syllabuspaperlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,PreviousPapersActivity.class));

            }
        });

        timetablelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,TimetableActivity.class));

            }
        });

        sharelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"MBM JODHPUR APP");
                intent.putExtra(Intent.EXTRA_TEXT,"Please download MBM JODHPUR APP in your android mobile");
                startActivity(Intent.createChooser(intent,"Share via"));

            }
        });

        settinglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlacementNewsActivity.this,SettingActivity.class));

            }
        });

        contactlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("7239973921"));//change the number
                startActivity(callIntent);

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

    @Override
    protected void onStart() {
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

        super.onStart();
    }

    private void addData(int cmpimg, String cmpname, String cmptitle, String cmptime, String cmpnews) {

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
        menuItem = menu.findItem(R.id.chatmenu);


        menuItem.setActionView(R.layout.badgenotification);
        View view = menuItem.getActionView();
        menunoti = view.findViewById(R.id.badgecounter);

        if (pendingnoti == 0){
            menuItem.setActionView(null);
            return true;

        }else {
            menunoti.setText(String.valueOf(pendingnoti));
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PlacementNewsActivity.this,ChatActivity.class));
                pendingnoti = 0;
                menunoti.setVisibility(View.INVISIBLE);
            }
        });

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

        toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.placement_recyclerview);
    }
}