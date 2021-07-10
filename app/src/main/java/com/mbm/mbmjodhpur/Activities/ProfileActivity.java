package com.mbm.mbmjodhpur.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Sessions.AdminDashboardSession;
import com.mbm.mbmjodhpur.Sessions.AdminLoginSession;
import com.mbm.mbmjodhpur.Sessions.StudentDashboardSession;
import com.mbm.mbmjodhpur.Sessions.StudentLoginSession;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppAdminResponse;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.KEY_ADMIN_DEPT;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.KEY_ADMIN_EMAIL;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.KEY_ADMIN_IMAGE;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.KEY_ADMIN_NAME;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.KEY_ADMIN_PHONE;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_DEPT;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_EMAIL;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_IMAGE;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_NAME;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_PHONE;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_REGNO;

public class ProfileActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    ShapeableImageView profileimg;

    TextView txtname, txtemail, txtmob, txtbranch, txtregno, txtreg, txteditemail, txteditmob;

    FloatingActionButton edtImageFab;

    StudentLoginSession studentLoginSession;

    AdminLoginSession adminLoginSession;

    AdminDashboardSession adminDashboardSession;

    StudentDashboardSession studentDashboardSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initviews();

        setSupportActionBar(toolbar);


        studentDashboardSession = new StudentDashboardSession(this);
        adminDashboardSession = new AdminDashboardSession(this);

        if (user.equals("student")){
            getStudentAppResponse(this);
        }else if (user.equals("admin")){
            getStudentAppAdminResponse(this);
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        if (user.equals("student")){
            getStudentDetails();
        }else if (user.equals("admin")){
            getAdminDetails();
        }

        ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        // your operation....
                        if (data != null){

                            Uri uri = data.getData();

                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
                                byte[] imgbyte = baos.toByteArray();

                                String encodedimage = Base64.encodeToString(imgbyte,Base64.DEFAULT);
                                Log.d("encodedimg",encodedimage);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            Glide.with(this).load(uri).placeholder(R.drawable.mbmlogo).into(profileimg);

                        }
                    }
                });


        edtImageFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            launchSomeActivity.launch(intent);
        });



        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ProfileActivity.this, R.style.BottomSheetDialogTheme);

        txteditemail.setOnClickListener((View.OnClickListener) v -> {
            final View bottomsheetview = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.emailbottomsheetlayout, (LinearLayout) findViewById(R.id.emailbottomlayout));

            bottomsheetview.findViewById(R.id.emailbottom_btnsave).setOnClickListener(v1 -> {

                TextInputEditText edtemail = bottomsheetview.findViewById(R.id.emailbottom_edtemail);
                if (edtemail.getText().toString().equals("")){
                    edtemail.setError("enter email id");
                }else {
                    Toast.makeText(ProfileActivity.this, "Email-id changed successfully", Toast.LENGTH_SHORT).show();

                    bottomSheetDialog.dismiss();
                }
            });

            bottomSheetDialog.setContentView(bottomsheetview);
            bottomSheetDialog.show();

        });

        txteditmob.setOnClickListener((View.OnClickListener) v -> {
            final View bottomsheetview = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.phonebottomsheetlayout, (LinearLayout) findViewById(R.id.phonebottomlayout));

            bottomsheetview.findViewById(R.id.mobbottom_btnsave).setOnClickListener(v12 -> {

                TextInputEditText edtemail = bottomsheetview.findViewById(R.id.mobbottom_edtmob);
                if (edtemail.getText().toString().equals("")){
                    edtemail.setError("enter mobile no.");
                }else {
                    Toast.makeText(ProfileActivity.this, "Mobile no. changed successfully", Toast.LENGTH_SHORT).show();

                    bottomSheetDialog.dismiss();
                }
            });

            bottomSheetDialog.setContentView(bottomsheetview);
            bottomSheetDialog.show();
        });


    }

    private void getAdminDetails() {

        adminLoginSession = new AdminLoginSession(this);

        HashMap<String,String> loginDetails = adminLoginSession.getAdminDetailsFromSession();

        String name = loginDetails.get(KEY_ADMIN_NAME);
        String deptName = loginDetails.get(KEY_ADMIN_DEPT);
//        String regNo = loginDetails.get(KEY_STUD_REGNO);
        String email = loginDetails.get(KEY_ADMIN_EMAIL);
        String mobile = loginDetails.get(KEY_ADMIN_PHONE);
        String imageUrl = loginDetails.get(KEY_ADMIN_IMAGE);

        txtreg.setVisibility(View.GONE);
        txtregno.setVisibility(View.GONE);

        txtname.setText(name);
        txtbranch.setText(deptName);
        txtemail.setText(email);
        txtmob.setText(mobile);

        Glide.with(this).load(Uri.parse(imageUrl)).into(profileimg);

    }

    private void getStudentDetails() {
        studentLoginSession = new StudentLoginSession(this);

        HashMap<String,String> loginDetails = studentLoginSession.getStudentDetailsFromSession();


        String name = loginDetails.get(KEY_STUD_NAME);
        String deptName = loginDetails.get(KEY_STUD_DEPT);
        String regNo = loginDetails.get(KEY_STUD_REGNO);
        String email = loginDetails.get(KEY_STUD_EMAIL);
        String mobile = loginDetails.get(KEY_STUD_PHONE);
        String imageUrl = loginDetails.get(KEY_STUD_IMAGE);

        txtreg.setVisibility(View.VISIBLE);
        txtregno.setVisibility(View.VISIBLE);

        txtname.setText(name);
        txtbranch.setText(deptName);
        txtemail.setText(email);
        txtmob.setText(mobile);
        txtregno.setText(regNo);


        Glide.with(this).load(Uri.parse(imageUrl)).into(profileimg);
    }


    private void initviews() {

        toolbar = findViewById(R.id.profile_toolbar);

        profileimg = findViewById(R.id.profile_profileimg);

        edtImageFab = findViewById(R.id.profile_cameraimg);

        txtname = findViewById(R.id.profile_txtname);
        txtemail = findViewById(R.id.profile_txtemail);
        txtmob = findViewById(R.id.profile_txtmob);
        txtbranch = findViewById(R.id.profile_txtbranch);
        txtregno = findViewById(R.id.profile_txtregno);
        txtreg = findViewById(R.id.profile_txtreg);

        txteditemail = findViewById(R.id.profile_txteditemail);
        txteditmob = findViewById(R.id.profile_txteditmob);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}