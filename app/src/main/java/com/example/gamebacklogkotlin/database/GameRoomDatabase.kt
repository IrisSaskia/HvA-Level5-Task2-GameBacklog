package com.example.gamebacklogkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gamebacklogkotlin.model.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameRoomDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDAO

    companion object {
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var gameRoomDatabaseInstance: GameRoomDatabase? = null

        fun getDatabase(context: Context): GameRoomDatabase? {
            if(gameRoomDatabaseInstance == null) {
                synchronized(GameRoomDatabase::class.java) {
                    if(gameRoomDatabaseInstance == null) {
                        gameRoomDatabaseInstance = Room.databaseBuilder(context.applicationContext, GameRoomDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }
            return gameRoomDatabaseInstance
        }
    }
}