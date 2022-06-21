package com.example.androidlearning.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidlearning.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button BtnSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        BtnSharedPreferences = findViewById(R.id.btn_sharedpreference);
        BtnSharedPreferences.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId())
        {
            case R.id.btn_sharedpreference:
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                startActivity(intent);
                break;
        }

    }
}