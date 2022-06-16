package com.example.androidlearning.service;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidlearning.R;

public class MyBackgroundService extends Service {
    private static final String TAG = "MyBackgroundService";
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // would be called when startService() or startForegroundService(), in here startService()
        if (intent.getAction() != null)
            if (intent.getAction().equals("Stop")) {
                Log.i(TAG, "Received Stop Background Intent");
                //your end service code
                stopForeground(true);
                stopSelfResult(startId);
                Log.d(TAG, "MyBackgroundService is stopped");
                Toast.makeText(this, "MyBackground is stopped", Toast.LENGTH_SHORT).show();
                return super.onStartCommand(intent, flags, startId);
            }
        new Handler(Looper.getMainLooper()).post(() ->
                Toast.makeText(MyBackgroundService.this, "Background service is running.", Toast.LENGTH_SHORT).show());


        // this method congest the looper I think, it only toast once
        //        new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                //                Looper.prepare();
        //
        //                while (true){
        //                    Log.d(TAG, "Service is running");
        //                    //                    ToastUtil.showMsg(MyBackgroundService.this,"Service is running", 0);
        //                    //                    Looper.loop();
        //                    try {
        //                        Thread.sleep(2000);
        //                    }catch (InterruptedException e){
        //                        e.printStackTrace();
        //                    }
        //                }
        //
        //            }
        //        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Background service is stopped.", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
