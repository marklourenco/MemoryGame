package com.example.memorygame

import android.widget.Button
import android.widget.Toast

fun PlayActivity.compare ()
{
    if (card1.value == card2.value)
    {
        card1.tileState = State.MATCHED
        card1.updateTile()
        card2.tileState = State.MATCHED
        card2.updateTile()

        foundCards.add(card1)
        foundCards.add(card2)

        if (foundCards.size == (gridSize * gridSize))
        {
            newGameButton.visibility = Button.VISIBLE
            homeButton.visibility = Button.VISIBLE
            handler.removeCallbacks(updateTimer)
            saveHighScore(difficulty, elapsedMillis)
        }
    }
    else
    {
        card1.tileState = State.DOWN
        card1.updateTile()
        card2.tileState = State.DOWN
        card2.updateTile()
        wrong.text = wrong.text.toString() + "❌"

    }
    gameActive = true

    if (wrong.text.length == 5)
    {
        gameActive = false
        newGameButton.visibility = Button.VISIBLE
        homeButton.visibility = Button.VISIBLE
        handler.removeCallbacks(updateTimer)
        for (card in currentTiles) {
            if (card.tileState == State.DOWN) {
                card.tileState = State.UP
                card.updateTile()
            }
        }
    }
}