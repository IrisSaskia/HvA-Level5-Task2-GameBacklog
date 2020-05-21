package com.example.gamebacklogkotlin.model

import androidx.lifecycle.LiveData
import androidx.room.*

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