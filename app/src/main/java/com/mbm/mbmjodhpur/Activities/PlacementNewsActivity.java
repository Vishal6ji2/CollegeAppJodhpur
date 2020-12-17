package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.PlacementNewsAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.PlacementSuitcase;

import java.util.ArrayList;

public class PlacementNewsActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    RecyclerView recyclerView;

    ImageView backimg;

    ArrayList<PlacementSuitcase> arrplacementlist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_news);

        initviews();


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


        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void addData(int cmpimg,String cmpname,String cmptitle,String cmptime,String cmpnews) {

        PlacementSuitcase placementSuitcase = new PlacementSuitcase();
        placementSuitcase.companyname = cmpname;
        placementSuitcase.cmptime = cmptime;
        placementSuitcase.companyimg = cmpimg;
        placementSuitcase.placementtitle = cmptitle;
        placementSuitcase.placementnews = cmpnews;


        arrplacementlist.add(placementSuitcase);
    }

    private void initviews() {

        backimg = findViewById(R.id.placement_backimg);

        toolbar = findViewById(R.id.placement_toolbar);

        recyclerView = findViewById(R.id.placement_recyclerview);
    }
}