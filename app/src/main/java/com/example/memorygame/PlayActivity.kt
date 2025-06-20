package com.example.memorygame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PlayActivity() : AppCompatActivity(), GameFragmentListener
{
    var gridSize: Int = AppData.difficulty

    var secondTap: Boolean = false
    lateinit var card1: Card
    lateinit var card2: Card

    var gameActive: Boolean = true

    val foundCards: ArrayList<Card> = ArrayList()
    lateinit var currentTiles: ArrayList<Card>

    lateinit var wrong: TextView
    lateinit var newGameButton: Button
    lateinit var homeButton: Button

    override fun makeTiles(): ArrayList<Card>
    {
        return extMakeTiles()
    }

    override fun cardTapped(card: Card)
    {
        extCardTapped(card)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.play_layout)
        wrong = findViewById(R.id.wrong_id)
        newGameButton = findViewById<Button>(R.id.newGame_id)
        homeButton = findViewById<Button>(R.id.homeButton_id)

        restart()

        newGameButton.setOnClickListener {
            restart()
        }

        homeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}