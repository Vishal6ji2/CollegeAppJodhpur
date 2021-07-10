package com.mbm.mbmjodhpur.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.Adapters.PapersAdapter;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Sessions.AdminDashboardSession;
import com.mbm.mbmjodhpur.Sessions.StudentDashboardSession;

import java.util.ArrayList;

public class PapersFragment extends Fragment {

    AppCompatSpinner spinDept, spinSubject;

    RecyclerView recyclerView;

    ArrayList<String> arrSpinDept = new ArrayList<>();

    ArrayList<String> arrSpinSubject = new ArrayList<>();

    ArrayList<StudentAppResponse.Data.Subject> arrStudSubjectList = new ArrayList<>();

    ArrayList<StudentAppResponse.Data.Subject__1> arrStudSubList = new ArrayList<>();

    ArrayList<StudentAppAdminResponse.Data.Subject> arrAdminSubjectList = new ArrayList<>();

    PapersAdapter papersAdapter;

    StudentDashboardSession studentDashboardSession;

    AdminDashboardSession adminDashboardSession;


    public PapersFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_papers, container, false);

        initViews(view);

        adminDashboardSession = new AdminDashboardSession(requireActivity());
        studentDashboardSession = new StudentDashboardSession(requireActivity());

        //get papers with subject regarding departments

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(papersAdapter);

        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.papers_recyclerview);
        spinDept = view.findViewById(R.id.papers_spinbranch);
        spinSubject = view.findViewById(R.id.papers_spinsubject);
    }


}