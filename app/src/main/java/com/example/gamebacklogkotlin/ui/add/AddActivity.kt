package com.example.gamebacklogkotlin.ui.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gamebacklogkotlin.R
import com.example.gamebacklogkotlin.model.Game

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.time.LocalDate
import java.util.*

//const val EXTRA_GAME = "EXTRA_GAME"

@Suppress("DEPRECATION")
class AddActivity : AppCompatActivity() {
    private lateinit var addViewModel: AddViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        fab.setOnClickListener { view ->
            onSaveClick()
        }
    }
    private fun initViewModel() {
        addViewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        addViewModel.game.value = intent.extras?.getParcelable(EXTRA_GAME)!!

        /*addViewModel.game.observe(this, Observer { game ->
            if (game != null) {
                etTitle.setText(game.gametitle)
                etNote.setText(game.text)
            }
        })

        addViewModel.error.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        addViewModel.success.observe(this, Observer { success ->
            if (success) finish()
        })*/
    }


    private fun onSaveClick() {
        if (etTitle.text.toString().isNotBlank()) {
            val game = Game(etTitle.text.toString(), etPlatform.text.toString(), Date(etDay.text.toString().toInt(), etMonth.text.toString().toInt(), etYear.text.toString().toInt()))
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_GAME, game)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The game cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val EXTRA_GAME = "EXTRA_GAME"
    }
}