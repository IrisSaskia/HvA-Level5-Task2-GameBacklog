package com.example.gamebacklogkotlin.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.example.gamebacklogkotlin.R
import com.example.gamebacklogkotlin.model.Game
import com.example.gamebacklogkotlin.model.GameAdapter
import com.example.gamebacklogkotlin.ui.add.AddActivity
import com.example.gamebacklogkotlin.ui.add.AddActivity.Companion.EXTRA_GAME

import kotlinx.android.synthetic.main.activity_main.*

const val ADD_GAME_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        fab.setOnClickListener { view ->
            startAddActivity()
        }
    }

    private fun startAddActivity() {
//        val intent = Intent(this, AddActivity::class.java)
//        startActivityForResult(intent, ADD_GAME_REQUEST_CODE)
        val intent = Intent(this, AddActivity::class.java)
        intent.putExtra(AddActivity.EXTRA_GAME, arrayListOf(viewModel.games.value))
        startActivityForResult(intent, ADD_GAME_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ADD_GAME_REQUEST_CODE -> {
                    data?.let { safeData ->
                        val game = safeData.getParcelableExtra<Game>(EXTRA_GAME)
                        game?.let { safeGame ->
                            viewModel.insertGame(safeGame)
                        } ?: run {
                            Log.e(TAG, "reminder is null")
                        }
                    } ?: run {
                        Log.e(TAG, "null intent data received")
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}