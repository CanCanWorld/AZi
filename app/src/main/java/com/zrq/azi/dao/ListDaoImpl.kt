package com.zrq.azi.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.util.Log
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.db.SongDatabaseHelper
import com.zrq.azi.util.Constants.FIELD_ID
import com.zrq.azi.util.Constants.LIST_COUNT
import com.zrq.azi.util.Constants.LIST_COVER
import com.zrq.azi.util.Constants.LIST_ID
import com.zrq.azi.util.Constants.LIST_NAME
import com.zrq.azi.util.Constants.LIST_SONGS
import com.zrq.azi.util.Constants.LIST_TABLE

class ListDaoImpl(
    private var mHelper: SongDatabaseHelper
) : IListDao {
    override fun listAllList(): ArrayList<UserPlayList.PlaylistDTO> {
        val db = mHelper.writableDatabase
        val cursor = db.query(LIST_TABLE, null, null, null, null, null, null)
        val lists = ArrayList<UserPlayList.PlaylistDTO>()
        while (cursor.moveToNext()) {
            lists.add(cursorToBean(cursor))
        }
        db.close()
        return lists
    }

    override fun updateAllList(newList: ArrayList<UserPlayList.PlaylistDTO>){
        val db = mHelper.writableDatabase
        db.execSQL("delete from $LIST_TABLE;")
        db.execSQL("update sqlite_sequence set seq ='0' where name ='$LIST_TABLE';")
        newList.forEach {
            Log.d(TAG, "updateAllList: $newList")
            db.insert(LIST_TABLE, null, beanToValues(it))
        }
        db.close()
    }

    override fun updateListSongs(newList: UserPlayList.PlaylistDTO) {
        val db = mHelper.writableDatabase
        val values = beanToValues(newList)
        Log.d("TAG", "updateListSongs: ${newList._id}")
        Log.d("TAG", "updateListSongs: ${newList.songGson}")
        db.update(LIST_TABLE, values, "$FIELD_ID=?", arrayOf(newList._id.toString()))
        db.close()
    }

    private fun beanToValues(list: UserPlayList.PlaylistDTO): ContentValues {
        val values = ContentValues()
        values.put(LIST_NAME, list.name)
        values.put(LIST_COVER, list.coverImgUrl)
        values.put(LIST_COUNT, list.trackCount)
        values.put(LIST_SONGS, list.songGson)
        values.put(LIST_ID, list.id)
        return values
    }

    @SuppressLint("Range")
    private fun cursorToBean(cursor: Cursor): UserPlayList.PlaylistDTO {
        val list = UserPlayList.PlaylistDTO()
        list._id = cursor.getInt(cursor.getColumnIndex(FIELD_ID))
        list.name = cursor.getString(cursor.getColumnIndex(LIST_NAME))
        list.coverImgUrl = cursor.getString(cursor.getColumnIndex(LIST_COVER))
        list.trackCount = cursor.getInt(cursor.getColumnIndex(LIST_COUNT))
        list.songGson = cursor.getString(cursor.getColumnIndex(LIST_SONGS))
        list.id = cursor.getLong(cursor.getColumnIndex(LIST_ID))
        return list
    }

    companion object{
        const val TAG = "ListDaoImpl"
    }
}