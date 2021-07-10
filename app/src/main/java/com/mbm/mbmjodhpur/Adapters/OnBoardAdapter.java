package com.mbm.mbmjodhpur.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class OnBoardAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> arrfraglist;

    public OnBoardAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> arrfraglist,Lifecycle lifecycle) {
        super(fm, lifecycle);

        this.arrfraglist = arrfraglist;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arrfraglist.get(position);
    }

    @Override
    public int getItemCount() {
        return arrfraglist.size();
    }
}
