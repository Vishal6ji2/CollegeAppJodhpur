package com.mbm.mbmjodhpur.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.flexbox.AlignContent;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.material.appbar.MaterialToolbar;
import com.mbm.mbmjodhpur.Adapters.GalleryAdapter;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.GallerySuitcase;

import java.util.ArrayList;

public class ImageGalleryActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<GallerySuitcase> arrgallerylist = new ArrayList<>();
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);


        initviews();

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