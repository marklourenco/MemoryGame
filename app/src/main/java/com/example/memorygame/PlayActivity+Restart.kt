package com.example.memorygame

import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun PlayActivity.restart() {
    val frag = supportFragmentManager.findFragmentByTag("game")
    if (frag != null) {
        supportFragmentManager.beginTransaction().remove(frag).commit()
    }

    gameActive = false
    secondTap = false
    foundCards.clear()
    wrong.text = ""
    newGameButton.visibility = Button.GONE
    homeButton.visibility = Button.GONE

    supportFragmentManager.beginTransaction()
        .add(R.id.gameLayout_id, GameFragment.newInstance(gridSize), "game")
        .commit()

    lifecycleScope.launch {
        delay(100)

        for (card in currentTiles) {
            card.tileState = State.UP
        }

        delay(4000)

        for (card in currentTiles) {
            card.tileState = State.DOWN
            card.updateTile()
        }

        gameActive = true
    }
}