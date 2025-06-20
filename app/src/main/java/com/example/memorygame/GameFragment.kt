package com.example.memorygame

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameFragment (var gridSize: Int) : Fragment()
{
    private lateinit var caller: GameFragmentListener

    companion object
    {
        fun newInstance(grid: Int) : GameFragment
        {
            return GameFragment(grid)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is GameFragmentListener)
        {
            caller = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        val fragment = inflater.inflate(R.layout.fragment_game, container, false)

        val context = activity as Context
        val recyclerView = fragment.findViewById<RecyclerView>(R.id.recyclerView_id)
        recyclerView.layoutManager = GridLayoutManager(context, gridSize)

        val textViews = caller.makeTiles()
        recyclerView.adapter = RecyclerAdapter(textViews, caller)

        return fragment
    }
}