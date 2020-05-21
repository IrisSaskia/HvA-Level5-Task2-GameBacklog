package com.example.gamebacklogkotlin.model

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklogkotlin.R
import kotlinx.android.synthetic.main.item_game.view.*

class GameAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    /**
     * Creates and returns a ViewHolder object, inflating the layout called item_game.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }
    /* Returns the size of the list*/

    override fun getItemCount(): Int {
        return games.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

    @SuppressLint("StringFormatInvalid")
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){

        fun bind(game: Game){
            itemView.tvName.text = game.gameTitle
            itemView.tvPlatform.text = game.gamePlatform
            itemView.tvDate.text = Resources.getSystem().getString(R.string.release_date, game.gameReleaseDate.toString())
        }
    }
}