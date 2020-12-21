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
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mbm.mbmjodhpur.Adapters.NewsPostAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.NewsPostSuitcase;
import com.mbm.mbmjodhpur.Suitcases.PlacementSuitcase;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

public class PostNewsActivity extends AppCompatActivity {


    MaterialToolbar toolbar;

    RecyclerView postsrecyclerview;

    ArrayList<NewsPostSuitcase> arrnewspostlist = new ArrayList<>();

    BottomNavigationView bnv;

    SlidingRootNav slidingRootNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_news);


        initviews();

        slidingRootNav =  new SlidingRootNavBuilder(PostNewsActivity.this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withDragDistance(150)
                .withMenuLayout(R.layout.navigationlayout)
                .inject();


        bnv.setSelectedItemId(R.id.newsmenu);
        setSupportActionBar(toolbar);


        addPostData("Mukesh Singhavi","2h ago","26/10/2020","About Exam Scheduling","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.mbmlogo,R.drawable.picone);

        addPostData("N.C. Barwar","5h ago","25/10/2020","About Timetable","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefive,R.drawable.directorimg);

        addPostData("Simran choudhary","2d ago","10/10/2020","About Practical exam","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefour,R.drawable.screenshot);

        addPostData("Aditya sawant","5d ago","12/10/2020","About Seminar","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.mbmlogo,R.drawable.pictwo);

        addPostData("Anil gupta","7d ago","10/12/2020","About Mid-Term","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefour,R.drawable.editorimg);


        postsrecyclerview.setHasFixedSize(true);
        postsrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        postsrecyclerview.setAdapter(new NewsPostAdapter(this,arrnewspostlist));

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.newsmenu:
                        return true;

                    case R.id.noticemenu:
                        startActivity(new Intent(PostNewsActivity.this,NoticeBoardActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                    case R.id.placementmenu:
                        startActivity(new Intent(PostNewsActivity.this, PlacementNewsActivity.class));
                        overridePendingTransition(0,0);
                        finish();
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
                startActivity(new Intent(PostNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        syllabuspaperlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PostNewsActivity.this,PreviousPapersActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        timetablelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
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

    public void addPostData(String profilename,String timeago,String datetime,String txtheading,String txtdetails, int profileimg, int postimg){

        NewsPostSuitcase newsPostSuitcase = new NewsPostSuitcase();

        newsPostSuitcase.profileimg = profileimg;
        newsPostSuitcase.postimg = postimg;

        newsPostSuitcase.profilename = profilename;
        newsPostSuitcase.datetime = datetime;
        newsPostSuitcase.timeago = timeago;
        newsPostSuitcase.txtheading = txtheading;
        newsPostSuitcase.txtdetails = txtdetails;

        arrnewspostlist.add(newsPostSuitcase);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.chatmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.chatmenu){
            startActivity(new Intent(PostNewsActivity.this,ChatActivity.class));
            return true;
        }
        return false;
    }


    private void initviews() {

        bnv = findViewById(R.id.bnv);

        toolbar = findViewById(R.id.toolbar);

        postsrecyclerview = findViewById(R.id.newspost_recyclerview);
    }
}