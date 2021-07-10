package com.mbm.mbmjodhpur.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.mbm.mbmjodhpur.ModelResponse.GetAdminOtpResponse;
import com.mbm.mbmjodhpur.ModelResponse.GetStudentOtpResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.ModelResponse.VerifyAdminOtpResponse;
import com.mbm.mbmjodhpur.ModelResponse.VerifyStudentOtpResponse;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.RetrofitClient;
import com.mbm.mbmjodhpur.Sessions.AdminLoginSession;
import com.mbm.mbmjodhpur.Sessions.StudentDashboardSession;
import com.mbm.mbmjodhpur.Sessions.StudentLoginSession;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.flag;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminLibraryData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminLinksData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminNewsFeedData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminNoticeData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminPlacementData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminSubjectData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminSyllabusData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getAdminTimetableData;
import static com.mbm.mbmjodhpur.Activities.HomeActivity.getStudentData;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.getAdmin_Id;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.getStud_Id;
import static com.mbm.mbmjodhpur.ViewUtils.toast;


public class OtpVerifyActivity extends AppCompatActivity {

    public static final String TAG = "OtpVerifyActivity";

    MaterialToolbar toolbar;

    MaterialButton btnVerify;

    TextView txtSend, txtTime, txtEmail;

    CountDownTimer countDownTimer;

    EditText otpEt1 ,otpEt2 ,otpEt3 ,otpEt4 ,otpEt5 ,otpEt6 ;

    ProgressBar progressBar;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    AdminLoginSession adminLoginSession;

    StudentLoginSession studentLoginSession;

    Intent intent;

    String intentEmail, strOtp;

    int inputData;

    boolean admin = false;

