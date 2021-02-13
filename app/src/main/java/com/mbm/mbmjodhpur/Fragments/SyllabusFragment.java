package com.mbm.mbmjodhpur.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.android.material.button.MaterialButton;
import com.mbm.mbmjodhpur.Adapters.SyllabusAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.SyllabusSuitcase;

import java.util.ArrayList;

public class SyllabusFragment extends Fragment {

    AppCompatSpinner spinbranch;
    ArrayList<String> arrspinbranch = new ArrayList<>();

    RecyclerView recyclerView;
    ArrayList<SyllabusSuitcase> arrsyllabuslist = new ArrayList<>();

    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);

        spinbranch = view.findViewById(R.id.syllabus_branchspin);
        recyclerView = view.findViewById(R.id.syllabus_recyclerview);

        addBranchspindata();


        addData("BE Computer Science & Engineering");
        addData("BE Mechanical Engineering");
        addData("BE Electrical Engineering");
        addData("BE Electronic Engineering");
        addData("BE Civil Engineering");
        addData("BE Computer Science & Engineering");
        addData("BE Mechanical Engineering");
        addData("BE Electrical Engineering");
        addData("BE Electronic Engineering");
        addData("BE Civil Engineering");


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SyllabusAdapter(getActivity(),arrsyllabuslist));

        return view;
    }

    public void addData(String pdfname){
        SyllabusSuitcase syllabusSuitcase = new SyllabusSuitcase();
        syllabusSuitcase.pdfname = pdfname;

        arrsyllabuslist.add(syllabusSuitcase);
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