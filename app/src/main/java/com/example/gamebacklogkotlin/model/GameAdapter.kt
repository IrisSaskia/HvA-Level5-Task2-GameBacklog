package com.example.gamebacklogkotlin.model

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklogkotlin.R
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat
import android.content.Context

class GameAdapter(private val games: List<Game>, private val context: Context) :
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
            //itemView.tvDate.text = Resources.getSystem().getString(R.string.release_date, game.gameReleaseDate)
            //itemView.tvDate.text = game.gameReleaseDate.toString()
            itemView.tvDate.text = context.getString(R.string.release_date, game.gameReleaseDate.day.toString(), game.gameReleaseDate.month.toString(), game.gameReleaseDate.year.toString())
            /*val gameDate = game.gameReleaseDate.toString()
            val parser = SimpleDateFormat("E MMM dd hh:mm:ss ZZZZ yyyy")
            val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")
            val output: String = formatter.format(parser.parse(gameDate))
            itemView.tvDate.text = output*/
        }
    }
}