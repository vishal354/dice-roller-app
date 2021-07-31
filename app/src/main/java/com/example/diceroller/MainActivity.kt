package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

//This activity allows user to roll a dice and print the result on the screen
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Target the button to roll a dice
        val rollButton: Button = findViewById(R.id.button)

        // Roll the dice again if button is clicked
        rollButton.setOnClickListener {
            rollDice()
        }

        // Roll initially so the screen does not look empty
        rollDice()
    }

    private fun rollDice() {
        // Creating a dice with 6 sides and rolling it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Printing the result of dice roll on the screen
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Set drawable resource based on outcome of dice roll
        val drawableResource = when(diceRoll) {
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else ->R.drawable.dice_6
        }

        // Update the outcome on the screen
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

// This class defines a dice with n sides and allows us to roll it
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}