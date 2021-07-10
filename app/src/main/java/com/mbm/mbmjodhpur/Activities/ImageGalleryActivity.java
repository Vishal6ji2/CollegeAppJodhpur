package com.mbm.mbmjodhpur.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.GalleryAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.GallerySuitcase;

import java.util.ArrayList;

import static com.mbm.mbmjodhpur.Activities.OtpVerifyActivity.getStudentAppResponse;


public class ImageGalleryActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<GallerySuitcase> arrgallerylist = new ArrayList<>();
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);


        initviews();

        getStudentAppResponse(this);

        addGalleryData(R.drawable.designerimg);
        addGalleryData(R.drawable.editorimg);
        addGalleryData(R.drawable.directorimg);
        addGalleryData(R.drawable.profilefive);
        addGalleryData(R.drawable.profilefour);

        addGalleryData(R.drawable.designerimg);
        addGalleryData(R.drawable.editorimg);
        addGalleryData(R.drawable.directorimg);
        addGalleryData(R.drawable.profilefive);
        addGalleryData(R.drawable.profilefour);

        addGalleryData(R.drawable.mbmlogo);
        addGalleryData(R.drawable.picone);
        addGalleryData(R.drawable.pictwo);

        addGalleryData(R.drawable.designerimg);
        addGalleryData(R.drawable.editorimg);
        addGalleryData(R.drawable.directorimg);
        addGalleryData(R.drawable.profilefive);
        addGalleryData(R.drawable.profilefour);


        addGalleryData(R.drawable.designerimg);
        addGalleryData(R.drawable.editorimg);
        addGalleryData(R.drawable.directorimg);
        addGalleryData(R.drawable.profilefive);
        addGalleryData(R.drawable.profilefour);


      /*FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        flexboxLayoutManager.setAlignItems(AlignItems.STRETCH);
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);
      */

      recyclerView.setLayoutManager(new GridLayoutManager(this,3));

      recyclerView.setAdapter(new GalleryAdapter(this,arrgallerylist));
      recyclerView.setHasFixedSize(true);

    }

    public void addGalleryData(int img){

        GallerySuitcase gallerySuitcase = new GallerySuitcase();

        gallerySuitcase.imgs = img;

        arrgallerylist.add(gallerySuitcase);
    }

    private void initviews() {

        toolbar = findViewById(R.id.gallery_toolbar);
        recyclerView = findViewById(R.id.gallery_recyclerview);
    }
}