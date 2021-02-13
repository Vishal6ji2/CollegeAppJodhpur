package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.Activities.FullPlacementnewsActivity;
import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.PlacementSuitcase;

import java.util.ArrayList;

public class PlacementNewsAdapter extends RecyclerView.Adapter<PlacementNewsAdapter.ViewHolder> {
    Context context;
    ArrayList<PlacementSuitcase> arrplacementlist = new ArrayList<>();

    public PlacementNewsAdapter(Context context, ArrayList<PlacementSuitcase> arrplacementlist) {
        this.context = context;
        this.arrplacementlist = arrplacementlist;
    }

    @NonNull
    @Override
    public PlacementNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customplacementlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final PlacementNewsAdapter.ViewHolder holder, final int position) {

        holder.cmpname.setText(arrplacementlist.get(position).companyname);
        holder.cmpnews.setText(arrplacementlist.get(position).placementnews);
        holder.cmptime.setText(arrplacementlist.get(position).cmptime);
        holder.cmptitle.setText(arrplacementlist.get(position).placementtitle);
        holder.cmpimg.setImageResource(arrplacementlist.get(position).companyimg);

        holder.itemView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.tabsanim));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "clicked "+position, Toast.LENGTH_SHORT).show();
                holder.cmptitle.setTextColor(context.getResources().getColor(R.color.colordarkgrey));
                holder.cmpnews.setTextColor(context.getResources().getColor(R.color.colordarkgrey));
                holder.cmptime.setTextColor(context.getResources().getColor(R.color.colordarkgrey));
                holder.cmpname.setBackgroundColor(context.getResources().getColor(R.color.colordarkgrey));
                context.startActivity(new Intent(context, FullPlacementnewsActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrplacementlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cmpimg;
        TextView cmpname,cmptitle,cmpnews,cmptime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cmpimg = itemView.findViewById(R.id.customplacement_cmpimg);
            cmpname = itemView.findViewById(R.id.customplacement_cmpname);
            cmptitle = itemView.findViewById(R.id.customplacement_cmptitle);
            cmptime = itemView.findViewById(R.id.customplacement_cmptime);
            cmpnews = itemView.findViewById(R.id.customplacement_cmpnews);

        }
    }
}
