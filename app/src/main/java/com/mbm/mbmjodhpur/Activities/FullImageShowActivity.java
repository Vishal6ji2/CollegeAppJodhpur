package com.mbm.mbmjodhpur.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.ImageSliderAdapter;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;


public class FullImageShowActivity extends AppCompatActivity {


    ViewPager2 viewPager;

    MaterialToolbar toolbar;

    ArrayList<String> imagelist;

    ImageSliderAdapter sliderAdapter;

    Intent intent;

    LinearLayout lldots;

    int dotscount;

    ImageView[] dots;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_show);


        initviews();

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> onBackPressed());


        intent = getIntent();
        if (intent != null){
            if (intent.getStringArrayListExtra("images") != null){

                imagelist = intent.getStringArrayListExtra("images");

                sliderAdapter = new ImageSliderAdapter(FullImageShowActivity.this,imagelist);

                if (imagelist.size() == 1) {
                    lldots.setVisibility(View.GONE);
                } else if (imagelist.size() > 1) {
                    preparedots();
                    lldots.setVisibility(View.VISIBLE);
                }
                viewPager.setAdapter(sliderAdapter);
            }
        }

    }

    void preparedots() {

        lldots.removeAllViews();

        dotscount = sliderAdapter.getItemCount();

        dots = new ImageView[dotscount];

        for (int i = 0; i<dotscount;i++){

            dots[i] = new ImageView(this);

            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.unselectdots));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(4, 0, 4, 0);

            lldots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.selecteddots));

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i<dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(FullImageShowActivity.this,R.drawable.unselectblankdots));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(FullImageShowActivity.this,R.drawable.selectedwhitedots));

            }
        });

    }

    private void initviews() {

        viewPager = findViewById(R.id.fullimage_viewpager);

        toolbar = findViewById(R.id.fullimage_toolbar);

        lldots = findViewById(R.id.fullimage_lldots);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}