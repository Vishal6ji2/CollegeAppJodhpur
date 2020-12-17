package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mbm.mbmjodhpur.Adapters.ChatPagerAdapter;
import com.mbm.mbmjodhpur.R;

public class ChatActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    ImageView backimg;

    ViewPager2 viewPager2;

    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initviews();

        viewPager2.setAdapter(new ChatPagerAdapter(this));

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("Department");
//                        tab.setIcon(R.drawable.chaticon);

                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setMaxCharacterCount(3);

                        break;

                    case 1:
                        tab.setText("College");
//                        tab.setIcon(R.drawable.chaticon);

                        BadgeDrawable badgeDrawable1 = tab.getOrCreateBadge();
                        badgeDrawable1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        badgeDrawable1.setVisible(true);
                        badgeDrawable1.setNumber(1024);
//                        badgeDrawable1.setMaxCharacterCount(3);

                        break;
                }

            }
        });
        tabLayoutMediator.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });

/*
         <com.mbm.mbmjodhpur.MovableFloatingActionButton
        android:id="@+id/home_fabchat"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:src="@drawable/chaticon"
        android:layout_alignParentTop="true"

        app:backgroundTint="@color/colorPrimaryDark"
        android:layout_gravity="bottom|end"
        android:layout_alignParentStart="true"
        app:layout_anchorGravity="bottom|right|end"/>
*/


    }

    private void initviews() {

        backimg = findViewById(R.id.chat_backimg);
        toolbar = findViewById(R.id.chat_toolbar);
        viewPager2 = findViewById(R.id.chat_viewpager);
        tabLayout = findViewById(R.id.chat_tablayout);

    }
}