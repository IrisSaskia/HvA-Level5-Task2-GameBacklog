package com.example.gamebacklogkotlin.database

import androidx.room.TypeConverter
import org.threeten.bp.LocalDate

class Converters {
    /*@TypeConverter
    *//*fun fromTimestamp(value: Int?): LocalDate? {
        return value?.let { LocalDate.of(it) }
    }*//*
	fun fromTimestamp(value: Long?): LocalDate? {
		return if (value == null) null else LocalDate.of(value)
	}

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }*/
	@TypeConverter
	fun fromTimestamp(dateString: String?): LocalDate? {
		return if(dateString == null) {
			null
		} else {
			LocalDate.parse(dateString)
		}
	}
	
	@TypeConverter
	fun dateToTimestamp(date: LocalDate?): String? {
		return if(date == null) {
			null
		} else {
			date.toString()
		}
	}
}