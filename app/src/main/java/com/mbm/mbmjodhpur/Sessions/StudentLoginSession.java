package com.mbm.mbmjodhpur.Sessions;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.HashMap;

import static com.mbm.mbmjodhpur.ViewUtils.toast;

public class StudentLoginSession {


    public static SharedPreferences stud_Session;

    public SharedPreferences.Editor editor;

    public Context context;

    public static final String IS_STUD_LOGIN = "isLoggedIn";

    public static final String KEY_STUD_ID = "stud_Id";
    public static final String KEY_STUD_NAME = "name";
    public static final String KEY_STUD_EMAIL = "email";
    public static final String KEY_STUD_PHONE = "phone";
    public static final String KEY_STUD_DEPT = "dept";
    public static final String KEY_STUD_DEPT_ID = "deptId";
    public static final String KEY_STUD_IMAGE = "imageUrl";
    public static final String KEY_STUD_STATUS = "status";
    public static final String KEY_STUD_REGNO = "regno";

    public StudentLoginSession(@NonNull Context context){
        this.context = context;

        stud_Session = context.getSharedPreferences("studentLoginSession",Context.MODE_PRIVATE);
        editor = stud_Session.edit();
    }

    public void putStud_Id(String stud_id){
        editor.putString(KEY_STUD_ID,stud_id);
        toast(context,stud_id);
        Log.d("studid",stud_id);

        editor.commit();
    }

    public static String getStud_Id(){

        Log.d("studid",stud_Session.getString(KEY_STUD_ID,null));

        return stud_Session.getString(KEY_STUD_ID,null);
    }

    public void createStudentLoginSession(String name,String regNo , String email,String phone,String branch,String imageurl,String branchid,String status,String studid){

        editor.putBoolean(IS_STUD_LOGIN,true);

//        editor.putString(KEY_STUD_ID,studid);
        editor.putString(KEY_STUD_NAME,name);
        editor.putString(KEY_STUD_REGNO,regNo);
        editor.putString(KEY_STUD_EMAIL,email);
        editor.putString(KEY_STUD_PHONE,phone);
        editor.putString(KEY_STUD_DEPT,branch);
        editor.putString(KEY_STUD_DEPT_ID,branchid);
        editor.putString(KEY_STUD_IMAGE,imageurl);
        editor.putString(KEY_STUD_STATUS,status);

        editor.commit();

    }

    @NonNull
    public HashMap<String,String> getStudentDetailsFromSession(){

        HashMap<String,String> studentDetails = new HashMap<>();

        studentDetails.put(KEY_STUD_NAME,stud_Session.getString(KEY_STUD_NAME,null));
        studentDetails.put(KEY_STUD_EMAIL,stud_Session.getString(KEY_STUD_EMAIL,null));
        studentDetails.put(KEY_STUD_PHONE,stud_Session.getString(KEY_STUD_PHONE,null));
        studentDetails.put(KEY_STUD_REGNO,stud_Session.getString(KEY_STUD_REGNO,null));
        studentDetails.put(KEY_STUD_DEPT_ID,stud_Session.getString(KEY_STUD_DEPT_ID,null));
        studentDetails.put(KEY_STUD_DEPT,stud_Session.getString(KEY_STUD_DEPT,null));
        studentDetails.put(KEY_STUD_IMAGE,stud_Session.getString(KEY_STUD_IMAGE,null));
//        studentDetails.put(KEY_STUD_ID,stud_Session.getString(KEY_STUD_ID,null));
        studentDetails.put(KEY_STUD_STATUS,stud_Session.getString(KEY_STUD_STATUS,null));

        return studentDetails;
    }

    public boolean checkStudentLogin(){
        return stud_Session.getBoolean(IS_STUD_LOGIN, false);
    }

    public void logoutStudentSession(){
        editor.clear();
        editor.commit();
    }
}
