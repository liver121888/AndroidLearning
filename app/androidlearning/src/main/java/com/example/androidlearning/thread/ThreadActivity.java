package com.example.androidlearning.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidlearning.R;

public class ThreadActivity extends AppCompatActivity {
    private static final String TAG = "ThreadActivity";
    private Button startButton;
    private Button stopButton;
    private Handler mainHandler = new Handler();
    private TextView tv_cnt;

    private volatile boolean stopThread = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        startButton = findViewById(R.id.button_startThread);
        stopButton =  findViewById(R.id.button_stopThread);
        tv_cnt = findViewById(R.id.tv_cnt);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startThread();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopThread();
            }
        });

    }

    public void startThread(){
        stopThread = false;
        //ExampleThread thread = new ExampleThread(10);
        //thread.start();
        //more preferred way
        ExampleRunnable runnable = new ExampleRunnable(10);
        new Thread(runnable).start();

        //new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        //work
        //    }
        //}).start();
    }

    public void stopThread(){
        stopThread = true;
    }
    // threading by extends Thread class
    class ExampleThread extends Thread{
        int seconds;

        ExampleThread(int sec){
            this.seconds = sec;

        }

        @Override
        public void run() {
            for(int i = 0; i < seconds; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // threading by implement Runnable interface
    class ExampleRunnable implements Runnable{
        int seconds;
        ExampleRunnable(int seconds){
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for(int i = 0; i < seconds; i++){
                if (stopThread)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_cnt.setText("stopThread");
                            startButton.setText("startThread");
                        }
                    });
                    return;
                }
                if (i == 5){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startButton.setText("50%");
                        }
                    });

                    //startButton.post(new Runnable() {
                    //    @Override
                    //    public void run() {
                    //        startButton.setText("50%");
                    //    }
                    //})

                    //Handler threadHandler = new Handler(Looper.getMainLooper());
                    //threadHandler.post(new Runnable() {
                    //    @Override
                    //    public void run() {
                    //        startButton.setText("50%");
                    //    }
                    //});

                    //mainHandler.post(new Runnable() {
                    //    @Override
                    //    public void run() {
                    //        startButton.setText("50%");
                    //    }
                    //});
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "startThread: " + i);
                tv_cnt.setText("startThread: "+i);
            }
            tv_cnt.setText("");
            startButton.setText("startThread");

        }
    }
}