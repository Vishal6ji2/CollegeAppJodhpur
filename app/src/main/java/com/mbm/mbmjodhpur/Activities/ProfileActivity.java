package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class ProfileActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    CircularImageView profileimg;
    ImageView cameraimg,backimg;
    TextView txtname,txtemail,txtmob,txtbranch,txtsem,txtedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initviews();

        setSupportActionBar(toolbar);

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initviews() {

        toolbar = findViewById(R.id.profile_toolbar);

        profileimg = findViewById(R.id.profile_profileimg);

        cameraimg = findViewById(R.id.profile_cameraimg);
        backimg = findViewById(R.id.profile_backimg);

        txtname = findViewById(R.id.profile_txtname);
        txtemail = findViewById(R.id.profile_txtemail);
        txtmob = findViewById(R.id.profile_txtmob);
        txtbranch = findViewById(R.id.profile_txtbranch);
        txtsem = findViewById(R.id.profile_txtsem);
        txtedit = findViewById(R.id.profile_edit);
    }
}