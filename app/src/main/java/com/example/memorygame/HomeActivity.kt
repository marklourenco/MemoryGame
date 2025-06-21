package com.example.memorygame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class HomeActivity : AppCompatActivity() {

    lateinit var playButton: Button
    lateinit var difficultyBar: SwitchCompat
    lateinit var highScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)

        playButton = findViewById(R.id.playButton_id)
        difficultyBar = findViewById(R.id.difficultyBar_id)
        highScore = findViewById<TextView>(R.id.highschore_id)
        highScore.text = getHighScore(AppData.difficulty)

        playButton.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
            finish()
        }

        difficultyBar.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
            {
                difficultyBar.text = "6x6  "
                AppData.difficulty = 6
                highScore.text = getHighScore(AppData.difficulty)
            }
            else
            {
                difficultyBar.text = "4x4  "
                AppData.difficulty = 4
                highScore.text = getHighScore(AppData.difficulty)
            }
        }
    }
}