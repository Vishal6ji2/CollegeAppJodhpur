package com.mbm.mbmjodhpur.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbm.mbmjodhpur.R;

public class DeptchatFragment extends Fragment {

    FloatingActionButton fabfile,fabimg,fabdocs;

    Animation fabshow,fabhide,fabrotate,fabbackrotate;

    boolean isopen = false;


    public DeptchatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_deptchat, container, false);

        fabfile = view.findViewById(R.id.deptfrag_fabfile);
        fabdocs = view.findViewById(R.id.deptfrag_fabdocs);
        fabimg = view.findViewById(R.id.deptfrag_fabimg);


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
            }
        });


        fabdocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"docs clicked",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}