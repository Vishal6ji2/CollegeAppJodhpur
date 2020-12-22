package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.NoticeSuitcase;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    Context context;

    ArrayList<NoticeSuitcase> arrnoticelist = new ArrayList<>();

    public NoticeAdapter(Context context, ArrayList<NoticeSuitcase> arrnoticelist) {
        this.context = context;
        this.arrnoticelist = arrnoticelist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customnoticelayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(arrnoticelist.get(position).img);
        holder.imageView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.tabsanim));
//        holder.textView.setText(arrnoticelist.get(position).text);
    }

    @Override
    public int getItemCount() {
        return arrnoticelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            textView = itemView.findViewById(R.id.customnotice_txtnotice);
            imageView = itemView.findViewById(R.id.customnotice_img);
        }
    }
}
