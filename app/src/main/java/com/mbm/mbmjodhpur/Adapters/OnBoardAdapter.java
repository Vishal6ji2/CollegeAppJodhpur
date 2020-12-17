package com.mbm.mbmjodhpur.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class OnBoardAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> arrfraglist = new ArrayList<>();

    public OnBoardAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> arrfraglist) {
        super(fm);
        this.arrfraglist = arrfraglist;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrfraglist.get(position);
    }

    @Override
    public int getCount() {
        return arrfraglist.size();
    }
}
