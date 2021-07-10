package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.Activities.FullPlacementnewsActivity;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;

public class PlacementNewsAdapter extends RecyclerView.Adapter<PlacementNewsAdapter.ViewHolder> {

    Context context;

    ArrayList<StudentAppResponse.Data.NewsPlacement> arrStudPlacementList;

    ArrayList<StudentAppAdminResponse.Data.Placement> arrAdminPlacementList;

    List<String> colors = new ArrayList<>();


    public PlacementNewsAdapter(Context context, ArrayList<StudentAppResponse.Data.NewsPlacement> arrStudPlacementList) {
        this.context = context;
        this.arrStudPlacementList = arrStudPlacementList;
    }

    public PlacementNewsAdapter(ArrayList<StudentAppAdminResponse.Data.Placement> arrAdminPlacementList, Context context) {
        this.context = context;
        this.arrAdminPlacementList = arrAdminPlacementList;
    }

    @NonNull
    @Override
    public PlacementNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        colors.add("#5E97F6");
        colors.add("#9CCC65");
        colors.add("#FF8A65");
        colors.add("#9E9E9E");
        colors.add("#9FA8DA");
        colors.add("#90A4AE");
        colors.add("#AED581");
        colors.add("#F6BF26");
        colors.add("#FFA726");
        colors.add("#4DD0E1");
        colors.add("#BA68C8");
        colors.add("#A1887F");

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customplacementlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final PlacementNewsAdapter.ViewHolder holder, final int position) {

        Random r = new Random();
        int i1 = r.nextInt(11);

        holder.cmpname.setBackgroundColor(Color.parseColor(colors.get(i1)));
        String name = null, news = null, date = null, title = null, uploadedBy = null,fileName = null;
        if (user.equals("student")){
            name = arrStudPlacementList.get(position).getName();
            news = arrStudPlacementList.get(position).getNews();
            date = arrStudPlacementList.get(position).getDate();
            title = arrStudPlacementList.get(position).getTitle();
            uploadedBy = arrStudPlacementList.get(position).getUploadBy();
            fileName = arrStudPlacementList.get(position).getFileName();

        }else if (user.equals("admin")){
            name = arrAdminPlacementList.get(position).getName();
            news = arrAdminPlacementList.get(position).getNews();
            date = arrAdminPlacementList.get(position).getDate();
            title = arrAdminPlacementList.get(position).getTitle();
            uploadedBy = arrAdminPlacementList.get(position).getUploadBy();
            fileName = arrAdminPlacementList.get(position).getFileName();

        }

        holder.cmpname.setText(name);
        holder.cmpnews.setText(news);
        holder.cmptime.setText(date);
        holder.cmptitle.setText(title);
        holder.txtadmin.setText(uploadedBy);

        holder.itemView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.tabsanim));

        String finalName = name;
        String finalTitle = title;
        String finalNews = news;
        String finalFileName = fileName;
        String finalUploadedBy = uploadedBy;
        String finalDate = date;

        holder.parentlayout.setOnClickListener(v -> {

            Intent intent = new Intent(context,FullPlacementnewsActivity.class);
            intent.putExtra("cmpname", finalName);
            intent.putExtra("cmptitle", finalTitle);
            intent.putExtra("cmpnews", finalNews);
            intent.putExtra("filename", finalFileName);
            intent.putExtra("time", finalDate);
            intent.putExtra("uploadedby", finalUploadedBy);

            context.startActivity(intent);

        });
    }


    @Override
    public int getItemCount() {
        if (user.equals("admin")){
            return arrAdminPlacementList.size();
        }else {
            return arrStudPlacementList.size();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView cmpname,cmptitle,cmpnews,cmptime,txtadmin;
        RelativeLayout parentlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentlayout = itemView.findViewById(R.id.customplacement_parentlayout);

            txtadmin = itemView.findViewById(R.id.customplacement_txtadmin);
            cmpname = itemView.findViewById(R.id.customplacement_cmpname);
            cmptitle = itemView.findViewById(R.id.customplacement_cmptitle);
            cmptime = itemView.findViewById(R.id.customplacement_cmptime);
            cmpnews = itemView.findViewById(R.id.customplacement_cmpnews);

        }
    }
}
