package com.mbm.mbmjodhpur.Activities;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mbm.mbmjodhpur.Fragments.NewsFeedFragment;
import com.mbm.mbmjodhpur.Fragments.NoticeFragment;
import com.mbm.mbmjodhpur.Fragments.PlacementFragment;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Sessions.AdminDashboardSession;
import com.mbm.mbmjodhpur.Sessions.AdminLoginSession;
import com.mbm.mbmjodhpur.Sessions.StudentDashboardSession;
import com.mbm.mbmjodhpur.Sessions.StudentLoginSession;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppAdminResponse;
import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.KEY_ADMIN_DEPT;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.KEY_ADMIN_IMAGE;
import static com.mbm.mbmjodhpur.Sessions.AdminLoginSession.KEY_ADMIN_NAME;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_DEPT;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_IMAGE;
import static com.mbm.mbmjodhpur.Sessions.StudentLoginSession.KEY_STUD_NAME;


public class HomeActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    SlidingRootNav slidingRootNav;

    BottomNavigationView bnv;

    FrameLayout frameLayout;

    public static boolean flag = false;

    MenuItem menuItem;

    TextView menunoti;

    int pendingnoti = 5;

    StudentDashboardSession studentDashboardSession;

    StudentLoginSession studentLoginSession ;

    AdminLoginSession adminLoginSession;

    AdminDashboardSession adminDashboardSession;

    SharedPreferences sharedPreferences;
    
    public static String user;


    //Side Bar Menus

    //menu ids
    TextView linklayout,ebooklayout,syllabuspaperlayout,timetablelayout,sharelayout,settinglayout,contactlayout,aboutlayout,signoutlayout;

    //profile ids
    ImageView profileimg;

    TextView profilename ,profilebranch ;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        initviews();

        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        user = sharedPreferences.getString("user",null);

        studentDashboardSession = new StudentDashboardSession(this);
        adminDashboardSession = new AdminDashboardSession(this);

        if (user.equals("admin")){
            getStudentAppAdminResponse(this);
        }else if (user.equals("student")){
            getStudentAppResponse(this);
        }

        setSupportActionBar(toolbar);

        slidingRootNav =  new SlidingRootNavBuilder(HomeActivity.this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withDragDistance(150)
                .withMenuLayout(R.layout.navigationlayout)
                .inject();

        sideBarViews();

        if (user.equals("student")){
            getStudentDetails();
        }else if (user.equals("admin")){
            getAdminDetails();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout,new NewsFeedFragment()).commit();

        bnv.setOnNavigationItemSelectedListener(item -> {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.newsmenu:
                    fragment = new NewsFeedFragment();
                    break;

                case R.id.noticemenu:
                    fragment = new NoticeFragment();
                    break;

                case R.id.placementmenu:
                    fragment = new PlacementFragment();
                    break;
            }
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, fragment).commit();
            }

            return true;
        });


        profileimg.setOnClickListener(v -> {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, profileimg, Objects.requireNonNull(ViewCompat.getTransitionName(profileimg)));
            startActivity(new Intent(HomeActivity.this,ProfileActivity.class),optionsCompat.toBundle());

        });

        profilename.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,ProfileActivity.class)));

        profilebranch.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,ProfileActivity.class)));

        linklayout.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,LinksActivity.class)));

        ebooklayout.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,EbooksActivity.class)));

        syllabuspaperlayout.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,PreviousPapersActivity.class)));

        timetablelayout.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,TimetableActivity.class)));

        sharelayout.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"MBM JODHPUR APP");
            intent.putExtra(Intent.EXTRA_TEXT,"Please download MBM JODHPUR APP in your android mobile");
            startActivity(Intent.createChooser(intent,"Share via"));

        });

        settinglayout.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,SettingActivity.class)));

        contactlayout.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,ContactusActivity.class)));

        aboutlayout.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,AboutusActivity.class)));

        signoutlayout.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, EmailVerifyActivity.class));

            studentLoginSession.logoutStudentSession();
            studentDashboardSession.clearAllDataSession();
            adminLoginSession.logoutAdminSession();
            adminDashboardSession.clearAllDataSession();

            finish();

        });

    }

    private void getStudentDetails() {

        studentLoginSession = new StudentLoginSession(this);

        HashMap<String,String> loginDetails = studentLoginSession.getStudentDetailsFromSession();

        String name = loginDetails.get(KEY_STUD_NAME);
        String deptName = loginDetails.get(KEY_STUD_DEPT);
        String imageUrl = loginDetails.get(KEY_STUD_IMAGE);

        profilename.setText(name);
        profilebranch.setText(deptName);

        if (imageUrl!=null){
            if (Uri.parse(imageUrl)!=null){
                Glide.with(this).load(Uri.parse(imageUrl)).into(profileimg);
            }
        }
    }

    private void getAdminDetails() {

        adminLoginSession = new AdminLoginSession(this);

        HashMap<String,String> loginDetails = adminLoginSession.getAdminDetailsFromSession();

        String name = loginDetails.get(KEY_ADMIN_NAME);
        String deptName = loginDetails.get(KEY_ADMIN_DEPT);
        String imageUrl = loginDetails.get(KEY_ADMIN_IMAGE);

//        txtName.setText(String.format("Hello , %s", name));
        profilename.setText(name);
        profilebranch.setText(deptName);

        if (imageUrl!=null){
            if (Uri.parse(imageUrl)!=null){
                Glide.with(this).load(Uri.parse(imageUrl)).into(profileimg);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.chatmenu,menu);

        menuItem = menu.findItem(R.id.chatmenu);


        menuItem.setActionView(R.layout.badgenotification);
        View view = menuItem.getActionView();
        menunoti = view.findViewById(R.id.badgecounter);

        if (pendingnoti == 0){
            menuItem.setActionView(null);
            return true;

        }else {
            menunoti.setText(String.valueOf(pendingnoti));
        }

        view.setOnClickListener(v -> {

            startActivity(new Intent(HomeActivity.this,ChatActivity.class));
            pendingnoti = 0;
            menunoti.setVisibility(View.INVISIBLE);


        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.chatmenu){
            startActivity(new Intent(HomeActivity.this,ChatActivity.class));
//            menunoti.setVisibility(View.INVISIBLE);
            pendingnoti = 0;
            return true;
        }
        return false;
    }


    private void initviews() {

        frameLayout = findViewById(R.id.home_framelayout);

        bnv = findViewById(R.id.bnv);

        toolbar = findViewById(R.id.home_toolbar);

    }

    public void sideBarViews() {

        profileimg  = findViewById(R.id.navigation_profileimg);

        profilename = findViewById(R.id.navigation_profilename);
        profilebranch = findViewById(R.id.navigation_branch);

        linklayout = findViewById(R.id.navigation_txtlink);
        ebooklayout = findViewById(R.id.navigation_txtebook);
        syllabuspaperlayout = findViewById(R.id.navigation_txtpaper);
        timetablelayout = findViewById(R.id.navigation_txttimetable);
        sharelayout = findViewById(R.id.navigation_txtshare);
        settinglayout = findViewById(R.id.navigation_txtsetting);
        contactlayout = findViewById(R.id.navigation_txtcontact);
        aboutlayout = findViewById(R.id.navigation_txtabout);
        signoutlayout = findViewById(R.id.navigation_txtsignout);

    }


//    StudentAppResponse

    public static void getStudentData(ArrayList<StudentAppResponse.Data.Student> student, Context context) {
        StudentLoginSession studentLoginSession = new StudentLoginSession(context);


        String name = student.get(0).getName();
        String email = student.get(0).getEmail();
        String phone = student.get(0).getMobile();
        String regNo = student.get(0).getRegNo();
        String branch = student.get(0).getDepartmentName();
        String branch_Id = student.get(0).getDeptId();
        String stud_Id = student.get(0).getId();
        String imageUrl = student.get(0).getProfile();
        String status = student.get(0).getStatus();

//        StudentLoginSession.putStud_Id(stud_Id,branch);

        studentLoginSession.createStudentLoginSession(name,regNo, email, phone,branch, imageUrl, branch_Id, status, stud_Id);

    }


//    StudentAppAdminResponse


    public static void getAdminTimetableData(ArrayList<StudentAppAdminResponse.Data.Timetable> timetableArrayList, Context context) {
        AdminDashboardSession adminDashboardSession = new AdminDashboardSession(context);
        adminDashboardSession.put_TimetableList(timetableArrayList);

    }

    public static void getAdminSyllabusData(ArrayList<StudentAppAdminResponse.Data.Syllabus> syllabusArrayList, Context context) {
        AdminDashboardSession adminDashboardSession = new AdminDashboardSession(context);

        adminDashboardSession.put_SyllabusList(syllabusArrayList);

    }

    public static void getAdminSubjectData(ArrayList<StudentAppAdminResponse.Data.Subject> subjectArrayList, Context context) {
        AdminDashboardSession adminDashboardSession = new AdminDashboardSession(context);

        adminDashboardSession.put_SubjectList(subjectArrayList);

    }

    public static void getAdminLibraryData(ArrayList<StudentAppAdminResponse.Data.Library> libraryArrayList, Context context) {
        AdminDashboardSession adminDashboardSession = new AdminDashboardSession(context);

        adminDashboardSession.put_LibraryList(libraryArrayList);
    }

    public static void getAdminPlacementData(ArrayList<StudentAppAdminResponse.Data.Placement> placementArrayList, Context context) {
        AdminDashboardSession adminDashboardSession = new AdminDashboardSession(context);

        adminDashboardSession.put_PlacementList(placementArrayList);

    }

    public static void getAdminNoticeData(ArrayList<StudentAppAdminResponse.Data.Noticeboard> noticeboardArrayList, Context context) {
        AdminDashboardSession adminDashboardSession = new AdminDashboardSession(context);

        adminDashboardSession.put_NoticeList(noticeboardArrayList);
    }

    public static void getAdminNewsFeedData(ArrayList<StudentAppAdminResponse.Data.News> newsArrayList, Context context) {
        AdminDashboardSession adminDashboardSession = new AdminDashboardSession(context);

        adminDashboardSession.put_NewsFeedList(newsArrayList);
    }

    public static void getAdminLinksData(ArrayList<StudentAppAdminResponse.Data.Link> linkArrayList, Context context) {

        AdminDashboardSession adminDashboardSession = new AdminDashboardSession(context);

        adminDashboardSession.put_LinksList(linkArrayList);
    }

    public static void getAdminData(ArrayList<StudentAppAdminResponse.Data.Admin> admin, Context context) {
        AdminLoginSession adminLoginSession = new AdminLoginSession(context);


        String name = admin.get(0).getName();
        String email = admin.get(0).getEmail();
        String phone = admin.get(0).getMobile();
        String superAdmin = admin.get(0).getSuperAdmin();
//        String branch = admin.get(0).getDepartmentName();
        String branch_Id = admin.get(0).getDeptId();
        String stud_Id = admin.get(0).getId();
//        String imageUrl = admin.get(0).getImageUrl();
        String status = admin.get(0).getStatus();

//        StudentLoginSession.putStud_Id(stud_Id,branch);

        adminLoginSession.createAdminLoginSession(name,superAdmin, email, phone,"branch", "", branch_Id, status, stud_Id);

    }


}