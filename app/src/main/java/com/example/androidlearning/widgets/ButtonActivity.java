package com.example.androidlearning.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidlearning.R;

public class ButtonActivity extends AppCompatActivity {

    private Button btn3;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(ButtonActivity.this,"btn3 clicked",Toast.LENGTH_SHORT).show();
            }
        });

        tv1 = findViewById(R.id.tv1);
                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ButtonActivity.this,"tv1 clicked",Toast.LENGTH_SHORT).show();

                    }
                });
    }


    public void showToast(View view){
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();


    }
}