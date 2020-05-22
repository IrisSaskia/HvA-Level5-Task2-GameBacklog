package com.example.gamebacklogkotlin.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDate

@Parcelize
@Entity(tableName = "gameTable")
data class Game (
    @ColumnInfo(name = "gameTitle")
    var gameTitle: String,
    
    @ColumnInfo(name = "gamePlatform")
    var gamePlatform: String,
    
    @ColumnInfo(name = "gameReleaseDate")
    //var gameReleaseDate: String, //Date werkt niet goed doordat je 3 getallen als invoer krijgt
    var gameReleaseDate: LocalDate,
    
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) : Parcelable