    static boolean login = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);


        initViews();

        sessionOtpFailed();

        txtSend.setEnabled(false);
        txtSend.setTextColor(ContextCompat.getColor(this, R.color.colordarkgrey));

        toolbar.setNavigationOnClickListener(v -> finish());

        intent = getIntent();

        if (intent != null) {
            if (intent.getStringExtra("email") != null) {
                intentEmail = intent.getStringExtra("email");
                txtEmail.setText(intent.getStringExtra("email"));
                inputData = intent.getIntExtra("data", 0);
                admin = intent.getBooleanExtra("admin", false);
            }
        }

        progressBar.setVisibility(View.GONE);

        btnVerify.setOnClickListener(v -> {

            getEdtOtp();

            if (otpEt1.getText().toString().equals("")
                    || otpEt2.getText().toString().equals("")
                    || otpEt3.getText().toString().equals("")
                    || otpEt4.getText().toString().equals("")
                    || otpEt5.getText().toString().equals("")
                    || otpEt6.getText().toString().equals("")){

                toast(OtpVerifyActivity.this,"Enter Correct Otp");

            }else if (admin){
                verifyAdminOtpResponse(strOtp);
            }else {
                verifyStudentOtpResponse(strOtp);
            }
        });

        txtSend.setOnClickListener(v -> {
            if (admin){
                sendOtpToAdminEmail();
            }else {
                sendOtpToStudentEmail();
            }
        });


    }

    void sessionOtpFailed () {

            txtTime.setVisibility(View.VISIBLE);

            countDownTimer = new CountDownTimer(3 * 60 * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    String sDuration = String.format(Locale.ENGLISH, "%02d:%02d"
                            , TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                            , TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                    txtTime.setText(sDuration);

                }

                @Override
                public void onFinish() {

                    txtTime.setVisibility(View.GONE);

                    txtSend.setEnabled(true);
                    txtSend.setTextColor(ContextCompat.getColor(OtpVerifyActivity.this, R.color.colorAccent));

                }
            }.start();

        }

    public void sendOtpToAdminEmail () {

            progressBar.setVisibility(View.VISIBLE);
            Call<GetAdminOtpResponse> getOtpResponseCall = RetrofitClient.getInstance().getapi().sendAdminOtp(intentEmail);

            getOtpResponseCall.enqueue(new Callback<GetAdminOtpResponse>() {
                @Override
                public void onResponse(@NotNull Call<GetAdminOtpResponse> call, @NotNull Response<GetAdminOtpResponse> response) {

                    progressBar.setVisibility(View.GONE);

                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {

                                txtSend.setEnabled(false);
                                txtSend.setTextColor(ContextCompat.getColor(OtpVerifyActivity.this, R.color.colordarkgrey));

                                inputData = response.body().getData();

                                Log.d(TAG, response.body().getMessage());
                                sessionOtpFailed();

                                toast(OtpVerifyActivity.this, response.body().getMessage());


                            } else {
                                toast(OtpVerifyActivity.this, response.body().getMessage());
                                Log.d(TAG, response.body().getMessage());
                            }

                        } else {
                            toast(OtpVerifyActivity.this, response.message());
                            Log.d(TAG, response.message());
                        }
                    }
                }

                @SuppressLint("LogConditional")
                @Override
                public void onFailure(@NotNull Call<GetAdminOtpResponse> call, @NotNull Throwable t) {

                    progressBar.setVisibility(View.GONE);

                    toast(OtpVerifyActivity.this, "Something wents wrong");
                    Log.d(TAG, t.getLocalizedMessage());
                }
            });

        }

    public void sendOtpToStudentEmail () {

            progressBar.setVisibility(View.VISIBLE);
            Call<GetStudentOtpResponse> getOtpResponseCall = RetrofitClient.getInstance().getapi().sendStudentOtp(intentEmail);

            getOtpResponseCall.enqueue(new Callback<GetStudentOtpResponse>() {
                @Override
                public void onResponse(@NotNull Call<GetStudentOtpResponse> call, @NotNull Response<GetStudentOtpResponse> response) {

                    progressBar.setVisibility(View.GONE);

                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {

                                txtSend.setEnabled(false);
                                txtSend.setTextColor(ContextCompat.getColor(OtpVerifyActivity.this, R.color.colordarkgrey));

                                inputData = response.body().getData();

                                Log.d(TAG, response.body().getMessage());
                                sessionOtpFailed();

                                toast(OtpVerifyActivity.this, response.body().getMessage());


                            } else {
                                toast(OtpVerifyActivity.this, response.body().getMessage());
                                Log.d(TAG, response.body().getMessage());
                            }

                        } else {
                            toast(OtpVerifyActivity.this, response.message());
                            Log.d(TAG, response.message());
                        }
                    }
                }

                @SuppressLint("LogConditional")
                @Override
                public void onFailure(@NotNull Call<GetStudentOtpResponse> call, @NotNull Throwable t) {

                    progressBar.setVisibility(View.GONE);

                    toast(OtpVerifyActivity.this, "Something wents wrong");
                    Log.d(TAG, t.getLocalizedMessage());
                }
            });


        }

    public void verifyStudentOtpResponse (@NonNull String otp){

            Call<VerifyStudentOtpResponse> otpVerifyCall = RetrofitClient.getInstance()
                    .getapi()
                    .otpStudentVerify(inputData, otp);

            progressBar.setVisibility(View.VISIBLE);

            otpVerifyCall.clone().enqueue(new Callback<VerifyStudentOtpResponse>() {
                @Override
                public void onResponse(@NotNull Call<VerifyStudentOtpResponse> call, @NotNull Response<VerifyStudentOtpResponse> response) {

                    progressBar.setVisibility(View.GONE);

                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                toast(OtpVerifyActivity.this, response.body().getMessage());
                                getStudId_Details(response.body().getData());
                                Log.d(TAG,response.body().getData().get(0).toString());

                                Log.d(TAG, response.body().getMessage());
                            } else {
                                toast(OtpVerifyActivity.this, response.body().getMessage());
                                Log.d(TAG, response.body().getMessage());
                            }

                        } else {
                            toast(OtpVerifyActivity.this, response.message());
                            Log.d(TAG, response.message());
                        }
                    }
                }

                @SuppressLint("LogConditional")
                @Override
                public void onFailure(@NotNull Call<VerifyStudentOtpResponse> call, @NotNull Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    toast(OtpVerifyActivity.this, "Something wents wrong");
                    Log.d(TAG, t.getLocalizedMessage());

                }
            });

        }

    public void verifyAdminOtpResponse (@NonNull String otp){

            Call<VerifyAdminOtpResponse> otpVerifyCall = RetrofitClient.getInstance()
                    .getapi()
                    .otpAdminVerify(inputData, otp);

            progressBar.setVisibility(View.VISIBLE);

            otpVerifyCall.clone().enqueue(new Callback<VerifyAdminOtpResponse>() {
                @Override
                public void onResponse(@NotNull Call<VerifyAdminOtpResponse> call, @NotNull Response<VerifyAdminOtpResponse> response) {

                    progressBar.setVisibility(View.GONE);

                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                toast(OtpVerifyActivity.this, response.body().getMessage());

                                getAdminId_Details(response.body().getData().getAdmin());

                                Log.d(TAG, response.body().getMessage());
                            } else {
                                toast(OtpVerifyActivity.this, response.body().getMessage());
                                Log.d(TAG, response.body().getMessage());
                            }

                        } else {
                            toast(OtpVerifyActivity.this, response.message());
                            Log.d(TAG, response.message());
                        }
                    }
                }

                @SuppressLint("LogConditional")
                @Override
                public void onFailure(@NotNull Call<VerifyAdminOtpResponse> call, @NotNull Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    toast(OtpVerifyActivity.this, "Something wents wrong");
                    Log.d(TAG, t.getLocalizedMessage());

                }
            });

        }

    private void getAdminId_Details(ArrayList<VerifyAdminOtpResponse.Data.Admin> adminData) {

        adminLoginSession = new AdminLoginSession(OtpVerifyActivity.this);

        String admin_Id = adminData.get(0).getId();
        //        name = profiles.get(0).getName();
//        email = profiles.get(0).getEmail();
//        phone = profiles.get(0).getMobile();
//        branch = profiles.get(0).getDepartmentName();
//        branch_Id = profiles.get(0).getDeptId();
        //        imageUrl = profiles.get(0).getProfile();
//        status = profiles.get(0).getStatus();
        adminLoginSession.putAdmin_Id(admin_Id);

        getStudentAppAdminResponse(this);

        if (flag) {
            countDownTimer.cancel();
            sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
            editor.putString("user","admin");
            editor.commit();
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }

    public void getStudId_Details (@NonNull ArrayList < VerifyStudentOtpResponse.StudentData > studentData) {

        studentLoginSession = new StudentLoginSession(OtpVerifyActivity.this);

//        name = profiles.get(0).getName();
//        email = profiles.get(0).getEmail();
//        phone = profiles.get(0).getMobile();
//        stud_DepartmentName = studentData.get(0).getDepartmentName();
//        branch_Id = profiles.get(0).getDeptId();
        String stud_Id = studentData.get(0).getId();
//        imageUrl = profiles.get(0).getProfile();
//        status = profiles.get(0).getStatus();
        studentLoginSession.putStud_Id(stud_Id);
        getStudentAppResponse(this);

        if (login) {
            countDownTimer.cancel();

            sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("user","student");
            editor.apply();

            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }

    }

    public static void getStudentAppAdminResponse(Context context) {

        Call<StudentAppAdminResponse> studentAppResponseCall = RetrofitClient.getInstance().getapi().studentAppAdminResponse(getAdmin_Id());

        studentAppResponseCall.enqueue(new Callback<StudentAppAdminResponse>() {
            @Override
            public void onResponse(@NotNull Call<StudentAppAdminResponse> call, @NotNull Response<StudentAppAdminResponse> response) {

                if (response.isSuccessful()){
                    if (response.body()!= null){
                        if (response.body().getStatus() == 1){
                            flag = true;
                            getAdminData(response.body().getData().getAdmin(), context);
                            getAdminLinksData(response.body().getData().getLink(), context);
                            getAdminNewsFeedData(response.body().getData().getNews(), context);
                            getAdminNoticeData(response.body().getData().getNoticeboard(), context);
                            getAdminPlacementData(response.body().getData().getPlacement(), context);
                            getAdminLibraryData(response.body().getData().getLibrary(), context);
                            getAdminSubjectData(response.body().getData().getSubject(), context);
                            getAdminSyllabusData(response.body().getData().getSyllabus(), context);
                            getAdminTimetableData(response.body().getData().getTimetable(), context);

                            toast(context,"Student Dashboard Updated");

                        }else {
                            flag = false;
                            toast(context,"Student Dashboard Not successful");
                        }
                    }else {
                        flag = false;
                        toast(context,"Student Dashboard Not successful");
                    }
                }else {
                    flag = false;
                    toast(context,"Student Dashboard Not successful");
                }
            }

            @Override
            public void onFailure(@NotNull Call<StudentAppAdminResponse> call, @NotNull Throwable t) {

                flag = false;
                Log.d("StudentAppDashboard",t.getLocalizedMessage());
                toast(context,"Something went wrong");

            }
        });

    }

    public static void getStudentAppResponse(Context context) {

        Call<StudentAppResponse> studentAppResponseCall = RetrofitClient.getInstance().getapi().studentAppResponse(getStud_Id());

        studentAppResponseCall.enqueue(new Callback<StudentAppResponse>() {
            @Override
            public void onResponse(@NotNull Call<StudentAppResponse> call, @NotNull Response<StudentAppResponse> response) {

                if (response.isSuccessful()){
                    if (response.body()!= null){
                        if (response.body().getStatus() == 1){
                            flag = true;
                            getStudentData(response.body().getData().getStudent(), context);
                            StudentDashboardSession.put_LinksList(response.body().getData().getLink());
                            StudentDashboardSession.put_NewsFeedList(response.body().getData().getNews());
                            StudentDashboardSession.put_NoticeList(response.body().getData().getNoticeboard());
                            StudentDashboardSession.put_PlacementList(response.body().getData().getNewsPlacement());
                            StudentDashboardSession.put_LibraryList(response.body().getData().getLibrary());
                            StudentDashboardSession.put_SubjectList(response.body().getData().getSubject());
                            StudentDashboardSession.put_SyllabusList(response.body().getData().getSyllabus());
                            StudentDashboardSession.put_TimetableList(response.body().getData().getTimetable());

                            toast(context,"Student Dashboard Updated");
                            login = true;

                        }else {
                            login = false;
                            toast(context,"Student Dashboard Not successful");
                        }
                    }else {
                        login = false;
                        toast(context,"Student Dashboard Not successful");
                    }
                }else {
                    login = false;
                    toast(context,"Student Dashboard Not successful");
                }
            }

            @Override
            public void onFailure(@NotNull Call<StudentAppResponse> call, @NotNull Throwable t) {

                login = false;
                Log.d("StudentAppDashboard",t.getLocalizedMessage());
                toast(context,"Something went wrong");

            }
        });

    }

    private void initViews () {

            toolbar = findViewById(R.id.otp_toolbar);

            progressBar = findViewById(R.id.otp_progressbar);

            btnVerify = findViewById(R.id.otp_btnverify);

            txtSend = findViewById(R.id.otp_txtsendotp);
            txtTime = findViewById(R.id.otp_txttime);
            txtEmail = findViewById(R.id.otp_txtemail);

            otpEt1 = findViewById(R.id.otp_edtcode1);
            otpEt2 = findViewById(R.id.otp_edtcode2);
            otpEt3 = findViewById(R.id.otp_edtcode3);
            otpEt4 = findViewById(R.id.otp_edtcode4);
            otpEt5 = findViewById(R.id.otp_edtcode5);
            otpEt6 = findViewById(R.id.otp_edtcode6);


        }

    public void getEdtOtp(){

        strOtp = otpEt1.getText().toString()
                + otpEt2.getText().toString()
                +otpEt3.getText().toString()
                +otpEt4.getText().toString()
                +otpEt5.getText().toString()
                +otpEt6.getText().toString();

        }

}
