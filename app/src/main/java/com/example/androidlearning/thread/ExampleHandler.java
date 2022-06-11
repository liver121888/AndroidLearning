package com.example.androidlearning.thread;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ExampleHandler extends Handler {
    private static final String TAG = "ExampleHandler";

    public static final int TASK_A = 1;
    public static final int TASK_B = 2;

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case TASK_A:
                Log.i(TAG, "Task A executed");
                break;
            case TASK_B:
                Log.i(TAG, "Task B executed");
                break;
        }
    }
}
