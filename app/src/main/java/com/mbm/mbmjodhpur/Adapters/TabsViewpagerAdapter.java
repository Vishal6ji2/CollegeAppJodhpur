package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabsViewpagerAdapter extends FragmentPagerAdapter {

    Context context;
    ArrayList<String> fragnamelist = new ArrayList<>();
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    public TabsViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment,String title){

        fragnamelist.add(title);

        fragmentArrayList.add(fragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragnamelist.get(position);
    }

}
