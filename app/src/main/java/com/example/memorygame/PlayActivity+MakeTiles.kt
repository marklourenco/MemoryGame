package com.example.memorygame

fun PlayActivity.extMakeTiles() : ArrayList<Card>
{
    val emojis = listOf(
        "🍒", "🍒", "🍉", "🍉", "🍇", "🍇", "🍊", "🍊",
        "🍋", "🍋", "🍍", "🍍", "🍎", "🍎", "🍓", "🍓",
        "🍐", "🍐", "🍋", "🍋", "🍉", "🍉", "🍇", "🍇",
        "🍊", "🍊", "🍒", "🍒", "🍓", "🍓", "🍍", "🍍",
        "🍎", "🍎", "🍐", "🍐"
    )

    val tilesArray: ArrayList<Card> = ArrayList()
    for (i in 1..(gridSize * gridSize)) {
        val newTile = Card(this, emojis[i - 1])
        newTile.updateTile()
        tilesArray.add(newTile)
    }

    tilesArray.shuffle()
    currentTiles = tilesArray
    return tilesArray
}