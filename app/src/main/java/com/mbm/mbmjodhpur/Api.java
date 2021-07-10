package com.mbm.mbmjodhpur;

import androidx.annotation.NonNull;

import com.mbm.mbmjodhpur.ModelResponse.GetAdminOtpResponse;
import com.mbm.mbmjodhpur.ModelResponse.GetStudentOtpResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.ModelResponse.VerifyAdminOtpResponse;
import com.mbm.mbmjodhpur.ModelResponse.VerifyStudentOtpResponse;
import com.mbm.mbmjodhpur.Suitcases.DeptSuitcase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    //Student App Data Api
    @GET("student/dashboard")
    Call<StudentAppResponse> studentAppResponse(
      @Query("id") String stud_id
    );


    @NonNull
    @FormUrlEncoded
    @POST("student/sendotp")
    Call<GetStudentOtpResponse> sendStudentOtp(
            @Field("email") String student_email
    );

    @NonNull
    @FormUrlEncoded
    @POST("student/verifyotp")
    Call<VerifyStudentOtpResponse> otpStudentVerify(
            @Field("id") int student_id,
            @Field("otp") String student_otp
    );


    //Admin Data Api
    @GET("admin/dashboard")
    Call<StudentAppAdminResponse> studentAppAdminResponse(
            @Query("id") String admin_id
    );

    @NonNull
    @FormUrlEncoded
    @POST("admin/sendotp")
    Call<GetAdminOtpResponse> sendAdminOtp(
            @Field("email") String admin_email
    );

    @NonNull
    @FormUrlEncoded
    @POST("admin/verifyotp")
    Call<VerifyAdminOtpResponse> otpAdminVerify(
            @Field("id") int admin_id,
            @Field("otp") String admin_otp
    );

    @POST("depatmentfetch.php")
    Call<List<DeptSuitcase>> fetchdeptdata();
}
