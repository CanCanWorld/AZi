package com.zrq.azi.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import com.zrq.azi.bean.Dj
import com.zrq.azi.db.SongDatabaseHelper
import com.zrq.azi.util.Constants.FIELD_COVER
import com.zrq.azi.util.Constants.FIELD_CREATE_TIME
import com.zrq.azi.util.Constants.FIELD_DURATION
import com.zrq.azi.util.Constants.FIELD_ID
import com.zrq.azi.util.Constants.FIELD_LISTENER_COUNT
import com.zrq.azi.util.Constants.FIELD_SONG_ID
import com.zrq.azi.util.Constants.FIELD_SONG_NAME
import com.zrq.azi.util.Constants.TABLE_NAME

class SongDaoImpl(
    private var mHelper: SongDatabaseHelper
) : ISongDao {
    override fun addSong(song: Dj.ProgramsBean): Long {
        val db = mHelper.writableDatabase
        val values = songToValues(song)
        val result = db.insert(TABLE_NAME, null, values)
        db.close()
        return result
    }

    override fun deleteSong(id: Int): Int {
        val db = mHelper.writableDatabase
        val result = db.delete(TABLE_NAME, "$FIELD_ID=$id", null)
        db.close()
        return result
    }

    override fun listAllSongs(): ArrayList<Dj.ProgramsBean> {
        val db = mHelper.writableDatabase
        val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        val pics = ArrayList<Dj.ProgramsBean>()
        while (cursor.moveToNext()) {
            pics.add(cursorToSong(cursor))
        }
        return pics
    }

    private fun songToValues(song: Dj.ProgramsBean): ContentValues {
        val values = ContentValues()
        values.put(FIELD_SONG_NAME, song.name)
        values.put(FIELD_COVER, song.coverUrl)
        values.put(FIELD_SONG_ID, song.id)
        values.put(FIELD_LISTENER_COUNT, song.listenerCount)
        values.put(FIELD_DURATION, song.duration)
        values.put(FIELD_CREATE_TIME, song.createTime)
        return values
    }

    @SuppressLint("Range")
    private fun cursorToSong(cursor: Cursor): Dj.ProgramsBean {
        val song = Dj.ProgramsBean()
        song._id = cursor.getInt(cursor.getColumnIndex(FIELD_ID))
        song.name = cursor.getString(cursor.getColumnIndex(FIELD_SONG_NAME))
        song.coverUrl = cursor.getString(cursor.getColumnIndex(FIELD_COVER))
        song.id = cursor.getLong(cursor.getColumnIndex(FIELD_SONG_ID))
        song.listenerCount = cursor.getInt(cursor.getColumnIndex(FIELD_LISTENER_COUNT))
        song.duration = cursor.getString(cursor.getColumnIndex(FIELD_DURATION)).toInt()
        song.createTime = cursor.getString(cursor.getColumnIndex(FIELD_CREATE_TIME)).toLong()
        return song
    }
}