package com.example.androidlearning.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidlearning.R;


public class BroadActivity extends AppCompatActivity {

    private TextView mTvTest;
    private MyBroadcast mBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);
        mTvTest = findViewById(R.id.tv_test);
        Button mBtn = findViewById(R.id.btn_broad);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BroadActivity.this,BroadActivity2.class);
                startActivity(intent);
                // In this sample, we just read simple value, we don't need the overkill broadcast
                //                startActivityForResult();
            }
        });
        mBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.update");
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcast, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister to prevent memory leaks
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcast);
    }

    private class MyBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.android.update":
                    mTvTest.setText("123");
                    break;
                default:
                    break;
            }

        }
    }

}