package com.example.androidlearning.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyButton extends androidx.appcompat.widget.AppCompatButton {



    public MyButton (Context context){
        super(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //callback at widget first, then to activity
    //spread outward
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("MyButton", "--touch event");
                break;
        }
        //false: continue to spread, true: the react to this event is done by me no need to spread
        return false;
    }


    //an entrance of event
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("MyButton","dispatchTouchEvent");
        return false;
    }
}
