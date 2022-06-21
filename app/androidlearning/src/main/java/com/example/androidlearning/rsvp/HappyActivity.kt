package com.example.androidlearning.rsvp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlearning.R

class HappyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy)
        val rollButton: Button = findViewById(R.id.button4)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView5)
        resultTextView.text = diceRoll.toString()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView2)
        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

    //    fun main() {
    //        // both declarations work
    //        //        val diceRange: IntRange = 1..6
    //        val diceRange = 1..6
    //        val randomNumber = diceRange.random()
    //        println("Random number: $randomNumber")
    //
    //        val myFirstDice = Dice(6)
    //        println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll()}!")
    //
    //        val mySecondDice = Dice(20)
    //        println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll()}!")
    //    }

}