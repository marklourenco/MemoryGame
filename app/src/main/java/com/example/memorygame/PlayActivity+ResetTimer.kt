package com.example.memorygame

fun PlayActivity.resetTimer() {
    handler.removeCallbacks(updateTimer)
    elapsedMillis = 0L
    startTime = System.currentTimeMillis()
    timerText.text = "00:00"
    handler.post(updateTimer)
}
