package com.example.androidlearning.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidlearning.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button btnlinear, btnhor, btngrid, btnpu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        btnlinear = findViewById(R.id.btn_linear);
        btnlinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this, LinearActivity.class);
                startActivity(intent);
            }
        });


        btnhor = findViewById(R.id.btn_hor);
        btnhor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this, HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btngrid = findViewById(R.id.btn_grid);
        btngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btnpu = findViewById(R.id.btn_pu);
        btnpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this, PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });


    }
}

