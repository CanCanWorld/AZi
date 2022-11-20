package com.zrq.azi.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.zrq.azi.util.Constants.DATABASE_NAME
import com.zrq.azi.util.Constants.DATABASE_VERSION
import com.zrq.azi.util.Constants.FIELD_ID
import com.zrq.azi.util.Constants.LIST_COUNT
import com.zrq.azi.util.Constants.LIST_COVER
import com.zrq.azi.util.Constants.LIST_ID
import com.zrq.azi.util.Constants.LIST_NAME
import com.zrq.azi.util.Constants.LIST_SONGS
import com.zrq.azi.util.Constants.LIST_TABLE

class SongDatabaseHelper(var context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table $LIST_TABLE($FIELD_ID integer primary key autoincrement," +
                "$LIST_NAME varchar(100)," +
                "$LIST_COVER varchar(300)," +
                "$LIST_SONGS varchar(100000)," +
                "$LIST_COUNT integer," +
                "$LIST_ID integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}