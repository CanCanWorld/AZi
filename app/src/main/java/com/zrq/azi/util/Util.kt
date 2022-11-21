package com.zrq.azi.util

import android.app.Activity
import android.util.DisplayMetrics
import android.util.Log
import okhttp3.*
import java.io.IOException


object Util {

    const val TAG = "Util"

    fun formatDuration(duration: Int): String {
        if (duration == 0) return "00:00"
        val m = duration / (60 * 1000)
        val s = (duration - 60 * 1000 * m) / 1000
        return String.format("%02d", m) + ":" + String.format("%02d", s)
    }

    fun getWindowWidth(context: Activity): Int {
        val display = context.windowManager.defaultDisplay
        val dm = DisplayMetrics()
        display.getRealMetrics(dm)
        return dm.widthPixels
    }

    fun getWindowHeight(context: Activity): Int {
        val display = context.windowManager.defaultDisplay
        val dm = DisplayMetrics()
        display.getRealMetrics(dm)
        return dm.heightPixels
    }

    fun httpGet(url: String, callBack: (Boolean, String) -> Unit) {
        Thread {
            val request: Request = Request.Builder().url(url).get().build()
            Log.d(TAG, "httpGet: $url")
            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    callBack(false, "error1")
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.body != null) {
                        val json = response.body!!.string()
                        try {
                            callBack(true, json)
                        } catch (e: Exception) {
                            callBack(false, "error3:$e")
                        }
                    } else {
                        callBack(false, "error2")
                    }
                }
            })
        }.start()
    }
}