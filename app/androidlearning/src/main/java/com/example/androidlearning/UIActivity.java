package com.example.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlearning.fragment.ContainerActivity;
import com.example.androidlearning.recyclerview.RecyclerViewActivity;
import com.example.androidlearning.widgets.ButtonActivity;
import com.example.androidlearning.widgets.EditTextActivity;
import com.example.androidlearning.widgets.ImageViewActivity;
import com.example.androidlearning.widgets.TextViewActivity;

public class UIActivity extends AppCompatActivity {
    private Button btnTextview;
    private Button btnButton;
    private Button btnRv;
    private Button btnEditText;
    private Button btnImageView;
    private Button btnFragment;
    private Button btnToast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        OnClick onClick = new OnClick();

        btnRv = findViewById(R.id.btn_recyclerview);
        btnRv.setOnClickListener(onClick);

        btnTextview = findViewById(R.id.btn_Textview);
        btnTextview.setOnClickListener(onClick);

        btnButton = findViewById(R.id.btn_button);
        btnButton.setOnClickListener(onClick);

        btnEditText = findViewById(R.id.btn_edittext);
        btnEditText.setOnClickListener(onClick);

        btnImageView = findViewById(R.id.btn_imageview);
        btnImageView.setOnClickListener(onClick);


        btnFragment = findViewById(R.id.btn_fragment);
        btnFragment.setOnClickListener(onClick);

        btnToast = findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        private Intent intent;

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btn_recyclerview:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;

                case R.id.btn_Textview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;

                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(UIActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                default:
                    intent = new Intent();
                    break;
            }
            startActivity(intent);
        }
    }


}