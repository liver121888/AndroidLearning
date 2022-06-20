package com.example.androidlearning.rsvp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlearning.R
import com.example.androidlearning.rsvp.affirmations.AffirmationsActivity
import com.example.androidlearning.rsvp.busschedule.BusScheduleActivity
import com.example.androidlearning.rsvp.cupcakeapp.CupcakeAppActivity
import com.example.androidlearning.rsvp.marsphotos.MarsPhotosActivity
import com.example.androidlearning.rsvp.sqlbasics.SqlBasicActivity
import com.example.androidlearning.rsvp.unscrambleapp.UnscrambleAppActivity
import com.example.androidlearning.rsvp.wordsapp.WordsAppActivity

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
        val btnAffirmations : Button  = findViewById(R.id.btn_affirmations)
        btnAffirmations.setOnClickListener{
            startActivity(Intent(this, AffirmationsActivity::class.java))
        }
        val btnWordsApp : Button  = findViewById(R.id.btn_wordsapp)
        btnWordsApp.setOnClickListener{
            startActivity(Intent(this, WordsAppActivity::class.java))
        }
        val btnUnscrambleApp : Button  = findViewById(R.id.btn_unscrambleapp)
        btnUnscrambleApp.setOnClickListener{
            startActivity(Intent(this, UnscrambleAppActivity::class.java))
        }
        val btnCupcakeApp : Button  = findViewById(R.id.btn_cupcakeapp)
        btnCupcakeApp.setOnClickListener{
            startActivity(Intent(this, CupcakeAppActivity::class.java))
        }
        val btnMarsPhotos : Button  = findViewById(R.id.btn_marsphotos)
        btnMarsPhotos.setOnClickListener {
            startActivity(Intent(this, MarsPhotosActivity::class.java))
        }
        val btnSQLBasics : Button  = findViewById(R.id.btn_sqlbasics)
            btnSQLBasics.setOnClickListener{
                startActivity(Intent(this, SqlBasicActivity::class.java))
        }
        val btnBusSchedule : Button  = findViewById(R.id.btn_busschedule)
        btnBusSchedule.setOnClickListener{
            startActivity(Intent(this, BusScheduleActivity::class.java))
        }
    }
}