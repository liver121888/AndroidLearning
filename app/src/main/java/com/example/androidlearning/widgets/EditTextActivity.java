package com.example.androidlearning.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidlearning.R;

public class EditTextActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText EtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditTextActivity.this, "logged", Toast.LENGTH_SHORT);
            }
        });

        EtUsername = findViewById(R.id.et_1);
        EtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                Log.i("edittext", charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}