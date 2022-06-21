package com.example.androidlearning.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidlearning.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private AFragment aFragment;
    private BFragment bFragment;
    private TextView Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        Tv = findViewById(R.id.tv_title);
        aFragment = AFragment.newInstance("I am an argument");
        getFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
    }




    public void setData(String Text){
        Tv.setText(Text);
    }


    @Override
    //not recommend
    public void onClick(String text) {
        Tv.setText(text);
    }
}