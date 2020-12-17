package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.R;

public class FullPlacementnewsActivity extends AppCompatActivity {

    MaterialToolbar toolbar;
    ImageView backimg;
    TextView txtlink,txtnews,txtcmptitle,txtlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_placementnews);

        initviews();
    }

    private void initviews() {

        toolbar = findViewById(R.id.fplacement_toolbar);

        backimg = findViewById(R.id.fplacement_backimg);

        txtcmptitle = findViewById(R.id.fplacement_txtcmptitle);
        txtlink = findViewById(R.id.fplacement_txtlink);
        txtnews = findViewById(R.id.fplacement_txtnews);
        txtlist = findViewById(R.id.fplacement_txtlist);


    }
}