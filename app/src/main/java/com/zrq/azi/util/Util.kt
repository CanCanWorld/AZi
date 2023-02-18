package com.zrq.azi.util

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.util.Log
import com.tencent.mmkv.MMKV
import okhttp3.*
import java.io.IOException


object Util {

    const val TAG = "Util"

    fun formatDuration(duration: Long): String {
        if (duration.toInt() == 0) return "00:00"
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

    private val mmkv = MMKV.defaultMMKV()

    private val list = mutableListOf<Cookie>()

    private val okHttpClient = OkHttpClient.Builder()
        .cookieJar(object : CookieJar {
            override fun loadForRequest(url: HttpUrl): List<Cookie> {
                return list
            }

            override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                Log.d(TAG, "saveFromResponse: $cookies")
                list.clear()
                list.addAll(cookies)
            }
        })
        .build()

    fun httpGet(url: String, callBack: (Boolean, String) -> Unit) {
        Thread {
            val request: Request = Request.Builder()
                .url(url)
                .get()
                .build()
            Log.d(TAG, "httpGet: $url")
            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Handler(Looper.getMainLooper()).post {
                        callBack(false, "error1")
                    }
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.body != null) {
                        val json = response.body!!.string()
                        val headers = response.networkResponse!!.request.headers
                        try {
                            Handler(Looper.getMainLooper()).post {
                                callBack(true, json)
                            }
                        } catch (e: Exception) {
                            Log.e(TAG, "httpGet: $e")
                            Handler(Looper.getMainLooper()).post {
                                callBack(false, "error3:$e")
                            }
                        }
                    } else {
                        Log.e(TAG, "httpGet: error2")
                        Handler(Looper.getMainLooper()).post {
                            callBack(false, "error2")
                        }
                    }
                }
            })
        }.start()
    }
}