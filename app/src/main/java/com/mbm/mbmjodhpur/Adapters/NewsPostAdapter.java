package com.mbm.mbmjodhpur.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;

public class NewsPostAdapter extends RecyclerView.Adapter<NewsPostAdapter.ViewHolder> {

    Context context;

    ArrayList<StudentAppResponse.Data.News> arrStudNewsList;

    ArrayList<StudentAppAdminResponse.Data.News> arrAdminNewsList;

    ArrayList<String> imagelist ;

    ImageView[] dots;

    int dotscount;


    public NewsPostAdapter(Context context, ArrayList<StudentAppResponse.Data.News> arrStudNewsList) {
        this.context = context;
        this.arrStudNewsList = arrStudNewsList;
    }

    public NewsPostAdapter(ArrayList<StudentAppAdminResponse.Data.News> arrAdminNewsList, Context context) {
        this.context = context;
        this.arrAdminNewsList = arrAdminNewsList;
    }

    @NonNull
    @Override
    public NewsPostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.custompostlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsPostAdapter.ViewHolder holder, final int position) {

        String title = null,description = null;

        if (user.equals("admin")){
            title = arrAdminNewsList.get(position).getTitle();
            description = arrAdminNewsList.get(position).getDescription();
        }else if (user.equals("student")){
            title = arrStudNewsList.get(position).getTitle();
            description = arrStudNewsList.get(position).getDescription();
        }

//        imagelist = arrnewspostlist.get(position).get();

        if (imagelist != null && imagelist.size() != 0) {

            holder.cardParent.setVisibility(View.VISIBLE);
            holder.viewPager.setVisibility(View.VISIBLE);


            if (description != null) {
                if (!description.equals("")) {

                    holder.txtdetails.setVisibility(View.VISIBLE);
                    holder.txtheading.setVisibility(View.VISIBLE);

                    holder.txtheading.setText(title);
                    holder.txtdetails.setText(description);

                } else {
                    holder.txtheading.setVisibility(View.GONE);
                    holder.txtdetails.setVisibility(View.GONE);
                }
            }

            if (imagelist.size() == 1) {
                holder.lldots.setVisibility(View.GONE);
            } else if (imagelist.size() > 1) {

                preparedots(holder);
                holder.lldots.setVisibility(View.VISIBLE);
            }
            SnapHelper mSnapHelper = new LinearSnapHelper();
            holder.viewPager.setOnFlingListener(null);
            mSnapHelper.attachToRecyclerView(holder.viewPager);
            holder.viewPager.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            holder.viewPager.setAdapter(new SlideRecyclerAdapter(context, imagelist));

            setNormalViews(holder, position);

        }
        else {
            if ((imagelist != null)) {
                imagelist.size();
            }

            holder.viewPager.setVisibility(View.GONE);
            holder.lldots.setVisibility(View.GONE);

            if (description != null) {
                if (!description.equals("")) {

                    holder.cardParent.setVisibility(View.VISIBLE);

                    holder.txtheading.setVisibility(View.VISIBLE);
                    holder.txtdetails.setVisibility(View.VISIBLE);

                    holder.txtheading.setText(title);
                    holder.txtdetails.setText(description);

                    setNormalViews(holder, position);

                } else {
                    holder.cardParent.setVisibility(View.GONE);
                }
            }
        }

        holder.itemView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.tabsanim));

    }


    private void setNormalViews(ViewHolder holder, int position) {
/*
        holder.profilename.setText(arrnewspostlist.get(position).getAdminName());
        holder.txttimeago.setText(arrnewspostlist.get(position).getNewsTime());
        holder.txtdate.setText(arrnewspostlist.get(position).getNewsDate());*/

    }

    void preparedots(final ViewHolder holder) {

        holder.lldots.removeAllViews();

        dotscount = imagelist.size();

        dots = new ImageView[dotscount];

        for (int i = 0; i<dotscount;i++){

            dots[i] = new ImageView(context);

            dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.unselectdots));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(4, 0, 4, 0);

            holder.lldots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.selecteddots));


        holder.viewPager.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) holder.viewPager.getLayoutManager();
                if (linearLayoutManager != null) {
                    int firstelementposition = linearLayoutManager.findFirstVisibleItemPosition();
                    setDots(firstelementposition);
                }
            }
        });
    }

    public void setDots(int position){
        for (int i = 0; i<dotscount; i++){
            dots[i].setImageDrawable(ContextCompat.getDrawable(context,R.drawable.unselectdots));
        }
        dots[position].setImageDrawable(ContextCompat.getDrawable(context,R.drawable.selecteddots));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (user.equals("admin")) {
            return arrAdminNewsList.size();
        } else {
            return arrStudNewsList.size();
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        TextView profilename,txtheading,txtdetails,txtdate,txttimeago;

        CircularImageView profileimg;

        RelativeLayout cardParent;

        RecyclerView viewPager;

        LinearLayout lldots;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lldots = itemView.findViewById(R.id.custompost_lldots);

            cardParent = itemView.findViewById(R.id.custompost_parentlayout);

            profilename = itemView.findViewById(R.id.custompost_profilename);
            txtheading = itemView.findViewById(R.id.custompost_txtheading);
            txtdetails = itemView.findViewById(R.id.custompost_txtdetails);
            txtdate = itemView.findViewById(R.id.custompost_posttime);
            txttimeago = itemView.findViewById(R.id.custompost_timeago);

            profileimg = itemView.findViewById(R.id.custompost_profileimg);

            viewPager = itemView.findViewById(R.id.custompost_recyclerview);

        }
    }

}
