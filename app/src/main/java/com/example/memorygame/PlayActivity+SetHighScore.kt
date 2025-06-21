package com.example.memorygame

import org.json.JSONObject
import java.io.File

fun PlayActivity.saveHighScore(difficulty: Int, newTime: Long) {
    val filename = "highscores.json"
    val file = File(filesDir, filename)
    val json = if (file.exists()) {
        JSONObject(file.readText())
    } else {
        JSONObject()
    }

    val key = difficulty.toString()
    val existing = json.optLong(key, Long.MAX_VALUE)
    if (newTime < existing) {
        json.put(key, newTime)
        file.writeText(json.toString())
    }
}