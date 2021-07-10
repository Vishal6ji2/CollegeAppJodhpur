package com.mbm.mbmjodhpur.Activities;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.R;

import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;
import static com.mbm.mbmjodhpur.ViewUtils.toast;

public class FullPlacementnewsActivity extends AppCompatActivity {


    MaterialToolbar toolbar;

    TextView txtcmpnews,txtfilename,txtline;

    ImageView  fileicon;

    Intent intent;

    String cmpTitle , cmpNews , fileName , uploadedBy , filepath;

    RelativeLayout filelayout;

    Uri fileuri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_placementnews);

        initviews();

        getStudentAppResponse(this);

        setSupportActionBar(toolbar);

        intent = getIntent();

        if (intent!=null){
            if (intent.getStringExtra("cmpnews")!=null){

                cmpTitle = intent.getStringExtra("cmptitle");
                cmpNews = intent.getStringExtra("cmpnews");
                fileName = intent.getStringExtra("filename");
                uploadedBy = intent.getStringExtra("uploadedby");
            }
        }

        toolbar.setTitle(cmpTitle);
        toolbar.setSubtitle("by : "+uploadedBy);
        txtcmpnews.setText(cmpNews);

        toolbar.setNavigationOnClickListener(v -> finish());

        filepath = intent.getStringExtra("filename");
        if (filepath != null && !filepath.equals("")) {
            fileuri = Uri.parse(filepath);
            if (fileuri != null && !fileuri.toString().equals("")) {

                filelayout.setVisibility(View.VISIBLE);
                txtline.setVisibility(View.VISIBLE);
                if (filepath.endsWith(".xlsx") || filepath.endsWith(".xls")){
                    fileicon.setImageDrawable(ContextCompat.getDrawable(FullPlacementnewsActivity.this, R.drawable.xlsicon));
                }else if (filepath.endsWith(".pdf")){
                    fileicon.setImageDrawable(ContextCompat.getDrawable(FullPlacementnewsActivity.this, R.drawable.pdficon));
                }else if (filepath.endsWith(".doc") || filepath.endsWith(".docx")){
                    fileicon.setImageDrawable(ContextCompat.getDrawable(FullPlacementnewsActivity.this, R.drawable.docfileicon));
                }else if (filepath.endsWith(".txt")){
                    fileicon.setImageDrawable(ContextCompat.getDrawable(FullPlacementnewsActivity.this, R.drawable.txticon));
                }else {
                    fileicon.setImageDrawable(ContextCompat.getDrawable(FullPlacementnewsActivity.this, R.drawable.fileicon));
                }

                txtfilename.setText(intent.getStringExtra("filename"));

                filelayout.setOnClickListener(v -> downloadfile(fileuri));
            }
        }else {
            filelayout.setVisibility(View.GONE);
            txtline.setVisibility(View.GONE);
        }

    }

    void downloadfile(Uri fileuri) {

        DownloadManager.Request request = new DownloadManager.Request(fileuri);
        String title = URLUtil.guessFileName(filepath,null,null);
        request.setTitle(title);
        request.setDescription("Downloading file please wait....");
        String cookie = CookieManager.getInstance().getCookie(filepath);
        request.addRequestHeader("cookie",cookie);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOCUMENTS,title);

        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

        toast(FullPlacementnewsActivity.this,"Downloading started...");

    }


    private void initviews() {

        toolbar = findViewById(R.id.fplacement_toolbar);

        txtcmpnews = findViewById(R.id.fplacement_txtnews);
        txtline = findViewById(R.id.fplacement_lineone);
        txtcmpnews = findViewById(R.id.fplacement_txtnews);

        txtfilename = findViewById(R.id.fplacement_txtfilename);

        fileicon = findViewById(R.id.fplacement_fileicon);

        filelayout = findViewById(R.id.fplacement_filelayout);


    }


    private String fileExt(String url) {
        if (url.contains("?")) {
            url = url.substring(0, url.indexOf("?"));
        }
        if (url.lastIndexOf(".") == -1) {
            return null;
        } else {
            String ext = url.substring(url.lastIndexOf(".") + 1);
            if (ext.contains("%")) {
                ext = ext.substring(0, ext.indexOf("%"));
            }
            if (ext.contains("/")) {
                ext = ext.substring(0, ext.indexOf("/"));
            }
            return ext.toLowerCase();

        }
    }
}