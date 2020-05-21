package com.example.gamebacklogkotlin.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gamebacklogkotlin.model.Game

@Dao
interface GameDAO {
    @Query("SELECT * FROM gameTable")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)
}