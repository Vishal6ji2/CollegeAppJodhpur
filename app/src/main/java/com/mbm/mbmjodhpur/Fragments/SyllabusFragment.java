package com.mbm.mbmjodhpur.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.mbm.mbmjodhpur.Adapters.SyllabusAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.EbooksSuitcase;
import com.mbm.mbmjodhpur.Suitcases.SyllabusSuitcase;

import java.util.ArrayList;

public class SyllabusFragment extends Fragment {

    RecyclerView recyclerView;

    EditText edtsearch;

    ArrayList<SyllabusSuitcase> arrsyllabuslist = new ArrayList<>();

    SyllabusAdapter syllabusAdapter ;

    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);

        recyclerView = view.findViewById(R.id.syllabus_recyclerview);
        edtsearch = view.findViewById(R.id.syllabus_edtsearch);



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

        syllabusAdapter = new SyllabusAdapter(getActivity(),arrsyllabuslist);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(syllabusAdapter);

        edtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());

            }
        });


        return view;
    }

    public void addData(String pdfname){
        SyllabusSuitcase syllabusSuitcase = new SyllabusSuitcase();
        syllabusSuitcase.pdfname = pdfname;

        arrsyllabuslist.add(syllabusSuitcase);
    }

    private void filter(String string) {

        ArrayList<SyllabusSuitcase> filterlist = new ArrayList<>();

        for (SyllabusSuitcase syllabusSuitcase : arrsyllabuslist){
            if (syllabusSuitcase.pdfname.toLowerCase().contains(string.toLowerCase())){
                filterlist.add(syllabusSuitcase);
            }
        }
        syllabusAdapter.filterlist(filterlist);
    }

}