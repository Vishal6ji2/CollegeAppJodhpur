package com.mbm.mbmjodhpur.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.mbm.mbmjodhpur.R;

public class SyllabusFragment extends Fragment {


    MaterialButton btncse,btnel,btncivil,btnme,btnelective,btnmca;

    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);

        btncse = view.findViewById(R.id.syllabus_cse);
        btnel = view.findViewById(R.id.syllabus_el);
        btncivil = view.findViewById(R.id.syllabus_civil);
        btnelective = view.findViewById(R.id.syllabus_elective);
        btnme = view.findViewById(R.id.syllabus_me);
        btnmca = view.findViewById(R.id.syllabus_mca);


        btncse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://www.pdf995.com/samples/pdf.pdf";

                Uri targetUri = Uri.parse(url);

                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(targetUri, "application/pdf");

                startActivity(intent);

            }
        });


        btncivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.pdf995.com/samples/pdf.pdf";

                Uri targetUri = Uri.parse(url);

                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(targetUri, "application/pdf");

                startActivity(intent);

            }
        });

        btnmca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.pdf995.com/samples/pdf.pdf";

                Uri targetUri = Uri.parse(url);

                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(targetUri, "application/pdf");

                startActivity(intent);

            }
        });

        btnel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.pdf995.com/samples/pdf.pdf";

                Uri targetUri = Uri.parse(url);

                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(targetUri, "application/pdf");

                startActivity(intent);

            }
        });

        btnme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.pdf995.com/samples/pdf.pdf";

                Uri targetUri = Uri.parse(url);

                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(targetUri, "application/pdf");

                startActivity(intent);

            }
        });

        btnelective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.pdf995.com/samples/pdf.pdf";

                Uri targetUri = Uri.parse(url);

                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(targetUri, "application/pdf");

                startActivity(intent);

            }
        });

        return view;
    }
}