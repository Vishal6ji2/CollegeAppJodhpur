package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbm.mbmjodhpur.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class ProfileActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    CircularImageView profileimg;
    ImageView backimg;
    TextView txtname,txtemail,txtmob,txtbranch,txtedit;

    FloatingActionButton cameraimg;

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

        cameraimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,100);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 100 && resultCode == RESULT_OK && data != null){

            Uri uri = data.getData();

            Glide.with(this).load(uri).placeholder(R.drawable.mbmlogo).into(profileimg);

        }

        super.onActivityResult(requestCode, resultCode, data);
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

        txtedit = findViewById(R.id.profile_edit);
    }
}