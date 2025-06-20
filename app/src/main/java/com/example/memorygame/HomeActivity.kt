package com.example.memorygame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class HomeActivity : AppCompatActivity() {

    lateinit var playButton: Button
    lateinit var difficultyBar: SwitchCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)

        playButton = findViewById(R.id.playButton_id)
        difficultyBar = findViewById(R.id.difficultyBar_id)

        playButton.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
            finish()
        }

        difficultyBar.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
            {
                difficultyBar.text = "6x6"
                AppData.difficulty = 6
            }
            else
            {
                difficultyBar.text = "4x4"
                AppData.difficulty = 4
            }
        }
    }
}