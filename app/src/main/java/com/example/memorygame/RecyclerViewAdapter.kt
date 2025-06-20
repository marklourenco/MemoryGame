package com.example.memorygame

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

internal class RecyclerAdapter (val input: ArrayList<Card>,
                                val caller: GameFragmentListener) : RecyclerView.Adapter<RecyclerViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): RecyclerViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = RecyclerViewHolder(inflater, parent)

        return viewHolder
    }

    override fun getItemCount(): Int = input.size

    override fun onBindViewHolder(
        holder: RecyclerViewHolder,
        position: Int)
    {
        val card = input[position]

        val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        card.layoutParams = params
        params.setMargins(5, 5, 5, 5)
        card.gravity = Gravity.CENTER
        card.textSize = 24f

        holder.cardParent.addView(card)

        holder.cardParent.setOnClickListener {
            caller.cardTapped(card)
        }
    }
}

internal class RecyclerViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder (inflater.inflate(R.layout.card_layout, parent, false))
{
    val cardParent = itemView.findViewById<SquareFrameLayout>(R.id.cardParent_id)
}