package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.TimetableSuitcase;

import java.util.ArrayList;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.ViewHolder> {
    Context context;
    ArrayList<TimetableSuitcase> arrimg = new ArrayList<>();

    public TimeTableAdapter(Context context, ArrayList<TimetableSuitcase> arrimg) {
        this.context = context;
        this.arrimg = arrimg;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customtimelayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.semimg.setImageResource(arrimg.get(position).semimg);
        holder.txtsem.setText(arrimg.get(position).txtsem);

    }

    @Override
    public int getItemCount() {
        return arrimg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtsem;
        ImageView semimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtsem = itemView.findViewById(R.id.customtime_txtsem);
            semimg = itemView.findViewById(R.id.customtime_semimg);
        }
    }
}
