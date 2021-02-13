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

public class ResetPasswordActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    ImageView backimg;

    TextInputEditText edtpwd,edtrepwd;

    MaterialButton btnsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        initviews();

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtpwd.getText().toString().equals("") && !edtpwd.getText().toString().equals(edtrepwd.getText().toString())){

                    edtrepwd.setError("Password doesn't match");
                }else {
                    Toast.makeText(ResetPasswordActivity.this, "New password saved successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ResetPasswordActivity.this,LoginActivity.class));
                    finish();
                }
            }
        });

    }

    private void initviews() {

        toolbar = findViewById(R.id.reset_toolbar);

        backimg = findViewById(R.id.reset_backimg);

        edtpwd = findViewById(R.id.reset_edtpwd);
        edtrepwd = findViewById(R.id.reset_edtrepwd);

        btnsave = findViewById(R.id.reset_btnsavepwd);
    }
}