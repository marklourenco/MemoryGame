package com.example.memorygame

import org.json.JSONObject
import java.io.File

fun HomeActivity.getHighScore(difficulty: Int): String {
    val file = File(filesDir, "highscores.json")
    if (!file.exists()) return "No record"

    val json = JSONObject(file.readText())
    val key = difficulty.toString()
    val time = json.optLong(key, -1)
    if (time == -1L) return "No record"

    val seconds = (time / 1000) % 60
    val minutes = (time / 1000) / 60
    return String.format("Highscore:\n%02d:%02d", minutes, seconds)
}