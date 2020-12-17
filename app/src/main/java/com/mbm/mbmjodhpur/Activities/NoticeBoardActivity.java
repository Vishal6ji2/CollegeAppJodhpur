package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.NoticeAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.NoticeSuitcase;

import java.util.ArrayList;

public class NoticeBoardActivity extends AppCompatActivity {


    ImageView backimg;

    MaterialToolbar toolbar;

    RecyclerView recyclerView;
    ArrayList<NoticeSuitcase> arrnoticelist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        initviews();

        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Notice Board");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

    }

    private void addNoticeData(int noticeimg,String text) {

        NoticeSuitcase noticeSuitcase = new NoticeSuitcase();
        noticeSuitcase.img = noticeimg;
        noticeSuitcase.text = text;

        arrnoticelist.add(noticeSuitcase);
    }

    private void initviews() {

        backimg = findViewById(R.id.notice_backimg);

        toolbar = findViewById(R.id.notice_toolbar);

        recyclerView = findViewById(R.id.notice_recyclerview);
    }
}