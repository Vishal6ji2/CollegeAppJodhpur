package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbm.mbmjodhpur.Adapters.ViewpagerAdapter;
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

    MovableFloatingActionButton chatfab;

    RelativeLayout layoutpost,layoutgallery,layoutebooks,layoutpapers,layoutnotice,layoutplacement;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        initviews();


        slidingRootNav =  new SlidingRootNavBuilder(HomeActivity.this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withDragDistance(200)
                .withMenuLayout(R.layout.navigationlayout)
                .inject();



        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) chatfab.getLayoutParams();
        chatfab.setCoordinatorLayout(layoutParams);

        chatfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ChatActivity.class));
            }
        });


        layoutplacement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,PlacementNewsActivity.class));
            }
        });

        layoutnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,NoticeBoardActivity.class));
            }
        });

        layoutpapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,PreviousPapersActivity.class));
            }
        });

        layoutpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,PostNewsActivity.class));
            }
        });

        layoutgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ImageGalleryActivity.class));
            }
        });

        layoutebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,EbooksActivity.class));
            }
        });

    }

    private void initviews() {

        layoutplacement = findViewById(R.id.home_layoutplacement);
        layoutnotice = findViewById(R.id.home_layoutnotice);
        layoutpapers = findViewById(R.id.home_layoutpapers);
        layoutebooks = findViewById(R.id.home_layoutebook);
        layoutgallery = findViewById(R.id.home_layoutgallery);
        layoutpost = findViewById(R.id.home_layoutpost);

        chatfab = findViewById(R.id.home_fabchat);

        toolbar = findViewById(R.id.home_toolbar);

    }
}