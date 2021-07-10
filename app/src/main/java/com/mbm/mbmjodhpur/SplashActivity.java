package com.mbm.mbmjodhpur;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.mbm.mbmjodhpur.Activities.EmailVerifyActivity;
import com.mbm.mbmjodhpur.Activities.HomeActivity;
import com.mbm.mbmjodhpur.Activities.OnBoardingActivity;
import com.mbm.mbmjodhpur.Sessions.StudentLoginSession;

public class SplashActivity extends AppCompatActivity {

    public static int SPLASH_TIMER = 3000;

    SharedPreferences onBoardingsp ;

    StudentLoginSession loginSession;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        loginSession = new StudentLoginSession(this);

        new Handler().postDelayed(() -> {

            onBoardingsp = getSharedPreferences("onboardingscreen",MODE_PRIVATE);
            boolean isFirstTime = onBoardingsp.getBoolean("firsttime",true);

            boolean loginstatus = loginSession.checkStudentLogin();

            if (isFirstTime) {

                SharedPreferences.Editor editor = onBoardingsp.edit();
                editor.putBoolean("firsttime",false);
                editor.apply();

                startActivity(new Intent(SplashActivity.this,OnBoardingActivity.class));
            } else if (loginstatus){
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            }else {
                startActivity(new Intent(SplashActivity.this, EmailVerifyActivity.class));
            }
            finish();

        },SPLASH_TIMER);

    }

}