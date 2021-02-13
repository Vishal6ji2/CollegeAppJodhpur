package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.Activities.AboutusActivity;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.AboutImgSuitcase;

import java.util.ArrayList;

public class AboutusAdapter extends RecyclerView.Adapter<AboutusAdapter.ViewHolder> {
    Context context;
    ArrayList<AboutImgSuitcase> arrimglist = new ArrayList<>();
    int position;

    public AboutusAdapter(Context context, ArrayList<AboutImgSuitcase> arrimglist) {
        this.context = context;
        this.arrimglist = arrimglist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customaboutlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        holder.imageView.setImageResource(arrimglist.get(position).img);

    }

    @Override
    public int getItemCount() {
        return arrimglist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.customabout_image);
        }
    }
}
