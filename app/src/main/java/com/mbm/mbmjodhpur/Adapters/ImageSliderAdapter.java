package com.mbm.mbmjodhpur.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHolder> implements View.OnTouchListener {

    Context context;

    ArrayList<String> arrImagesList;

    ScaleGestureDetector scaleGestureDetector;

    ImageView imageView;

    float scaleFactor = 1.0f;

    public ImageSliderAdapter(@NonNull Context context, @NonNull ArrayList<String> arrImagesList) {
        this.context = context;
        this.arrImagesList = arrImagesList;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return scaleGestureDetector.onTouchEvent(event);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customsliderimglayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Uri uri = Uri.parse(arrImagesList.get(position));

        Glide.with(context).load(uri).into(imageView);

        scaleGestureDetector = new ScaleGestureDetector(context,new ScaleListener());

    }

    @Override
    public int getItemCount() {
        return arrImagesList.size();
    }


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            scaleFactor = scaleGestureDetector.getScaleFactor();

            imageView.setScaleX(scaleFactor);
            imageView.setScaleY(scaleFactor);

            return true;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.slider_img);
        }
    }
}
