package com.zrq.azi.util

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.util.Log
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

    fun httpGet(url: String, callBack: (Boolean, String) -> Unit) {
        Thread {
            val request: Request = Request.Builder()
                .url(url)
//                .addHeader("cookie", "9d89ce1eae3d3e2b19be57c8952325a0=2c2031bf-1ea9-4e13-95b2-92484a027d34.7Gy7ZchFj-UO2zUyp9t7c02AHJY; order=id%20desc; serverType=nginx; pro_end=-1; ltd_end=-1; memSize=1998; bt_user_info=%7B%22status%22%3Atrue%2C%22msg%22%3A%22%u83B7%u53D6%u6210%u529F%21%22%2C%22data%22%3A%7B%22username%22%3A%22150****2797%22%7D%7D; SetName=; ChangePath=10; sites_path=/www/wwwroot; site_model=php; rank=list; Path=/www/wwwroot; file_recycle_status=true; record_paste_type=1; 2960fc2d6b4dcc284ebdc9f9c7152a8e=fe986542-e123-4711-8f28-b9831ed1368f.m8tBDL5hClgqdn1saSugCHrIR28; request_token=7WZXvunZ1PPL1g32EV0FmSgjvpxwmcm1ILzewTIFJGQN9h0m; backup_path=/www/backup; config-tab=0; network-unitType=KB/s; disk-unitType=KB/s; loginState=false; NMTID=00OSmkDYf3dRDa4iEuilZaxB7ffow0AAAGCixxa6Q")
                .addHeader(
                    "cookie",
                    "MUSIC_A=bf8bfeabb1aa84f9c8c3906c04a04fb864322804c83f5d607e91a04eae463c9436bd1a17ec353cf7abe86796ee19e8e021ef129a6ad49923993166e004087dd3b4a7fc451f81ca2c4a03ac1cb2aec3f88ce49cedb1822b0d8e7edc519470401b807e650dd04abd3fb8130b7ae43fcc5b; MUSIC_U=dc1adab9b4eaf6281ae1039a4ef07a7641c1e9914c490cd84e8ee9563126a161993166e004087dd318198b99dca1982f1f950c0509fa3f9b82d04195b7e46dd3b785c2e21c4614017a561ba977ae766d; NMTID=00OshUW1kiMlk9IdUtbobD_mArrtccAAAGEnSS1FA; __csrf=23e76ef8d5ce9bf233e3efa51b67a039; __remember_me=true"
                )
                .get()
                .build()
            Log.d(TAG, "httpGet: $url")
            OkHttpClient().newCall(request).enqueue(object : Callback {
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