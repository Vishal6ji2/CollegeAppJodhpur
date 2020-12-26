package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mbm.mbmjodhpur.Adapters.NoticeAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.NoticeSuitcase;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

public class NoticeBoardActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    RecyclerView recyclerView;

    ArrayList<NoticeSuitcase> arrnoticelist = new ArrayList<>();

    BottomNavigationView bnv;

    SlidingRootNav slidingRootNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        initviews();

        bnv.setSelectedItemId(R.id.noticemenu);

        setSupportActionBar(toolbar);


        addNoticeData(R.drawable.signimg,"Paragraph Writing (अनुच्छेद-लेखन) - इस लेख में हम अनुच्छेद-लेखन के बारे में जानेंगे। अनुच्छेद-लेखन होता क्या है? अनुच्छेद लिखते समय किन-किन बातों का ध्यान रखना चाहिए? अनुच्छेद की प्रमुख विशेषताएँ कौन-कौन से हैं? और साथ ही इस लेख में हम कुछ अनुच्छेद अदाहरण के रूप में भी दे रहे हैं -");
        addNoticeData(R.drawable.signimg,"Paragraph Writing (अनुच्छेद-लेखन) - इस लेख में हम अनुच्छेद-लेखन के बारे में जानेंगे। अनुच्छेद-लेखन होता क्या है? अनुच्छेद लिखते समय किन-किन बातों का ध्यान रखना चाहिए? अनुच्छेद की प्रमुख विशेषताएँ कौन-कौन से हैं? और साथ ही इस लेख में हम कुछ अनुच्छेद अदाहरण के रूप में भी दे रहे हैं -");
        addNoticeData(R.drawable.signimg,"किसी एक भाव या विचार को व्यक्त करने के लिए लिखे गये सम्बद्ध और लघु वाक्य-समूह को अनुच्छेद-लेखन कहते हैं।\n" +
                "दूसरे शब्दों में - किसी घटना, दृश्य अथवा विषय को संक्षिप्त (कम शब्दों में) किन्तु सारगर्भित (अर्थपूर्ण) ढंग से जिस लेखन-शैली में प्रस्तुत किया जाता है, उसे अनुच्छेद-लेखन कहते हैं।\n" +
                "'अनुच्छेद' शब्द अंग्रेजी भाषा के 'Paragraph' शब्द का हिंदी पर्याय है। अनुच्छेद 'निबंध' का संक्षिप्त रूप होता है। इसमें किसी विषय के किसी एक पक्ष पर 80 से 100 शब्दों में अपने विचार व्यक्त किए जाते हैं।\n" +
                "अनुच्छेद अपने-आप में स्वतन्त्र और पूर्ण होते हैं। अनुच्छेद का मुख्य विचार या भाव की कुंजी या तो आरम्भ में रहती है या अन्त में। एक अच्छे अनुच्छेद-लेखन में मुख्य विचार अन्त में दिया जाता है।");
        addNoticeData(R.drawable.signimg,"किसी एक भाव या विचार को व्यक्त करने के लिए लिखे गये सम्बद्ध और लघु वाक्य-समूह को अनुच्छेद-लेखन कहते हैं।\n" +
                "दूसरे शब्दों में - किसी घटना, दृश्य अथवा विषय को संक्षिप्त (कम शब्दों में) किन्तु सारगर्भित (अर्थपूर्ण) ढंग से जिस लेखन-शैली में प्रस्तुत किया जाता है, उसे अनुच्छेद-लेखन कहते हैं।\n" +
                "'अनुच्छेद' शब्द अंग्रेजी भाषा के 'Paragraph' शब्द का हिंदी पर्याय है। अनुच्छेद 'निबंध' का संक्षिप्त रूप होता है। इसमें किसी विषय के किसी एक पक्ष पर 80 से 100 शब्दों में अपने विचार व्यक्त किए जाते हैं।\n" +
                "अनुच्छेद अपने-आप में स्वतन्त्र और पूर्ण होते हैं। अनुच्छेद का मुख्य विचार या भाव की कुंजी या तो आरम्भ में रहती है या अन्त में। एक अच्छे अनुच्छेद-लेखन में मुख्य विचार अन्त में दिया जाता है।");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NoticeAdapter(this,arrnoticelist));


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.newsmenu:
                        startActivity(new Intent(NoticeBoardActivity.this,PostNewsActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                    case R.id.noticemenu:
                        return true;

                    case R.id.placementmenu:
                        startActivity(new Intent(NoticeBoardActivity.this, PlacementNewsActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }

                return true;
            }
        });

        slidingRootNav =  new SlidingRootNavBuilder(NoticeBoardActivity.this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withDragDistance(150)
                .withMenuLayout(R.layout.navigationlayout)
                .inject();

        //side bar menus

        //profile ids
        ImageView profileimg = findViewById(R.id.navigation_profileimg);
        TextView profilename = findViewById(R.id.navigation_profilename);
        TextView profilebranch = findViewById(R.id.navigation_branch);
        ImageView viewprofileimg = findViewById(R.id.navigation_viewimg);


        //menu ids
        RelativeLayout ebooklayout,syllabuspaperlayout,timetablelayout,sharelayout,settinglayout,contactlayout,aboutlayout,signoutlayout;

        ebooklayout = findViewById(R.id.navigation_ebooklayout);
        syllabuspaperlayout = findViewById(R.id.navigation_syllabuspaperlayout);
        timetablelayout = findViewById(R.id.navigation_ttlayout);
        sharelayout = findViewById(R.id.navigation_sharelayout);
        settinglayout = findViewById(R.id.navigation_settinglayout);
        contactlayout = findViewById(R.id.navigation_contactlayout);
        aboutlayout = findViewById(R.id.navigation_aboutlayout);
        signoutlayout = findViewById(R.id.navigation_signoutlayout);



        ebooklayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoticeBoardActivity.this,EbooksActivity.class));

            }
        });

        syllabuspaperlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoticeBoardActivity.this,PreviousPapersActivity.class));

            }
        });

        timetablelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoticeBoardActivity.this,TimetableActivity.class));

            }
        });

        sharelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"MBM JODHPUR APP");
                intent.putExtra(Intent.EXTRA_TEXT,"Please download MBM JODHPUR APP in your android mobile");
                startActivity(Intent.createChooser(intent,"Share via"));

            }
        });

        settinglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoticeBoardActivity.this,SettingActivity.class));

            }
        });

        contactlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        aboutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
            }
        });

        signoutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(PlacementNewsActivity.this,EbooksActivity.class));
                slidingRootNav.closeMenu();
            }
        });

    }

    private void addNoticeData(int noticeimg,String text) {

        NoticeSuitcase noticeSuitcase = new NoticeSuitcase();
        noticeSuitcase.img = noticeimg;
        noticeSuitcase.text = text;

        arrnoticelist.add(noticeSuitcase);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.chatmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.chatmenu){
            startActivity(new Intent(NoticeBoardActivity.this,ChatActivity.class));
            return true;
        }
        return false;
    }


    private void initviews() {

        bnv = findViewById(R.id.bnv);

        toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.notice_recyclerview);
    }
}