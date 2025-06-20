package com.example.memorygame

import androidx.lifecycle.lifecycleScope
import com.example.memorygame.compare
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun PlayActivity.extCardTapped(card: Card)
{
    if (!gameActive ||
        card.tileState == State.MATCHED ||
        card.tileState == State.UP)
        return

    card.tileState = State.UP
    card.updateTile()

    if (!secondTap) {
        card1 = card
        secondTap = true
    }
    else {
        card2 = card
        secondTap = false
        gameActive = false

        lifecycleScope.launch {
            delay(1000)
            compare()
        }
    }
}