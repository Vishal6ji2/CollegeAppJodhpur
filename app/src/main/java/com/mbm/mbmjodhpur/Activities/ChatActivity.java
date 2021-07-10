package com.mbm.mbmjodhpur.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mbm.mbmjodhpur.Adapters.ChatPagerAdapter;
import com.mbm.mbmjodhpur.R;

import java.util.Objects;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppAdminResponse;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;


public class ChatActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    ViewPager2 viewPager2;

    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initviews();

        setSupportActionBar(toolbar);

        if (user.equals("student")){
            getStudentAppResponse(this);
        }else if (user.equals("admin")){
            getStudentAppAdminResponse(this);
        }

        viewPager2.setAdapter(new ChatPagerAdapter(this));

        toolbar.setNavigationOnClickListener(v -> finish());

        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {

            switch (position){
                case 0:
                    tab.setText("Department");
//                        tab.setIcon(R.drawable.chaticon);

                    BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                    badgeDrawable.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));
                    badgeDrawable.setVisible(true);
                    badgeDrawable.setNumber(100);
                    badgeDrawable.setMaxCharacterCount(3);

                    break;

                case 1:
                    tab.setText("College");
//                        tab.setIcon(R.drawable.chaticon);

                    int no = 5;
                    BadgeDrawable badgeDrawable1 = tab.getOrCreateBadge();
                    badgeDrawable1.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                    badgeDrawable1.setBadgeTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
                    badgeDrawable1.setVisible(true);
                    badgeDrawable1.setNumber(no);
                    badgeDrawable1.setMaxCharacterCount(3);

                    break;
            }

        });
        tabLayoutMediator.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = Objects.requireNonNull(tabLayout.getTabAt(position)).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });

    }

    private void initviews() {

        toolbar = findViewById(R.id.chat_toolbar);

        viewPager2 = findViewById(R.id.chat_viewpager);

        tabLayout = findViewById(R.id.chat_tablayout);

    }
}