package com.mbm.mbmjodhpur.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.mbm.mbmjodhpur.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class ProfileActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    CircularImageView profileimg;
    ImageView backimg,emaileditimg,mobeditimg;
    TextView txtname, txtemail, txtmob, txtbranch, txtedit;

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
                startActivityForResult(intent, 100);
            }
        });



        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ProfileActivity.this, R.style.BottomSheetDialogTheme);

        emaileditimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View bottomsheetview = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.emailbottomsheetlayout, (LinearLayout) findViewById(R.id.emailbottomlayout));

                bottomsheetview.findViewById(R.id.emailbottom_btnsave).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextInputEditText edtemail = bottomsheetview.findViewById(R.id.emailbottom_edtemail);
                        if (edtemail.getText().toString().equals("")){
                            edtemail.setError("enter email id");
                        }else {
                            Toast.makeText(ProfileActivity.this, "Email-id changed successfully", Toast.LENGTH_SHORT).show();

                            bottomSheetDialog.dismiss();
                        }
                    }
                });

                bottomSheetDialog.setContentView(bottomsheetview);
                bottomSheetDialog.show();

            }
        });

        mobeditimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View bottomsheetview = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.phonebottomsheetlayout, (LinearLayout) findViewById(R.id.phonebottomlayout));

                bottomsheetview.findViewById(R.id.mobbottom_btnsave).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextInputEditText edtemail = bottomsheetview.findViewById(R.id.mobbottom_edtmob);
                        if (edtemail.getText().toString().equals("")){
                            edtemail.setError("enter email id");
                        }else {
                            Toast.makeText(ProfileActivity.this, "Mobile no. changed successfully", Toast.LENGTH_SHORT).show();

                            bottomSheetDialog.dismiss();
                        }
                    }
                });

                bottomSheetDialog.setContentView(bottomsheetview);
                bottomSheetDialog.show();
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

        emaileditimg = findViewById(R.id.profile_emaileditimg);
        mobeditimg = findViewById(R.id.profile_mobeditimg);

//        txtedit = findViewById(R.id.profile_edit);
    }
}