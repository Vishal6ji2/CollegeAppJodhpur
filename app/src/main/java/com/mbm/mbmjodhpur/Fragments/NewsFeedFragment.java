package com.mbm.mbmjodhpur.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbm.mbmjodhpur.Adapters.NewsPostAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.NewsPostSuitcase;

import java.util.ArrayList;

public class NewsFeedFragment extends Fragment {

    RecyclerView postsrecyclerview;

    ArrayList<NewsPostSuitcase> arrnewspostlist = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_newsfeed, container, false);

        postsrecyclerview = view.findViewById(R.id.newsfeed_recyclerview);


        addPostData("Mukesh Singhavi","2h ago","26/10/2020","About Exam Scheduling","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.mbmlogo,R.drawable.picone);

        addPostData("N.C. Barwar","5h ago","25/10/2020","About Timetable","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefive,R.drawable.directorimg);

        addPostData("Simran choudhary","2d ago","10/10/2020","About Practical exam","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefour,R.drawable.screenshot);

        addPostData("Aditya sawant","5d ago","12/10/2020","About Seminar","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.mbmlogo,R.drawable.pictwo);

        addPostData("Anil gupta","7d ago","10/12/2020","About Mid-Term","Our exam is scheduled on 23 nov. 2020 where we'll start your exam at the center which mbm south campus in mbm of jodhpur ,rajasthan.",R.drawable.profilefour,R.drawable.editorimg);


        postsrecyclerview.setHasFixedSize(true);
        postsrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        postsrecyclerview.setAdapter(new NewsPostAdapter(getActivity(),arrnewspostlist));


        return view;
    }

    public void addPostData(String profilename, String timeago, String datetime, String txtheading, String txtdetails, int profileimg, int postimg){

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

}