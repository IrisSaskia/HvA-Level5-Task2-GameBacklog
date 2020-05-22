package com.example.gamebacklogkotlin.ui.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamebacklogkotlin.R
import com.example.gamebacklogkotlin.model.Game
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import org.threeten.bp.LocalDate

const val EXTRA_GAME = "EXTRA_GAME"

@Suppress("DEPRECATION")
class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        /*supportActionBar?.setDisplayHomeAsUpEnabled(true)*/
        fab.setOnClickListener { _ ->
            onSaveClick()
        }
    }


    private fun onSaveClick() {
        if (etTitle.text.toString().isNotBlank()) {
            val game = Game(etTitle.text.toString(), etPlatform.text.toString(), LocalDate.of(etYear.text.toString().toInt(), etMonth.text.toString().toInt(), etDay.text.toString().toInt()))
            //val releaseDate = etYear.text.toString() + "-" + etMonth.text.toString() + "-" + etDay.text.toString()
            //val game = Game(etTitle.text.toString(), etPlatform.text.toString(), releaseDate)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_GAME, game)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The game cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }
}