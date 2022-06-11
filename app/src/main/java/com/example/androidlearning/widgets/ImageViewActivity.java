package com.example.androidlearning.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.androidlearning.R;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView Iv4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        //        Iv4 = findViewById(R.id.iv_4);
        //        Glide.with(this).load("https://scontent-tpe1-1.xx.fbcdn.net/v/t1.6435-9/95698738_2881659935221361_7513201834379444224_n.png?_nc_cat=111&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=l60p1bT55CAAX9POCsQ&_nc_ht=scontent-tpe1-1.xx&oh=00_AT9FOLAI084jSxGPkTwssogYYfBQY4c5J0sA6DXjs6T1Kg&oe=621E9C3A").into(Iv4);
    }
}