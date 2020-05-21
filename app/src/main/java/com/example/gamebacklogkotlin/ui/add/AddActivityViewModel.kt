package com.example.gamebacklogkotlin.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.gamebacklogkotlin.database.GameRepository
import com.example.gamebacklogkotlin.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddViewModel(application: Application) : AndroidViewModel(application) {
    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val game = MutableLiveData<Game?>()
    val error = MutableLiveData<String?>()
    val success = MutableLiveData<Boolean>()

    fun updateGame() {
        if (isGameValid()) {
            mainScope.launch {
                withContext(Dispatchers.IO) {
                    gameRepository.updateGame(game.value!!)
                }
                success.value = true
            }
        }
    }

    private fun isGameValid(): Boolean {
        return when {
            game.value == null -> {
                error.value = "Game must not be null"
                false
            }
            game.value!!.gameTitle.isBlank() -> {
                error.value = "Title must not be empty"
                false
            }
            else -> true
        }
    }
}