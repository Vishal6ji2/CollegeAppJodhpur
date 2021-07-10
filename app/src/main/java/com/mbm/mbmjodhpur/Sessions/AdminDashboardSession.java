package com.mbm.mbmjodhpur.Sessions;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AdminDashboardSession {

    public Context context;

    //Links Session
    public static SharedPreferences.Editor linksEditor;
    private static final String KEY_LINKS = "linksSession";
    public static SharedPreferences links_Session;
    private static final String linksList = "linksList";

    //NewsFeed Session
    public static SharedPreferences.Editor newsfeedEditor;
    private static final String KEY_NEWSFEED = "newsfeedSession";
    public static SharedPreferences newsfeed_Session;
    private static final String newsfeedList = "newsfeedList";

    //Notice Session
    public static SharedPreferences.Editor noticeEditor;
    private static final String KEY_NOTICE = "noticeSession";
    public static SharedPreferences notice_Session;
    private static final String noticeList = "noticeList";

    //Placement Session
    public static SharedPreferences.Editor placementEditor;
    private static final String KEY_PLACEMENT = "placementSession";
    public static SharedPreferences placement_Session;
    private static final String placementList = "placementList";

    //Library Session
    public static SharedPreferences.Editor libraryEditor;
    private static final String KEY_LIBRARY = "librarySession";
    public static SharedPreferences library_Session;
    private static final String libraryList = "libraryList";

    //Subject Session
    public static SharedPreferences.Editor subjectsEditor;
    private static final String KEY_SUBJECT = "subjectSession";
    public static SharedPreferences subject_Session;
    private static final String subjectList = "subjectList";

    //Syllabus Session
    public static SharedPreferences.Editor syllabusEditor;
    private static final String KEY_SYLLABUS = "syllabusSession";
    public static SharedPreferences syllabus_Session;
    private static final String syllabusList = "syllabusList";

    //Timetable Session
    public static SharedPreferences.Editor timetableEditor;
    private static final String KEY_TIMETABLE = "timetableSession";
    public static SharedPreferences timetable_Session;
    private static final String timetableList = "timetableList";



    public AdminDashboardSession(@NonNull Context context){
        this.context = context;

        links_Session = context.getSharedPreferences(KEY_LINKS,Context.MODE_PRIVATE);
        newsfeed_Session = context.getSharedPreferences(KEY_NEWSFEED,Context.MODE_PRIVATE);
        notice_Session = context.getSharedPreferences(KEY_NOTICE,Context.MODE_PRIVATE);
        placement_Session = context.getSharedPreferences(KEY_PLACEMENT,Context.MODE_PRIVATE);
        library_Session = context.getSharedPreferences(KEY_LIBRARY,Context.MODE_PRIVATE);
        subject_Session = context.getSharedPreferences(KEY_SUBJECT,Context.MODE_PRIVATE);
        syllabus_Session = context.getSharedPreferences(KEY_SYLLABUS,Context.MODE_PRIVATE);
        timetable_Session = context.getSharedPreferences(KEY_TIMETABLE,Context.MODE_PRIVATE);


        linksEditor = links_Session.edit();
        newsfeedEditor = newsfeed_Session.edit();
        noticeEditor = notice_Session.edit();
        placementEditor = placement_Session.edit();
        libraryEditor = library_Session.edit();
        subjectsEditor = subject_Session.edit();
        syllabusEditor = syllabus_Session.edit();
        timetableEditor = timetable_Session.edit();
    }


    //Links Methods

    public void put_LinksList(ArrayList<StudentAppAdminResponse.Data.Link> linkArrayList){
        links_Session = context.getSharedPreferences(KEY_LINKS,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(linkArrayList);
        linksEditor.putString(linksList,json);
        linksEditor.apply();
    }

    @NonNull
    public ArrayList<StudentAppAdminResponse.Data.Link> get_LinksList(@NonNull Context context){

        links_Session = context.getSharedPreferences(KEY_LINKS,Context.MODE_PRIVATE);
        String json = links_Session.getString(linksList,"");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<StudentAppAdminResponse.Data.Link>>(){}.getType();

        return gson.fromJson(json,type);
    }


    //News Feed Methods

    public void put_NewsFeedList(ArrayList<StudentAppAdminResponse.Data.News> newsfeedArrayList){
        newsfeed_Session = context.getSharedPreferences(KEY_NEWSFEED,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(newsfeedArrayList);
        newsfeedEditor.putString(newsfeedList,json);
        newsfeedEditor.apply();
    }

    @NonNull
    public ArrayList<StudentAppAdminResponse.Data.News> get_NewsFeedList(@NonNull Context context){

        newsfeed_Session = context.getSharedPreferences(KEY_NEWSFEED,Context.MODE_PRIVATE);
        String json = newsfeed_Session.getString(newsfeedList,"");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<StudentAppAdminResponse.Data.News>>(){}.getType();

        return gson.fromJson(json,type);
    }

    //Notice Methods

    public void put_NoticeList(ArrayList<StudentAppAdminResponse.Data.Noticeboard> noticeArrayList){
        notice_Session = context.getSharedPreferences(KEY_NOTICE,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(noticeArrayList);
        noticeEditor.putString(noticeList,json);
        noticeEditor.apply();
    }

    @NonNull
    public ArrayList<StudentAppAdminResponse.Data.Noticeboard> get_NoticeList(@NonNull Context context){

        notice_Session = context.getSharedPreferences(KEY_NOTICE,Context.MODE_PRIVATE);
        String json = notice_Session.getString(noticeList,"");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<StudentAppAdminResponse.Data.Noticeboard>>(){}.getType();

        return gson.fromJson(json,type);
    }

    //Placement Methods

    public void put_PlacementList(ArrayList<StudentAppAdminResponse.Data.Placement> placementsArrayList){
        placement_Session = context.getSharedPreferences(KEY_PLACEMENT,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(placementsArrayList);
        placementEditor.putString(placementList,json);
        placementEditor.apply();
    }

    @NonNull
    public ArrayList<StudentAppAdminResponse.Data.Placement> get_PlacementList(@NonNull Context context){

        placement_Session = context.getSharedPreferences(KEY_PLACEMENT,Context.MODE_PRIVATE);
        String json = placement_Session.getString(placementList,"");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<StudentAppAdminResponse.Data.Placement>>(){}.getType();

        return gson.fromJson(json,type);
    }

    //Library Methods

    public void put_LibraryList(ArrayList<StudentAppAdminResponse.Data.Library> libraryArrayList){
        library_Session = context.getSharedPreferences(KEY_LIBRARY,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(libraryArrayList);
        libraryEditor.putString(libraryList,json);
        libraryEditor.apply();
    }

    @NonNull
    public ArrayList<StudentAppAdminResponse.Data.Library> get_LibraryList(@NonNull Context context){

        library_Session = context.getSharedPreferences(KEY_LIBRARY,Context.MODE_PRIVATE);
        String json = library_Session.getString(libraryList,"");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<StudentAppAdminResponse.Data.Library>>(){}.getType();

        return gson.fromJson(json,type);
    }

    //Subject Methods

    public void put_SubjectList(ArrayList<StudentAppAdminResponse.Data.Subject> subjectArrayList){
        subject_Session = context.getSharedPreferences(KEY_SUBJECT,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(subjectArrayList);
        subjectsEditor.putString(subjectList,json);
        subjectsEditor.apply();
    }

    @NonNull
    public ArrayList<StudentAppAdminResponse.Data.Subject> get_SubjectList(@NonNull Context context){

        subject_Session = context.getSharedPreferences(KEY_SUBJECT,Context.MODE_PRIVATE);
        String json = subject_Session.getString(subjectList,"");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<StudentAppAdminResponse.Data.Subject>>(){}.getType();

        return gson.fromJson(json,type);
    }

    //Syllabus Methods
    //Change Arraylist LInk to Syllabus

    public void put_SyllabusList(ArrayList<StudentAppAdminResponse.Data.Syllabus> syllabusArrayList){
        syllabus_Session = context.getSharedPreferences(KEY_SYLLABUS,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(syllabusArrayList);
        syllabusEditor.putString(syllabusList,json);
        syllabusEditor.apply();
    }

    @NonNull
    public ArrayList<StudentAppAdminResponse.Data.Syllabus> get_SyllabusList(@NonNull Context context){

        syllabus_Session = context.getSharedPreferences(KEY_SYLLABUS,Context.MODE_PRIVATE);
        String json = syllabus_Session.getString(syllabusList,"");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<StudentAppAdminResponse.Data.Syllabus>>(){}.getType();

        return gson.fromJson(json,type);
    }

    //Timetable Methods
    // Change Arraylist Link to Timetable

    public void put_TimetableList(ArrayList<StudentAppAdminResponse.Data.Timetable> timetableArrayList){
        timetable_Session = context.getSharedPreferences(KEY_TIMETABLE,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(timetableArrayList);
        timetableEditor.putString(timetableList,json);
        timetableEditor.apply();
    }

    @NonNull
    public ArrayList<StudentAppAdminResponse.Data.Timetable> get_TimetableList(@NonNull Context context){

        timetable_Session = context.getSharedPreferences(KEY_TIMETABLE,Context.MODE_PRIVATE);
        String json = timetable_Session.getString(timetableList,"");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<StudentAppAdminResponse.Data.Timetable>>(){}.getType();

        return gson.fromJson(json,type);
    }

    public void clearAllDataSession(){
        linksEditor.clear();
        newsfeedEditor.clear();
        noticeEditor.clear();
        placementEditor.clear();
        libraryEditor.clear();
        subjectsEditor.clear();
        syllabusEditor.clear();
        timetableEditor.clear();

        linksEditor.commit();
        newsfeedEditor.commit();
        noticeEditor.commit();
        placementEditor.commit();
        libraryEditor.commit();
        subjectsEditor.commit();
        syllabusEditor.commit();
        timetableEditor.commit();
    }


}
