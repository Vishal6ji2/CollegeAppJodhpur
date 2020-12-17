package com.mbm.mbmjodhpur.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.mbm.mbmjodhpur.Adapters.PapersAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.PapersSuitcase;

import java.util.ArrayList;

public class PapersFragment extends Fragment {

    AppCompatSpinner spinbranch,spinyear,spinsubject;


    RecyclerView recyclerView;

    ArrayList<String> arrspinbranch = new ArrayList<>();
    ArrayList<String> arrspinyear = new ArrayList<>();
    ArrayList<String> arrspinsubject = new ArrayList<>();

    ArrayList<PapersSuitcase> arrpaperslist = new ArrayList<>();


    public PapersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_papers, container, false);

        recyclerView = view.findViewById(R.id.papers_recyclerview);
        spinbranch = view.findViewById(R.id.papers_spinbranch);
        spinyear = view.findViewById(R.id.papers_spinyear);
        spinsubject = view.findViewById(R.id.papers_spinsubject);


        addSubjectspinData();

        addBranchspindata();

        addYearspindata();

        addPapersData("2018");
        addPapersData("2017");
        addPapersData("2016");
        addPapersData("2015");
        addPapersData("2014");
        addPapersData("2013");
        addPapersData("2012");


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(new PapersAdapter(getActivity(),arrpaperslist));

        return view;
    }

    private void addPapersData(String paperyear) {

        PapersSuitcase papersSuitcase = new PapersSuitcase();
//        papersSuitcase.paperimg = paperimg;
        papersSuitcase.paperyear = paperyear;

        arrpaperslist.add(papersSuitcase);
    }

    private void addSubjectspinData() {

        arrspinsubject.add("Advance mathematics ");
        arrspinsubject.add("C++ programming language ");
        arrspinsubject.add("Computer Networks");
        arrspinsubject.add("Data structure and algorithms ");
        arrspinsubject.add("Python language");

        ArrayAdapter<String> adaptersubject = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,arrspinsubject);

        spinsubject.setAdapter(adaptersubject);
    }

    private void addYearspindata() {

        arrspinyear.add("Ist year");
        arrspinyear.add("IInd year");
        arrspinyear.add("IIIrd year");
        arrspinyear.add("IVth year");

        ArrayAdapter<String> adapteryear = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,arrspinyear);

        spinyear.setAdapter(adapteryear);

    }

    private void addBranchspindata() {

        arrspinbranch.add("Computer Science & Engineering");
        arrspinbranch.add("Electrical Engineering");
        arrspinbranch.add("Electronics Engineering");
        arrspinbranch.add("Civil Engineering");
        arrspinbranch.add("Mechanical Engineering");

        ArrayAdapter<String> adapterbranch = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,arrspinbranch);

        spinbranch.setAdapter(adapterbranch);

    }

}