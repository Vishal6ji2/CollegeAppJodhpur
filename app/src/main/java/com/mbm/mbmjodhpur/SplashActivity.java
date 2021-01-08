package com.mbm.mbmjodhpur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.mbm.mbmjodhpur.Activities.HomeActivity;
import com.mbm.mbmjodhpur.Activities.OnBoardingActivity;
import com.mbm.mbmjodhpur.R;

import com.mbm.mbmjodhpur.Activities.LoginActivity;
import com.mikhaellopez.circularimageview.CircularImageView;

public class SplashActivity extends AppCompatActivity {

    TextView txtmbm,txteng;
    CircularImageView logo;

    Animation txtmbmanimation,txtenganimation;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txtmbm = findViewById(R.id.splash_txtmbm);
        txteng = findViewById(R.id.splash_txteng);
        logo = findViewById(R.id.splash_logoimg);


        txtenganimation = AnimationUtils.loadAnimation(this,R.anim.mbmlogoanim);
        txtmbmanimation = AnimationUtils.loadAnimation(this,R.anim.moveanim);

//        logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.mbmlogoanim));
        txtmbm.startAnimation(txtmbmanimation);
        txteng.startAnimation(txtenganimation);

        txtenganimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                startActivity(new Intent(SplashActivity.this, OnBoardingActivity.class));
//                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}