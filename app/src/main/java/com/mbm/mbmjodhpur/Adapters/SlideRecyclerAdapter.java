package com.mbm.mbmjodhpur.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mbm.mbmjodhpur.Activities.FullImageShowActivity;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;
import java.util.Objects;

public class SlideRecyclerAdapter extends RecyclerView.Adapter<SlideRecyclerAdapter.ViewHolder>{

    Context context;
    ArrayList<String> arrImagelist;

    public SlideRecyclerAdapter(@NonNull Context context, @NonNull ArrayList<String> arrImagelist) {
        this.context = context;
        this.arrImagelist = arrImagelist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customsliderimglayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Uri uri = Uri.parse(arrImagelist.get(position));
        Glide.with(context).load(uri).into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            Intent imagesintent = new Intent(context, FullImageShowActivity.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,holder.imageView, Objects.requireNonNull(ViewCompat.getTransitionName(holder.imageView)));
            imagesintent.putStringArrayListExtra("images",arrImagelist);
            context.startActivity(imagesintent,optionsCompat.toBundle());
        });

    }

    @Override
    public int getItemCount() {
        return arrImagelist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.slider_img);
        }
    }
}
