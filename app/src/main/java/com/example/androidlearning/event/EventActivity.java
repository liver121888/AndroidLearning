package com.example.androidlearning.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.androidlearning.HandlerActivity;
import com.example.androidlearning.R;
import com.example.androidlearning.utils.ToastUtil;
import com.example.androidlearning.widgets.ButtonActivity;
import com.example.androidlearning.widgets.MyButton;


//implement an interface to realize
//public class EventActivity extends AppCompatActivity implements View.OnClickListener{
public class EventActivity extends AppCompatActivity{


    private Button BtnEvent, BtnHandler;
    private MyButton BtnMyEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        BtnEvent = findViewById(R.id.btn_event);
        BtnMyEvent = findViewById(R.id.btn_my);
        BtnHandler = findViewById(R.id.btn_handler);

        BtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

        //after long click, if false, OnClick execute
        BtnMyEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Listener", "LongClick");
            }
        });

        //500ms
        BtnMyEvent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.i("Listener", "onClick");
                return false;
            }
        });

        //listener has a higher priority over touch callback
        //100ms
        BtnMyEvent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("Listener", "on touch");
                        Intent intent = new Intent(EventActivity.this, ButtonActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        //listener methods
        //priority: the method set last would work

        //class inside to realize
        BtnEvent.setOnClickListener(new OnClick());

        //anonymous class inside to realize
        //        btn_event.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                ToastUtil.showMsg(EventActivity.this,"click...");
        //            }
        //        });

        //implement an interface to realize
        //        btn_event.setOnClickListener(EventActivity.this);
        //class outside to realize (not recommended)
        //        btn_event.setOnClickListener(new MyClicklistener(EventActivity.this));
    }

    //callback in Activity
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("Activity", "--on touch event");
                Intent intent = new Intent(EventActivity.this, ButtonActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    //implement an interface to realize
    //    @Override
    //    public void onClick(View view) {
    //        switch (view.getId())
    //        {
    //            case R.id.btn_event:
    //                ToastUtil.showMsg(EventActivity.this,"click...");
    //                break;
    //
    //        }
    //    }

    //class inside to realize
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btn_event:
                    ToastUtil.showMsg(EventActivity.this,"click...",1);
                    break;

            }
        }
    }

    //    //write in layout to realize
    //    //the method is the first to be set, so the priority is the lowest
    //    public void show(View v){
    //        switch (v.getId())
    //        {
    //            case R.id.btn_event:
    //                ToastUtil.showMsg(EventActivity.this,"click...");
    //                break;
    //
    //        }
    //    }

}