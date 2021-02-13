package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

    AppCompatSpinner spinnerbranch;

    TextInputEditText edtname,edtemail,edtmob,edtpassword;

    MaterialButton btnregister;

    TextView txtlogin;
    Toast toast;

    ArrayList<String> arrspinbranch = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initviews();

        arrspinbranch.add(0,"Select Branch");
        arrspinbranch.add(" COMPUTER SCIENCE & TECHNOLOGY");
        arrspinbranch.add(" MECHANICAL ENGINEERING");
        arrspinbranch.add("ELECTRONICS ENGINEERING");
        arrspinbranch.add("ELECTRICAL ENGINEERING");
        arrspinbranch.add("MINING ENGINEERING");
        arrspinbranch.add("ARCHITECTURE ENGINEERING");
        arrspinbranch.add("MCA");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arrspinbranch);

        spinnerbranch.setAdapter(arrayAdapter);


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtname.getText().toString().equals("") && edtemail.getText().toString().equals("")
                    && edtmob.getText().toString().equals("") && edtpassword.getText().toString().equals("")
                    && spinnerbranch.getSelectedItemPosition() == 0){
                    toast = Toast.makeText(RegistrationActivity.this,"Please Enter your Credentials",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();

                }else {
                    toast = Toast.makeText(RegistrationActivity.this,"Register Successfully",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                    finish();
                }
            }
        });

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                overridePendingTransition(0,0);
                finish();
            }
        });

    }

    private void initviews() {

        spinnerbranch = findViewById(R.id.register_spinbranch);

        edtname = findViewById(R.id.register_edtname);
        edtmob = findViewById(R.id.register_edtmobile);
        edtemail = findViewById(R.id.register_edtemailid);
        edtpassword = findViewById(R.id.register_edtpassword);

        btnregister = findViewById(R.id.register_btnregister);

        txtlogin = findViewById(R.id.register_txtlogin);
    }
}