package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.mbm.mbmjodhpur.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    ImageView backimg;

    TextInputEditText edtemail;

    MaterialButton btnrecoverpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initviews();

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnrecoverpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtemail.getText().toString().equals("")){
                    edtemail.setError("Please enter valid email id");
                }else {
                    Toast.makeText(ForgotPasswordActivity.this, "Password reset link send successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPasswordActivity.this,ResetPasswordActivity.class));
                    finish();
                }
            }
        });
    }

    private void initviews() {

        toolbar = findViewById(R.id.forgot_toolbar);

        backimg = findViewById(R.id.forgot_backimg);

        edtemail = findViewById(R.id.forgot_edtemail);

        btnrecoverpwd = findViewById(R.id.forgot_btnrecpwd);

    }
}