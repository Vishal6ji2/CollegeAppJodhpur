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
                .withMenuLayout(R.layout.navigationlayout)
                .inject();

        //profile ids
        ImageView profileimg = findViewById(R.id.navigation_profileimg);
        TextView profilename = findViewById(R.id.navigation_profilename);
        ImageView arrowimg = findViewById(R.id.navigation_viewimg);

        //menus ids
        RelativeLayout homelayout = findViewById(R.id.navigation_homelayout);
        ImageView homeimg = findViewById(R.id.navigation_homeimg);
        TextView txthome = findViewById(R.id.navigation_txthome);

        final RelativeLayout newslayout = findViewById(R.id.navigation_newslayout);
        final ImageView newsimg = findViewById(R.id.navigation_newsimg);
        final TextView txtnews = findViewById(R.id.navigation_txtnews);

        final RelativeLayout placementlayout = findViewById(R.id.navigation_placementlayout);
        final ImageView placementimg = findViewById(R.id.navigation_placementimg);
        final TextView txtplacement = findViewById(R.id.navigation_txtplacement);

        final RelativeLayout noticelayout = findViewById(R.id.navigation_noticelayout);
        final ImageView noticeimg = findViewById(R.id.navigation_noticeimg);
        final TextView txtnotice = findViewById(R.id.navigation_txtnotice);

        final RelativeLayout ebooklayout = findViewById(R.id.navigation_ebooklayout);
        final ImageView ebookimg = findViewById(R.id.navigation_ebookimg);
        final TextView txtebook = findViewById(R.id.navigation_txtebook);

        final RelativeLayout paperlayout = findViewById(R.id.navigation_paperlayout);
        final ImageView paperimg = findViewById(R.id.navigation_paperimg);
        final TextView txtpaper = findViewById(R.id.navigation_txtpaper);

        final RelativeLayout aboutlayout = findViewById(R.id.navigation_aboutlayout);
        final ImageView aboutimg = findViewById(R.id.navigation_aboutimg);
        final TextView txtabout = findViewById(R.id.navigation_txtabout);

        final RelativeLayout signoutlayout = findViewById(R.id.navigation_signoutlayout);
        final ImageView signimg = findViewById(R.id.navigation_signoutimg);
        final TextView txtsign = findViewById(R.id.navigation_txtsignout);

        homelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                newslayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
//                newsimg.setColorFilter(R.color.colorPrimaryDark);
//                txtnews.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                Toast.makeText(HomeActivity.this, "home clicked", Toast.LENGTH_SHORT).show();
                slidingRootNav.closeMenu();
            }
        });


        newslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newslayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
                newsimg.setColorFilter(R.color.colorPrimaryDark);
                txtnews.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                slidingRootNav.closeMenu();
            }
        });

        placementlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placementlayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
                placementimg.setColorFilter(R.color.colorPrimaryDark);
                txtplacement.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                slidingRootNav.closeMenu();
            }
        });

        noticelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noticelayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
                noticeimg.setColorFilter(R.color.colorPrimaryDark);
                txtnotice.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                startActivity(new Intent(HomeActivity.this,NoticeBoardActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        ebooklayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ebooklayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
                ebookimg.setColorFilter(R.color.colorPrimaryDark);
                txtebook.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                slidingRootNav.closeMenu();
            }
        });

        paperlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paperlayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
                paperimg.setColorFilter(R.color.colorPrimaryDark);
                txtpaper.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                slidingRootNav.closeMenu();
            }
        });

        newslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newslayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
                newsimg.setColorFilter(R.color.colorPrimaryDark);
                txtnews.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                startActivity(new Intent(HomeActivity.this,PostNewsActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        aboutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutlayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
                aboutimg.setColorFilter(R.color.colorPrimaryDark);
                txtabout.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                slidingRootNav.closeMenu();
            }
        });

        signoutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signoutlayout.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.roundtext,getTheme()));
                signimg.setColorFilter(R.color.colorPrimaryDark);
                txtsign.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                slidingRootNav.closeMenu();
            }
        });

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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.menuitem,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.chatmenu){
            startActivity(new Intent(HomeActivity.this,ChatActivity.class));
            return true;
        }
        return true;
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