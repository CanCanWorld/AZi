package com.zrq.azi.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

object ToastUtil {
    private val handler: Handler = Handler(Looper.getMainLooper())

    fun showToast(context: Context, msg: String) {
        handler.post {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}