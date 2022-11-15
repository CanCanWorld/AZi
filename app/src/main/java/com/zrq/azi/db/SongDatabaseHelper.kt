package com.zrq.azi.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.zrq.azi.util.Constants.DATABASE_NAME
import com.zrq.azi.util.Constants.DATABASE_VERSION
import com.zrq.azi.util.Constants.FIELD_COVER
import com.zrq.azi.util.Constants.FIELD_DURATION
import com.zrq.azi.util.Constants.FIELD_ID
import com.zrq.azi.util.Constants.FIELD_LISTENER_COUNT
import com.zrq.azi.util.Constants.FIELD_SONG_ID
import com.zrq.azi.util.Constants.FIELD_SONG_NAME
import com.zrq.azi.util.Constants.FIELD_CREATE_TIME
import com.zrq.azi.util.Constants.TABLE_NAME

class SongDatabaseHelper(var context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table $TABLE_NAME($FIELD_ID integer primary key autoincrement," +
                "$FIELD_SONG_NAME varchar(50)," +
                "$FIELD_COVER varchar(400)," +
                "$FIELD_SONG_ID varchar(50)," +
                "$FIELD_LISTENER_COUNT integer," +
                "$FIELD_DURATION varchar(50)," +
                "$FIELD_CREATE_TIME varchar(50))"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}