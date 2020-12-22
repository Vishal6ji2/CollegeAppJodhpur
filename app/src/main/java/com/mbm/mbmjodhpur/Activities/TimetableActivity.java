package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.mbm.mbmjodhpur.Adapters.TabsViewpagerAdapter;
import com.mbm.mbmjodhpur.Adapters.TimeTableAdapter;
import com.mbm.mbmjodhpur.Adapters.ViewpagerAdapter;
import com.mbm.mbmjodhpur.Fragments.PapersFragment;
import com.mbm.mbmjodhpur.Fragments.SyllabusFragment;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.TimetableSuitcase;

import java.util.ArrayList;

public class TimetableActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    ImageView backimg;

    AppCompatSpinner spinbranch;

    ArrayList<String> arrbranch = new ArrayList<>();

    RecyclerView recyclerView;

    ArrayList<TimetableSuitcase> arrtimelist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        initviews();

        setSupportActionBar(toolbar);

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addBranchspindata();

        addTimetabledata("BE I SEM",R.drawable.picone);
        addTimetabledata("BE II SEM",R.drawable.picone);
        addTimetabledata("BE III SEM",R.drawable.picone);
        addTimetabledata("BE IV SEM",R.drawable.picone);
        addTimetabledata("BE V SEM",R.drawable.picone);
        addTimetabledata("BE VI SEM",R.drawable.picone);
        addTimetabledata("BE VII SEM",R.drawable.picone);
        addTimetabledata("BE VIII SEM",R.drawable.picone);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new TimeTableAdapter(this,arrtimelist));

    }

    public void addTimetabledata(String txtsem,int semimg){
        TimetableSuitcase timetableSuitcase = new TimetableSuitcase();
        timetableSuitcase.semimg = semimg;
        timetableSuitcase.txtsem = txtsem;

        arrtimelist.add(timetableSuitcase);
    }

    private void addBranchspindata() {

        arrbranch.add("Computer Science & Engineering");
        arrbranch.add("Electrical Engineering");
        arrbranch.add("Electronics Engineering");
        arrbranch.add("Civil Engineering");
        arrbranch.add("Mechanical Engineering");

        ArrayAdapter<String> adapterbranch = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arrbranch);

        spinbranch.setAdapter(adapterbranch);



    }


    private void initviews() {

        recyclerView = findViewById(R.id.tt_recyclerview);

        toolbar = findViewById(R.id.tt_toolbar);

        backimg = findViewById(R.id.tt_backimg);

        spinbranch = findViewById(R.id.tt_spinner);

    }
}