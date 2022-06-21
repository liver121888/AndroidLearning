package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidlearning.utils.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button btnToast1, btnToast2, btnToast3, btnToast4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        btnToast1 = findViewById(R.id.btn_toast_1);
        btnToast2 = findViewById(R.id.btn_toast_2);
        btnToast3 = findViewById(R.id.btn_toast_3);
        btnToast4 = findViewById(R.id.btn_toast_4);
        OnClick onClick = new OnClick();
        btnToast1.setOnClickListener(onClick);
        btnToast2.setOnClickListener(onClick);
        btnToast3.setOnClickListener(onClick);
        btnToast4.setOnClickListener(onClick);

    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(),"centered Toast",Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View v = inflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = v.findViewById(R.id.iv_toast);
                    TextView textView = v.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.crowna);
                    textView.setText("Customized Toast");
                    toastCustom.setView(v);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"packaged Toast",1);
            }
        }
    }





}