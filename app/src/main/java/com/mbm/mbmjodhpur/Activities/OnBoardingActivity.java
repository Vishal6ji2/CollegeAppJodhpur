package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.mbm.mbmjodhpur.Adapters.OnBoardAdapter;
import com.mbm.mbmjodhpur.Fragments.ChatonboardingFrag;
import com.mbm.mbmjodhpur.Fragments.NoticeonboardingFrag;
import com.mbm.mbmjodhpur.Fragments.PapersonboardingFrag;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
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


        OnBoardAdapter onBoardAdapter = new OnBoardAdapter(getSupportFragmentManager(),arrfraglist);

        viewPager.setAdapter(onBoardAdapter);
        tabLayout.setupWithViewPager(viewPager);

        btnnext.setText("NEXT");

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnnext.getText().toString().equals("NEXT")) {

                    viewPager.setCurrentItem(currpage + 1);
                }else if (btnnext.getText().toString().equals("FINISH")){
                    startActivity(new Intent(OnBoardingActivity.this,LoginActivity.class));
                    finish();
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                currpage = position;
                if (currpage<arrfraglist.size()-1){

                    btnnext.setText("NEXT");

                    btnnext.setEnabled(true);
                }else {
                    btnnext.setText("FINISH");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initviews() {

        viewPager = findViewById(R.id.onboard_viewpager);
        tabLayout = findViewById(R.id.onboard_tablayout);
        btnnext = findViewById(R.id.onboard_btnnext);

    }
}