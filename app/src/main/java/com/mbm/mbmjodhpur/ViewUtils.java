package com.mbm.mbmjodhpur;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.annotation.NonNull;

public class ViewUtils {
    //    toast
    public static void toast(@NonNull Context context , @NonNull String msg){
        Toast toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public static void openWebPage(Context context, String url) {
        try {
            if (!URLUtil.isValidUrl(url)) {
                toast(context, " This is not a valid link");
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                context.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            toast(context, " You don't have any browser to open web page");
        }
    }

}
