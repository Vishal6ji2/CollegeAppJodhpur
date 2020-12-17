package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.R;
import com.mbm.mbmjodhpur.Suitcases.NewsPostSuitcase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class NewsPostAdapter extends RecyclerView.Adapter<NewsPostAdapter.ViewHolder> {

    Context context;
    ArrayList<NewsPostSuitcase> arrnewspostlist = new ArrayList<>();
    FragmentManager fragmentManager;

    public NewsPostAdapter(Context context, ArrayList<NewsPostSuitcase> arrnewspostlist) {
        this.context = context;
        this.arrnewspostlist = arrnewspostlist;
    }

    @NonNull
    @Override
    public NewsPostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.custompostlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsPostAdapter.ViewHolder holder, final int position) {

        holder.profileimg.setImageResource(arrnewspostlist.get(position).profileimg);

        holder.postimg.setImageResource(arrnewspostlist.get(position).postimg);


        holder.profilename.setText(arrnewspostlist.get(position).profilename);
        holder.txtheading.setText(arrnewspostlist.get(position).txtheading);
        holder.txtdetails.setText(arrnewspostlist.get(position).txtdetails);
        holder.datetime.setText(arrnewspostlist.get(position).datetime);
        holder.timeago.setText(arrnewspostlist.get(position).timeago);

    }

    @Override
    public int getItemCount() {
        return arrnewspostlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView profilename,txtheading,txtdetails,datetime,timeago;
        CircularImageView profileimg;
        ImageView postimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profilename = itemView.findViewById(R.id.custompost_profilename);
            txtheading = itemView.findViewById(R.id.custompost_txtheading);
            txtdetails = itemView.findViewById(R.id.custompost_txtdetails);
            datetime = itemView.findViewById(R.id.custompost_posttime);
            timeago = itemView.findViewById(R.id.custompost_timeago);

            profileimg = itemView.findViewById(R.id.custompost_profileimg);

            postimg = itemView.findViewById(R.id.custompost_postimg);
        }
    }
}
