package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mbm.mbmjodhpur.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class ViewpagerAdapter extends SliderViewAdapter<ViewpagerAdapter.ViewHolder> {

    Context context;
    ArrayList<Integer> imglist;

    public ViewpagerAdapter(Context context,ArrayList<Integer> imglist) {

        this.context = context;
        this.imglist = imglist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customlayoutviewpager, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.imageView.setImageResource(imglist.get(position));
    }

    @Override
    public int getCount() {
        return imglist.size();
    }

    static class ViewHolder extends SliderViewAdapter.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_viewpager);
        }
    }
}
