package com.example.gamebacklogkotlin.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.gamebacklogkotlin.database.GameRepository
import com.example.gamebacklogkotlin.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameRepository = GameRepository(application.applicationContext)

    val games: LiveData<List<Game>> = gameRepository.getAllGames()

    fun insertGame(game: Game) {
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }

    fun deleteGame(game: Game) {
        ioScope.launch {
            gameRepository.deleteGame(game)
        }
    }
}