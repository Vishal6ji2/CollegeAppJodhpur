package com.mbm.mbmjodhpur.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.mbm.mbmjodhpur.ModelResponse.StudentAppAdminResponse;
import com.mbm.mbmjodhpur.ModelResponse.StudentAppResponse;
import com.mbm.mbmjodhpur.R;

import java.util.ArrayList;

import static com.mbm.mbmjodhpur.Activities.HomeActivity.user;
import static com.mbm.mbmjodhpur.ViewUtils.openWebPage;

public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.ViewHolder> {

    Context context;

    ArrayList<StudentAppResponse.Data.Link> arrStudLinksList;

    ArrayList<StudentAppAdminResponse.Data.Link> arrAdminLinksList;


    public LinksAdapter(Context context, ArrayList<StudentAppResponse.Data.Link> arrStudLinksList) {
        this.context = context;
        this.arrStudLinksList = arrStudLinksList;
    }

    public LinksAdapter(ArrayList<StudentAppAdminResponse.Data.Link> arrAdminLinksList, Context context) {
        this.context = context;
        this.arrAdminLinksList = arrAdminLinksList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customlinkslayout, parent, false));
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        if (user.equals("student")){

            holder.txtname.setText(arrStudLinksList.get(position).getName());

            holder.txtname.setPaintFlags(holder.txtname.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            holder.itemView.setOnClickListener(v -> openWebPage(context,arrStudLinksList.get(position).getUrl()));

            showDialog(holder, arrStudLinksList.get(position).getName(), arrStudLinksList.get(position).getAdminId());

        }else if (user.equals("admin")){

            holder.txtname.setText(arrAdminLinksList.get(position).getName());

            holder.txtname.setPaintFlags(holder.txtname.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            holder.itemView.setOnClickListener(v -> openWebPage(context,arrAdminLinksList.get(position).getUrl()));

            showDialog(holder, arrAdminLinksList.get(position).getName(), arrAdminLinksList.get(position).getAdminId());

        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private void showDialog(ViewHolder holder, String urlName, String adminId){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        holder.itemView.setOnTouchListener((v, event) -> {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // button pressed
                alertDialog.setTitle(urlName);
                alertDialog.setMessage("This Link is uploaded by "+adminId);
                alertDialog.show();

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // button relased.
                alertDialog.dismiss();
            }
            return false;
        });

    }


    @Override
    public int getItemCount() {
        if (user.equals("admin")){
            return arrAdminLinksList.size();
        }else {
            return arrStudLinksList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.customlink_txtname);
        }
    }
}
