package com.mbm.mbmjodhpur.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.mbm.mbmjodhpur.ModelResponse.GetAdminOtpResponse;
import com.mbm.mbmjodhpur.ModelResponse.GetStudentOtpResponse;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mbm.mbmjodhpur.ViewUtils.toast;


public class EmailVerifyActivity extends AppCompatActivity {


    public static final String TAG = "EmailVerifyActivity";

    TextInputEditText edtEmail;

    MaterialButton btnGetOtp;

    ProgressBar progressBar;

    MaterialCheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verify);


        initViews();

        progressBar.setVisibility(View.GONE);

        btnGetOtp.setOnClickListener(v -> {
            if (!Patterns.EMAIL_ADDRESS.matcher(Objects.requireNonNull(edtEmail.getText()).toString()).matches()){
                edtEmail.setError("Please enter a Valid E-Mail Address!");
            }else if (checkBox.isChecked()){
                sendOtpToAdminEmail();
            }else {
                sendOtpToStudentEmail();
            }
        });

    }

    public void sendOtpToAdminEmail(){

        progressBar.setVisibility(View.VISIBLE);
        Call<GetAdminOtpResponse> getOtpResponseCall = RetrofitClient.getInstance().getapi().sendAdminOtp(Objects.requireNonNull(edtEmail.getText()).toString());

        getOtpResponseCall.enqueue(new Callback<GetAdminOtpResponse>() {
            @Override
            public void onResponse(@NotNull Call<GetAdminOtpResponse> call, @NotNull Response<GetAdminOtpResponse> response) {

                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful()){
                    if (response.body() != null){
                        if (response.body().getStatus() == 1){

                            Log.d(TAG ,response.body().getMessage());

                            toast(EmailVerifyActivity.this,response.body().getMessage());
                            Intent intent = new Intent(EmailVerifyActivity.this, OtpVerifyActivity.class);
                            intent.putExtra("email",edtEmail.getText().toString());
                            intent.putExtra("data",response.body().getData());
                            intent.putExtra("admin",true);
                            startActivity(intent);

                        }else {
                            edtEmail.setError(response.body().getMessage());
                            toast(EmailVerifyActivity.this,response.message());
                            Log.d(TAG ,response.body().getMessage());
                        }

                    }else {
                        toast(EmailVerifyActivity.this,response.message());
                        Log.d(TAG ,response.message());
                    }
                }
            }

            @SuppressLint("LogConditional")
            @Override
            public void onFailure(@NotNull Call<GetAdminOtpResponse> call, @NotNull Throwable t) {

                progressBar.setVisibility(View.GONE);

                toast(EmailVerifyActivity.this,"Something wents wrong");
                Log.d(TAG,t.getLocalizedMessage());
            }
        });


    }

    public void sendOtpToStudentEmail(){

        progressBar.setVisibility(View.VISIBLE);
        Call<GetStudentOtpResponse> getOtpResponseCall = RetrofitClient.getInstance().getapi().sendStudentOtp(Objects.requireNonNull(edtEmail.getText()).toString());

        getOtpResponseCall.enqueue(new Callback<GetStudentOtpResponse>() {
            @Override
            public void onResponse(@NotNull Call<GetStudentOtpResponse> call, @NotNull Response<GetStudentOtpResponse> response) {

                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful()){
                    if (response.body() != null){
                        if (response.body().getStatus() == 1){

                            Log.d(TAG ,response.body().getMessage());

                            toast(EmailVerifyActivity.this,response.body().getMessage());
                            Intent intent = new Intent(EmailVerifyActivity.this, OtpVerifyActivity.class);
                            intent.putExtra("email",edtEmail.getText().toString());
                            intent.putExtra("data",response.body().getData());
                            intent.putExtra("admin",false);
                            startActivity(intent);

                        }else {
                            edtEmail.setError(response.body().getMessage());
                            toast(EmailVerifyActivity.this,response.message());
                            Log.d(TAG ,response.body().getMessage());
                        }

                    }else {
                        toast(EmailVerifyActivity.this,response.message());
                        Log.d(TAG ,response.message());
                    }
                }
            }

            @SuppressLint("LogConditional")
            @Override
            public void onFailure(@NotNull Call<GetStudentOtpResponse> call, @NotNull Throwable t) {

                progressBar.setVisibility(View.GONE);

                toast(EmailVerifyActivity.this,"Something wents wrong");
                Log.d(TAG,t.getLocalizedMessage());
            }
        });


    }

    private void initViews() {

        edtEmail = findViewById(R.id.email_edtemailid);

        btnGetOtp = findViewById(R.id.email_btnget);

        progressBar = findViewById(R.id.email_progressbar);

        checkBox = findViewById(R.id.email_checkbox);

    }
}
