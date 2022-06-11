package com.example.androidlearning;

import android.app.Activity;
import android.view.View;

import com.example.androidlearning.utils.ToastUtil;


//class outside to realize (not recommended)
public class MyClicklistener implements View.OnClickListener {

    private Activity myActivity;


    public MyClicklistener(Activity activity){
        this.myActivity = activity;

    }

    @Override
    public void onClick(View view) {
        ToastUtil.showMsg(myActivity, "click....",1);
    }
}
