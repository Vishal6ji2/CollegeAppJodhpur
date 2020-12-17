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
import com.mbm.mbmjodhpur.Suitcases.EbooksSuitcase;

import java.util.ArrayList;

public class EbooksAdapter extends RecyclerView.Adapter<EbooksAdapter.ViewHolder> {

    Context context;
    ArrayList<EbooksSuitcase> arrebooklist = new ArrayList<>();

    public EbooksAdapter(Context context, ArrayList<EbooksSuitcase> arrebooklist) {
        this.context = context;
        this.arrebooklist = arrebooklist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customebooklayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bookimg.setImageResource(arrebooklist.get(position).bookimg);
        holder.bookname.setText(arrebooklist.get(position).bookname);
        holder.bookauthor.setText(arrebooklist.get(position).bookauthorname);
        holder.bookedition.setText(arrebooklist.get(position).bookedition);


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
        return arrebooklist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bookimg;
        TextView bookname,bookauthor,bookedition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookimg = itemView.findViewById(R.id.custombook_img);
            bookname = itemView.findViewById(R.id.custombook_name);
            bookauthor = itemView.findViewById(R.id.custombook_author);
            bookedition = itemView.findViewById(R.id.custombook_edition);
        }
    }
}
