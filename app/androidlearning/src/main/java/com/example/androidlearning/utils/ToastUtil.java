package com.example.androidlearning.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast toast;
    public static void showMsg(Context context, String msg, int toastType){
        if(toast==null){
            // long = 1, short = 0
            toast = Toast.makeText(context,msg,toastType);

        }else{

            toast.setText(msg);
        }
        toast.show();
    }

}
