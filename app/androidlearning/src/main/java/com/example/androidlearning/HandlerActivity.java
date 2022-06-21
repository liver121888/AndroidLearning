package com.example.androidlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.androidlearning.utils.ToastUtil;

//similar to a timer
//threading communication
public class HandlerActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        //        handler = new Handler();
        //        //wait 3 seconds then go to ButtonActivity
        //        handler.postDelayed(new Runnable() {
        //            @Override
        //            public void run() {
        //                Intent intent = new Intent(HandlerActivity.this, ButtonActivity.class);
        //                startActivity(intent);
        //            }
        //        }, 3000);

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this,"thread comunication sucess",1);
                        break;
                    default:
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }.start();
    }
}