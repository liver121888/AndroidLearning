package com.example.androidlearning.rsvp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlearning.R

class RsvpPortalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rsvpportal)
        val btnTips : Button  = findViewById(R.id.btn_tips)
        val intent = Intent(this, TipsActivity::class.java)
        btnTips.setOnClickListener{
            startActivity(intent)
        }
        val btnHappyBirthday : Button  = findViewById(R.id.btn_birthday)
        btnHappyBirthday.setOnClickListener{
            startActivity(Intent(this, HappyActivity::class.java))
        }
    }
}