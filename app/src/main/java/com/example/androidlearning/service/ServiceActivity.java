package com.example.androidlearning.service;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidlearning.R;


public class ServiceActivity extends AppCompatActivity {
    Button BtnBackgroundService, BtnStopForegroundService, BtnStopBackgroundService;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        BtnBackgroundService = findViewById(R.id.btn_background_service);
        BtnStopForegroundService = findViewById(R.id.btn_foreground_service_stop);
        BtnStopBackgroundService = findViewById(R.id.btn_background_service_stop);
        if(!foregroundServiceRunning())
        {
            Intent serviceIntent = new Intent(this, MyForegroundService.class);
            startService(serviceIntent);
        }

        Intent bgServiceIntent = new Intent(this, MyBackgroundService.class);
        BtnBackgroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(bgServiceIntent);
            }
        });

        BtnStopForegroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StopforegroundService();
            }
        });

        BtnStopBackgroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StopBackgroundService();
            }
        });


    }

    // check whether the service is already running, to prevent multiple service
    public boolean foregroundServiceRunning(){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service: activityManager.getRunningServices(Integer.MAX_VALUE)){
            if (MyForegroundService.class.getName().equals(service.service.getClassName())) {
                return  true;
            }
        }
        return false;
    }

    // check whether the service is already running, to prevent multiple service
    private void StopforegroundService(){
        Intent stopIntent = new Intent(ServiceActivity.this, MyForegroundService.class);
        stopIntent.setAction("Stop");
        startService(stopIntent);
    }
    private void StopBackgroundService() {
        Intent stopIntent = new Intent(ServiceActivity.this, MyBackgroundService.class);
        stopIntent.setAction("Stop");
        stopService(stopIntent);
    }


}