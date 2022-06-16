package com.example.androidlearning.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.androidlearning.R;
import com.example.androidlearning.utils.ToastUtil;

public class MyForegroundService extends Service {
    private static final String TAG = "MyForegroundService";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent.getAction() != null)
            if (intent.getAction().equals("Stop")) {
                Log.i(TAG, "Received Stop Foreground Intent");
                //your end service code
                stopForeground(true);
                stopSelfResult(startId);
                Log.d(TAG, "MyForegroundService is stopped");
                Toast.makeText(this, "MyForegroundService is stopped", Toast.LENGTH_SHORT).show();
                return super.onStartCommand(intent, flags, startId);
            }


        new Handler(Looper.getMainLooper()).post(() -> {
                Log.d(TAG, "MyForegroundService is running");
                ToastUtil.showMsg(MyForegroundService.this,"MyForegroundService is running", 0);
        });



        //        // would be called when startService() or startForegroundService(), in here startForegroundService() cuz this is a Foreground service
        //        new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                while (true){
        //                    Log.d(TAG, "Service is running");
        //                    Looper.prepare();
        //                    ToastUtil.showMsg(MyForegroundService.this,"ForegroundService is running", 0);
        //                    Looper.loop();
        //
        //                    try {
        //                        Thread.sleep(4000);
        //                    }catch (InterruptedException e){
        //                        e.printStackTrace();
        //                    }
        //                }
        //            }
        //        }).start();
        return super.onStartCommand(intent, flags, startId);
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        final String CHANNELID = "Foreground Service ID";
        NotificationChannel channel = new NotificationChannel(
                CHANNELID,
                CHANNELID,
                NotificationManager.IMPORTANCE_LOW

        );
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification = new Notification.Builder(this, CHANNELID)
                .setContentText("MyForegroundService is running")
                .setContentTitle("MyForegroundService enabled")
                .setSmallIcon(R.drawable.ic_paws);

        startForeground(1001, notification.build());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}