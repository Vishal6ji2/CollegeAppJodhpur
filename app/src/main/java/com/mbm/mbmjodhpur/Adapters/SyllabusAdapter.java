package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.ViewUtils.openWebPage;

public class SyllabusAdapter extends RecyclerView.Adapter<SyllabusAdapter.ViewHolder> implements Filterable {

    Context context;

    ArrayList<StudentAppAdminResponse.Data.Syllabus> arrAdminSyllabusList;
    ArrayList<StudentAppResponse.Data.Syllabus> arrStudSyllabusList;

    String fileName, fileUrl;


    public SyllabusAdapter(Context context, ArrayList<StudentAppResponse.Data.Syllabus> arrStudSyllabusList) {
        this.context = context;
        this.arrStudSyllabusList = arrStudSyllabusList;
    }

    public SyllabusAdapter(ArrayList<StudentAppAdminResponse.Data.Syllabus> arrAdminSyllabusList, Context context) {
        this.context = context;
        this.arrAdminSyllabusList = arrAdminSyllabusList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customsyllabuslayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (user.equals("admin")){
            fileName = arrAdminSyllabusList.get(position).getName();
            fileUrl = arrAdminSyllabusList.get(position).getFileName();
        }else if (user.equals("student")){
            fileName = arrStudSyllabusList.get(position).getName();
            fileUrl = arrStudSyllabusList.get(position).getFileName();
        }

        holder.pdfname.setText(fileName);
        holder.pdfimg.setImageResource(R.drawable.pdficon);
        holder.itemView.setOnClickListener(v -> openWebPage(context,fileUrl));
    }

    @Override
    public int getItemCount() {
        if (user.equals("admin")) {
            return arrAdminSyllabusList.size();
        } else {
            return arrStudSyllabusList.size();
        }
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public void filterlist(ArrayList<StudentAppAdminResponse.Data.Syllabus> filterlist, Context context) {
        arrAdminSyllabusList = filterlist;
        notifyDataSetChanged();
    }

    public void filterlist(Context context, ArrayList<StudentAppResponse.Data.Syllabus> filterlist) {
        arrStudSyllabusList = filterlist;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pdfimg;
        TextView pdfname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pdfimg = itemView.findViewById(R.id.customsyllabus_pdficon);
            pdfname = itemView.findViewById(R.id.customsyllabus_pdfname);
        }
    }
}
