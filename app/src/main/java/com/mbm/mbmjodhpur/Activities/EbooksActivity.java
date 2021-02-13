package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.EbooksAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.EbooksSuitcase;

import java.util.ArrayList;

public class EbooksActivity extends AppCompatActivity {

    ImageView backimg;

//    Spinner spinner;
    EditText edtsearch;

    ArrayList<String> arrbranchlist = new ArrayList<>();

    RecyclerView recyclerView;

    MaterialToolbar toolbar;

    ArrayList<EbooksSuitcase> arrbookslist = new ArrayList<>();

    EbooksAdapter ebooksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks);


        initviews();

        setSupportActionBar(toolbar);

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        arrbranchlist.add("Computer Science & Engineering");
        arrbranchlist.add("Mechanical Engineering");
        arrbranchlist.add("Electronics Engineering");
        arrbranchlist.add("Civil Engineering");
        arrbranchlist.add("Petrolium Engineering");
        arrbranchlist.add("Electrical Engineering");

        ebooksAdapter = new EbooksAdapter(this,arrbookslist);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arrbranchlist);
        
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
        
//      spinner.setAdapter(adapter);

        addEbookData(R.drawable.designerimg,"C++ programming language","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++  language","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++  ","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++  ","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++  language","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++ programming language","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++  language","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++ programming ","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++  ","7th edition","Vishal kumavat");
        addEbookData(R.drawable.designerimg,"C++ programming language","7th edition","Vishal kumavat");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ebooksAdapter);


    }

    private void filter(String string) {

        ArrayList<EbooksSuitcase> filterlist = new ArrayList<>();

        for (EbooksSuitcase ebooksSuitcase : arrbookslist){
            if (ebooksSuitcase.bookname.toLowerCase().contains(string.toLowerCase())){
                filterlist.add(ebooksSuitcase);
            }
        }
        ebooksAdapter.filterlist(filterlist);
    }


    public void addEbookData(int bookimg,String bookname,String bookedition,String bookauthor){

        EbooksSuitcase ebooksSuitcase = new EbooksSuitcase();

        ebooksSuitcase.bookimg = bookimg;
        ebooksSuitcase.bookname = bookname;
        ebooksSuitcase.bookauthorname = bookauthor;
        ebooksSuitcase.bookedition = bookedition;

        arrbookslist.add(ebooksSuitcase);
    }

    private void initviews() {

        backimg = findViewById(R.id.ebook_backimg);

        toolbar = findViewById(R.id.ebook_toolbar);

        recyclerView = findViewById(R.id.ebook_recyclerview);
        
        edtsearch = findViewById(R.id.ebook_edtsearch);

//        spinner = findViewById(R.id.ebook_spinner);
    }
}