package com.example.memorygame

interface GameFragmentListener
{
    fun makeTiles() : ArrayList<Card>
    fun cardTapped(card: Card)
}