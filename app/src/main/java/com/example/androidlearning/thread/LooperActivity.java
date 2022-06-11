package com.example.androidlearning.thread;

import static com.example.androidlearning.thread.ExampleHandler.TASK_A;
import static com.example.androidlearning.thread.ExampleHandler.TASK_B;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.example.androidlearning.R;

public class LooperActivity extends AppCompatActivity {
    private static final String TAG = "LooperActivity";

    private ExampleLooperThread looperThread = new ExampleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper);
    }

    public void startThread(View view) {
        looperThread.start();
    }

    public void stopThread(View view) {
        looperThread.looper.quit();
    }

    public void taskA(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_A;
        looperThread.handler.sendMessage(msg);

        Handler threadHandler = new Handler(looperThread.looper);
        threadHandler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.i(TAG, "run: " + i);
                    SystemClock.sleep(1000);
                }
            }
        });
    }

    public void taskB(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_B;
        looperThread.handler.sendMessage(msg);
    }
}