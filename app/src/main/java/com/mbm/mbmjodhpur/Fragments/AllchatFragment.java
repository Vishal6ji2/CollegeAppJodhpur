package com.mbm.mbmjodhpur.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbm.mbmjodhpur.R;

import static android.app.Activity.RESULT_OK;

public class AllchatFragment extends Fragment {

    FloatingActionButton fabfile,fabimg,fabdocs;

    Animation fabshow,fabhide,fabrotate,fabbackrotate;

    boolean isopen = false;


    public AllchatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_allchat, container, false);

        fabfile = view.findViewById(R.id.allfrag_fabfile);
        fabdocs = view.findViewById(R.id.allfrag_fabdocs);
        fabimg = view.findViewById(R.id.allfrag_fabimg);


        fabhide = AnimationUtils.loadAnimation(getActivity(),R.anim.hidefab);
        fabshow = AnimationUtils.loadAnimation(getActivity(),R.anim.showfab);
        fabrotate = AnimationUtils.loadAnimation(getActivity(),R.anim.rotatefab);
        fabbackrotate = AnimationUtils.loadAnimation(getActivity(),R.anim.backrotatefab);

        fabfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isopen){
                    fabfile.startAnimation(fabhide);
                    fabfile.startAnimation(fabrotate);
                    fabdocs.startAnimation(fabhide);
                    fabimg.startAnimation(fabhide);

                    fabimg.setClickable(false);
                    fabdocs.setClickable(false);

                    isopen = false;
                }else {
                    fabfile.startAnimation(fabshow);
                    fabfile.startAnimation(fabbackrotate);
                    fabdocs.startAnimation(fabshow);
                    fabimg.startAnimation(fabshow);

                    fabimg.setClickable(true);
                    fabdocs.setClickable(true);

                    isopen = true;
                }
            }
        });

        fabimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Image clicked",Toast.LENGTH_SHORT).show();
                Intent imgintent = new Intent(Intent.ACTION_GET_CONTENT);
                imgintent.setType("image/*");
                startActivityForResult(imgintent,10);
            }
        });


        fabdocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"docs clicked",Toast.LENGTH_SHORT).show();
                Intent imgintent = new Intent(Intent.ACTION_GET_CONTENT);
                imgintent.setType("*/*");
                startActivityForResult(imgintent,20);

            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && data != null){

            if (requestCode == 10){
                Toast.makeText(getActivity(), "Image selected", Toast.LENGTH_SHORT).show();
            }else if (requestCode == 20){
                Toast.makeText(getActivity(),"Docs selected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}