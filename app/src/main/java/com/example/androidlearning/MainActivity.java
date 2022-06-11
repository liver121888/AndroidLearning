package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidlearning.broadcast.BroadActivity;
import com.example.androidlearning.job.JobActivity;
import com.example.androidlearning.rsvp.RsvpPortalActivity;
import com.example.androidlearning.service.ServiceActivity;
import com.example.androidlearning.datastorage.DataStorageActivity;
import com.example.androidlearning.event.EventActivity;
import com.example.androidlearning.thread.LooperActivity;
import com.example.androidlearning.thread.ThreadActivity;

public class MainActivity extends AppCompatActivity {
    private Button BtnUi;
    private Button BtnEvent, BtnData, BtnThreading, BtnLooper, BtnService;
    private Button BtnViewModel, BtnAsyncTask, BtnBroadcast, BtnJob;
    private Button BtnRSVP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClick onClick = new OnClick();

        BtnUi = findViewById(R.id.btn_ui);
        BtnUi.setOnClickListener(onClick);

        BtnEvent = findViewById(R.id.btn_event);
        BtnEvent.setOnClickListener(onClick);

        BtnData = findViewById(R.id.btn_data);
        BtnData.setOnClickListener(onClick);

        BtnThreading = findViewById(R.id.btn_threading);
        BtnThreading.setOnClickListener(onClick);

        BtnLooper = findViewById(R.id.btn_looper);
        BtnLooper.setOnClickListener(onClick);


        BtnService = findViewById(R.id.btn_service);
        BtnService.setOnClickListener(onClick);

        BtnViewModel = findViewById(R.id.btn_viewmodel);
        BtnViewModel.setOnClickListener(onClick);

        BtnAsyncTask = findViewById(R.id.btn_asynctask);
        BtnAsyncTask.setOnClickListener(onClick);

        BtnBroadcast = findViewById(R.id.btn_broadcast);
        BtnBroadcast.setOnClickListener(onClick);

        BtnJob = findViewById(R.id.btn_job);
        BtnJob.setOnClickListener(onClick);

        BtnRSVP = findViewById(R.id.btn_rsvp);
        BtnRSVP.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        private Intent intent;

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_threading:
                    intent = new Intent(MainActivity.this, ThreadActivity.class);
                    break;
                case R.id.btn_looper:
                    intent = new Intent(MainActivity.this, LooperActivity.class);
                    break;

                case R.id.btn_service:
                    intent = new Intent(MainActivity.this, ServiceActivity.class);
                    break;

                case R.id.btn_viewmodel:
                    intent = new Intent(MainActivity.this, ViewModelActivity.class);
                    break;

                case R.id.btn_asynctask:
                    intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
                    break;

                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;

                case R.id.btn_job:
                    intent = new Intent(MainActivity.this, JobActivity.class);
                    break;
                case R.id.btn_rsvp:
                    intent = new Intent(MainActivity.this, RsvpPortalActivity.class);
                    break;
                default:
                    intent = new Intent();
                    break;
            }
            startActivity(intent);
        }
    }


}