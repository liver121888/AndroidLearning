package com.example.androidlearning.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidlearning.R;

public class SharedPreferencesActivity extends AppCompatActivity {


    private EditText EtName;
    private Button BtnSave, BtnShow;
    private TextView TvShow;
    private SharedPreferences SharedPreferences;
    SharedPreferences.Editor Editor;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        EtName =  findViewById(R.id.et_name);
        BtnSave =  findViewById(R.id.btn_save);
        BtnShow =  findViewById(R.id.btn_show);
        TvShow =  findViewById(R.id.tv_show);
        SharedPreferences = this.getSharedPreferences("data",MODE_PRIVATE);
        Editor = SharedPreferences.edit();


        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editor.putString("name",EtName.getText().toString());
                //sync save to disk, will wait.
                //Editor.commit();
                //non-sync save to disk.
                Editor.apply();
                //save to where? /data/data/<applicationId>/shared_prefs
                //applicationId != package name, but default they will be the same
            }
        });

        BtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getString(), pass empty string ("") as default
                TvShow.setText(SharedPreferences.getString("name",""));
            }
        });



    }
}