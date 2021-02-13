package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.AboutusAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.AboutImgSuitcase;

import java.util.ArrayList;

public class AboutusActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    MaterialToolbar toolbar;

    ImageView backimg;

    ArrayList<AboutImgSuitcase> arrimglist = new ArrayList<>();

    TextView txtabout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        initviews();

        setSupportActionBar(toolbar);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addData(R.drawable.designerimg);
        addData(R.drawable.directorimg);
        addData(R.drawable.editorimg);
        addData(R.drawable.filmmakerimg);
        addData(R.drawable.musicianimg);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new AboutusAdapter(this,arrimglist));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }

    private void addData(int img) {
        AboutImgSuitcase imgSuitcase = new AboutImgSuitcase();
        imgSuitcase.img = img;
        arrimglist.add(imgSuitcase);
    }

    private void initviews() {

        recyclerView = findViewById(R.id.aboutus_recyclerview);

        toolbar = findViewById(R.id.aboutus_toolbar);

        backimg = findViewById(R.id.aboutus_backimg);

        txtabout = findViewById(R.id.aboutus_txtabout);

    }
}