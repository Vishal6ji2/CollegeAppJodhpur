package com.mbm.mbmjodhpur.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;
import com.mbm.mbmjodhpur.Adapters.OnBoardAdapter;
import com.mbm.mbmjodhpur.Fragments.ChatonboardingFrag;
import com.mbm.mbmjodhpur.Fragments.NoticeonboardingFrag;
import com.mbm.mbmjodhpur.Fragments.PapersonboardingFrag;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {

    ViewPager2 viewPager;

    MaterialButton btnnext;

    ArrayList<Fragment> arrfraglist = new ArrayList<>();

    int currpage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        initviews();

        arrfraglist.add(new NoticeonboardingFrag());
        arrfraglist.add(new ChatonboardingFrag());
        arrfraglist.add(new PapersonboardingFrag());


        OnBoardAdapter onBoardAdapter = new OnBoardAdapter(getSupportFragmentManager(),arrfraglist,getLifecycle());

        viewPager.setAdapter(onBoardAdapter);

        btnnext.setText("NEXT");

        btnnext.setOnClickListener(v -> {

            if (btnnext.getText().toString().equals("NEXT")) {

                viewPager.setCurrentItem(currpage + 1);
            }else if (btnnext.getText().toString().equals("FINISH")){
                startActivity(new Intent(OnBoardingActivity.this, EmailVerifyActivity.class));
                finish();
            }
        });

    }

    private void initviews() {

        viewPager = findViewById(R.id.onboard_viewpager);
        btnnext = findViewById(R.id.onboard_btnnext);

    }
}