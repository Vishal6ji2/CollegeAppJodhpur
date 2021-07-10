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
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.PapersSuitcase;

import java.util.ArrayList;

public class PapersAdapter extends RecyclerView.Adapter<PapersAdapter.ViewHolder> {

    Context context;
    ArrayList<PapersSuitcase> arrpaperslist;

    public PapersAdapter(Context context, ArrayList<PapersSuitcase> arrpaperslist) {
        this.context = context;
        this.arrpaperslist = arrpaperslist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.custompaperslayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.paperimg.setImageResource(R.drawable.pdficon);
        holder.paperyear.setText(arrpaperslist.get(position).paperyear);


        holder.itemView.setOnClickListener(v -> {

            String url = "http://www.pdf995.com/samples/pdf.pdf";

            Uri targetUri = Uri.parse(url);

            Intent intent;
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(targetUri, "application/pdf");

            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return arrpaperslist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView paperyear;
        ImageView paperimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            paperyear = itemView.findViewById(R.id.custompaper_txtyear);
            paperimg = itemView.findViewById(R.id.custompaper_img);
        }
    }
}
