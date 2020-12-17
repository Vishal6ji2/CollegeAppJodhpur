package com.mbm.mbmjodhpur.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mbm.mbmjodhpur.Fragments.AllchatFragment;
import com.mbm.mbmjodhpur.Fragments.DeptchatFragment;

public class ChatPagerAdapter extends FragmentStateAdapter {


    public ChatPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new DeptchatFragment();
        }
        return new AllchatFragment();

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
