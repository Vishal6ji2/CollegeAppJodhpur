package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.SyllabusSuitcase;

import java.util.ArrayList;

public class SyllabusAdapter extends RecyclerView.Adapter<SyllabusAdapter.ViewHolder> {

    Context context;
    ArrayList<SyllabusSuitcase> arrsyllabuslist = new ArrayList<>();


    public SyllabusAdapter(Context context, ArrayList<SyllabusSuitcase> arrsyllabuslist) {
        this.context = context;
        this.arrsyllabuslist = arrsyllabuslist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customsyllabuslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.pdfname.setText(arrsyllabuslist.get(position).pdfname);
        holder.pdfimg.setImageResource(R.drawable.pdficon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.pdf995.com/samples/pdf.pdf";

                Uri targetUri = Uri.parse(url);

                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(targetUri, "application/pdf");

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrsyllabuslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pdfimg;
        TextView pdfname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pdfimg = itemView.findViewById(R.id.customsyllabus_pdficon);
            pdfname = itemView.findViewById(R.id.customsyllabus_pdfname);
        }
    }
}
