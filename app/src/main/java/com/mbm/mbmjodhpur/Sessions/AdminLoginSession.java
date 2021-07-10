package com.mbm.mbmjodhpur.Sessions;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class AdminLoginSession {

    public static SharedPreferences admin_Session;

    public SharedPreferences.Editor editor;

    public Context context;

    public static final String IS_ADMIN_LOGIN = "isLoggedIn";

    public static final String KEY_ADMIN_ID = "Admin_Id";
    public static final String KEY_ADMIN_NAME = "Admin_Name";
    public static final String KEY_ADMIN_EMAIL = "Admin_Email";
    public static final String KEY_ADMIN_PHONE = "Admin_Phone";
    public static final String KEY_ADMIN_DEPT = "Admin_Dept";
    public static final String KEY_ADMIN_DEPT_ID = "Admin_DeptId";
    public static final String KEY_ADMIN_IMAGE = "Admin_ImageUrl";
    public static final String KEY_ADMIN_STATUS = "Admin_Status";
    public static final String KEY_ADMIN = "Admin_Super";


    public AdminLoginSession(@NonNull Context context){
        this.context = context;

        admin_Session = context.getSharedPreferences("adminLoginSession",Context.MODE_PRIVATE);
        editor = admin_Session.edit();
    }

    public void putAdmin_Id(String Admin_id){
        editor.putString(KEY_ADMIN_ID,Admin_id);

        editor.commit();
    }

    public static String getAdmin_Id(){

        return admin_Session.getString(KEY_ADMIN_ID,null);
    }

    public void createAdminLoginSession(String name,String superAdmin , String email,String phone,String branch,String imageurl,String branchid,String status,String ADMINid){

        editor.putBoolean(IS_ADMIN_LOGIN,true);

        editor.putString(KEY_ADMIN_ID,ADMINid);
        editor.putString(KEY_ADMIN_NAME,name);
        editor.putString(KEY_ADMIN_EMAIL,email);
        editor.putString(KEY_ADMIN_PHONE,phone);
        editor.putString(KEY_ADMIN_DEPT,branch);
        editor.putString(KEY_ADMIN_DEPT_ID,branchid);
        editor.putString(KEY_ADMIN_IMAGE,imageurl);
        editor.putString(KEY_ADMIN_STATUS,status);
        editor.putString(KEY_ADMIN,superAdmin);

        editor.commit();

    }

    @NonNull
    public HashMap<String,String> getAdminDetailsFromSession(){

        HashMap<String,String> adminDetails = new HashMap<>();

        adminDetails.put(KEY_ADMIN_NAME,admin_Session.getString(KEY_ADMIN_NAME,null));
        adminDetails.put(KEY_ADMIN_EMAIL,admin_Session.getString(KEY_ADMIN_EMAIL,null));
        adminDetails.put(KEY_ADMIN_PHONE,admin_Session.getString(KEY_ADMIN_PHONE,null));
        adminDetails.put(KEY_ADMIN_DEPT_ID,admin_Session.getString(KEY_ADMIN_DEPT_ID,null));
        adminDetails.put(KEY_ADMIN_DEPT,admin_Session.getString(KEY_ADMIN_DEPT,null));
        adminDetails.put(KEY_ADMIN_IMAGE,admin_Session.getString(KEY_ADMIN_IMAGE,null));
        adminDetails.put(KEY_ADMIN_ID,admin_Session.getString(KEY_ADMIN_ID,null));
        adminDetails.put(KEY_ADMIN_STATUS,admin_Session.getString(KEY_ADMIN_STATUS,null));
        adminDetails.put(KEY_ADMIN,admin_Session.getString(KEY_ADMIN,null));

        return adminDetails;
    }

    public boolean checkAdminLogin(){
        return admin_Session.getBoolean(IS_ADMIN_LOGIN, false);
    }

    public void logoutAdminSession(){
        editor.clear();
        editor.commit();
    }


}
