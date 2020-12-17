package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.NewsPostAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.NewsPostSuitcase;

import java.util.ArrayList;

public class PostNewsActivity extends AppCompatActivity {

    ImageView backimg;

    MaterialToolbar toolbar;

    RecyclerView postsrecyclerview;

    ArrayList<NewsPostSuitcase> arrnewspostlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_news);


        initviews();

        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Posts");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addPostData("Mukesh Singhavi","2h ago","26/10/2020","About Exam Scheduling","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.mbmlogo,R.drawable.picone);

        addPostData("N.C. Barwar","5h ago","25/10/2020","About Timetable","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefive,R.drawable.directorimg);

        addPostData("Simran choudhary","2d ago","10/10/2020","About Practical exam","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefour,R.drawable.screenshot);

        addPostData("Aditya sawant","5d ago","12/10/2020","About Seminar","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.mbmlogo,R.drawable.pictwo);

        addPostData("Anil gupta","7d ago","10/12/2020","About Mid-Term","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefour,R.drawable.editorimg);


        postsrecyclerview.setHasFixedSize(true);
        postsrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        postsrecyclerview.setAdapter(new NewsPostAdapter(this,arrnewspostlist));

    }

    public void addPostData(String profilename,String timeago,String datetime,String txtheading,String txtdetails, int profileimg, int postimg){

        NewsPostSuitcase newsPostSuitcase = new NewsPostSuitcase();

        newsPostSuitcase.profileimg = profileimg;
        newsPostSuitcase.postimg = postimg;

        newsPostSuitcase.profilename = profilename;
        newsPostSuitcase.datetime = datetime;
        newsPostSuitcase.timeago = timeago;
        newsPostSuitcase.txtheading = txtheading;
        newsPostSuitcase.txtdetails = txtdetails;

        arrnewspostlist.add(newsPostSuitcase);
    }

    private void initviews() {

        backimg = findViewById(R.id.newspost_backimg);

        toolbar = findViewById(R.id.newspost_toolbar);

        postsrecyclerview = findViewById(R.id.newspost_recyclerview);
    }
}