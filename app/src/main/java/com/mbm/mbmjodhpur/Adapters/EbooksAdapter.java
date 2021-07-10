package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.ViewUtils.openWebPage;

public class EbooksAdapter extends RecyclerView.Adapter<EbooksAdapter.ViewHolder> implements Filterable{

    Context context;

    ArrayList<StudentAppResponse.Data.Library> arrStudentEbookList;
    ArrayList<StudentAppAdminResponse.Data.Library> arrAdminEbookList;


    public EbooksAdapter(ArrayList<StudentAppResponse.Data.Library> arrEbookList,Context context) {
        this.context = context;
        this.arrStudentEbookList = arrEbookList;
    }

    public EbooksAdapter(Context context, ArrayList<StudentAppAdminResponse.Data.Library> arrEbookList) {
        this.context = context;
        this.arrAdminEbookList = arrEbookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customebooklayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (user.equals("admin")){

            holder.bookname.setText(arrAdminEbookList.get(position).getName());

            holder.itemView.setOnClickListener(v -> openWebPage(context,arrAdminEbookList.get(position).getFileName()));

        }else if (user.equals("student")){

            holder.bookname.setText(arrStudentEbookList.get(position).getName());

            holder.itemView.setOnClickListener(v -> openWebPage(context,arrStudentEbookList.get(position).getFileName()));
        }

    }

    @Override
    public int getItemCount() {
        if (user.equals("admin")) {
            return arrAdminEbookList.size();
        }else {
            return arrStudentEbookList.size();
        }
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public void filterlist(ArrayList<StudentAppResponse.Data.Library> filterlist,Context context) {
        this.context = context;
        arrStudentEbookList = filterlist;
        notifyDataSetChanged();
    }

    public void filterlist(Context context,ArrayList<StudentAppAdminResponse.Data.Library> filterlist) {
        this.context = context;
        arrAdminEbookList = filterlist;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView bookname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookname = itemView.findViewById(R.id.customebook_pdfname);
        }
    }
}
