package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.R;

public class FullPlacementnewsActivity extends AppCompatActivity {

    MaterialToolbar toolbar;
    ImageView backimg;
    TextView txtnews,txtcmptitle;

    RelativeLayout llfile;

    ImageView  fileicon;
    TextView filename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_placementnews);

        initviews();

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        llfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://docs.google.com/spreadsheets/d/1Y7Lv7A1X_PbGD9r0SLPSDUap6iMi14NKWm3B52chLus/edit#gid=0";
                Uri uri = Uri.parse(url);
                MimeTypeMap myMime = MimeTypeMap.getSingleton();
                Intent newIntent = new Intent(Intent.ACTION_VIEW);
//        String mimeType = myMime.getMimeTypeFromExtension(fileExt(getFile()).substring(1));
//        newIntent.setDataAndType(Uri.fromFile(getFile()),mimeType);
                newIntent.setData(uri);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(newIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(FullPlacementnewsActivity.this, "No handler for this type of file.", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void initviews() {

        toolbar = findViewById(R.id.fplacement_toolbar);

        backimg = findViewById(R.id.fplacement_backimg);

        txtcmptitle = findViewById(R.id.fplacement_txtcmptitle);
        txtnews = findViewById(R.id.fplacement_txtnews);
        filename = findViewById(R.id.fplacement_filename);

        fileicon = findViewById(R.id.fplacement_fileicon);
        llfile = findViewById(R.id.fplacement_llfile);


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