package com.mbm.mbmjodhpur.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mbm.mbmjodhpur.Fragments.PapersFragment;
import com.mbm.mbmjodhpur.Fragments.SyllabusFragment;

public class TabsViewpagerAdapter extends FragmentStateAdapter {

    public TabsViewpagerAdapter(@NonNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new PapersFragment();
        }
        return new SyllabusFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
