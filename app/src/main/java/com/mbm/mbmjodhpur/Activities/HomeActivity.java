package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbm.mbmjodhpur.Adapters.ViewpagerAdapter;
import com.mbm.mbmjodhpur.Fragments.NewsFeedFragment;
import com.mbm.mbmjodhpur.Fragments.NoticeFragment;
import com.mbm.mbmjodhpur.Fragments.PlacementFragment;
import com.mbm.mbmjodhpur.MovableFloatingActionButton;
import com.mbm.mbmjodhpur.R;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    SlidingRootNav slidingRootNav;

    BottomNavigationView bnv;

    FrameLayout frameLayout;

    MenuItem menuItem;

    TextView menunoti;

    int pendingnoti = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initviews();

        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout,new NewsFeedFragment()).commit();


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.newsmenu:
                        fragment = new NewsFeedFragment();
                        break;

                    case R.id.noticemenu:
                        fragment = new NoticeFragment();
                        break;

                    case R.id.placementmenu:
                        fragment = new PlacementFragment();
                        break;
                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, fragment).commit();
                }

                return true;
            }
        });

        slidingRootNav =  new SlidingRootNavBuilder(HomeActivity.this)
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
                startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
            }
        });

        profilename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
            }
        });

        profilebranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
            }
        });

        viewprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
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
                startActivity(new Intent(HomeActivity.this,EbooksActivity.class));

            }
        });

        syllabuspaperlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,PreviousPapersActivity.class));

            }
        });

        timetablelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,TimetableActivity.class));

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
                startActivity(new Intent(HomeActivity.this,SettingActivity.class));

            }
        });

        contactlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ContactusActivity.class));

            }
        });

        aboutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,AboutusActivity.class));

            }
        });

        signoutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                finish();

            }
        });


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

                startActivity(new Intent(HomeActivity.this,ChatActivity.class));
                pendingnoti = 0;
                menunoti.setVisibility(View.INVISIBLE);


            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.chatmenu){
            startActivity(new Intent(HomeActivity.this,ChatActivity.class));
//            menunoti.setVisibility(View.INVISIBLE);
            pendingnoti = 0;
            return true;
        }
        return false;
    }


    private void initviews() {

        frameLayout = findViewById(R.id.home_framelayout);

        bnv = findViewById(R.id.bnv);

        toolbar = findViewById(R.id.home_toolbar);

    }
}