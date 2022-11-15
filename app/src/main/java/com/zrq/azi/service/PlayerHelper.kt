package com.zrq.azi.service

import android.media.MediaPlayer
import android.media.audiofx.Visualizer
import android.os.Binder
import android.util.Log
import com.google.gson.Gson
import com.zrq.azi.bean.Dj
import com.zrq.azi.bean.SongUrl
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.SONG_URL
import com.zrq.azi.interfaces.IPlayerControl
import com.zrq.azi.interfaces.IPlayerViewControl
import okhttp3.*
import java.io.IOException
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.hypot

object PlayerHelper : Binder(), IPlayerControl {

    private var mViewControl: IPlayerViewControl? = null

    private var mMediaPlayer: MediaPlayer = MediaPlayer()

    private var playList = ArrayList<Dj.ProgramsBean>()

    private var pos = 0

    private const val TAG = "PlayerHelper"

    private var visualizer: Visualizer? = null

    init {
        mMediaPlayer.setOnCompletionListener {
            when (playList.size) {
                0 -> {
                }
                1 -> {}
                else -> {
                    if (pos == playList.size - 1) pos = 0 else pos++
                    mViewControl?.onSongPlayOver(pos)
                }
            }
            play(pos)
        }
        // 因为直接切歌会发生错误，所以增加错误监听器。返回true。就不会回调onCompletion方法了。
        mMediaPlayer.setOnErrorListener { _, _, _ -> true }

    }

    override fun registerViewControl(viewControl: IPlayerViewControl) {
        mViewControl = viewControl
    }

    override fun unRegisterViewControl() {
        mViewControl = null
    }

    override fun resetMediaPlayer() {
    }

    override fun play(position: Int) {
        if (pos == position) return
        pos = position
        loadSongUrl {
            Log.d(TAG, "play: $it")
            mMediaPlayer.reset()
            mMediaPlayer.setDataSource(it)
            mMediaPlayer.prepareAsync()
            mMediaPlayer.setOnPreparedListener {
                mMediaPlayer.start()
                initVisualizer()
            }
        }
    }

    override fun setList(list: ArrayList<Dj.ProgramsBean>) {
        playList.clear()
        playList.addAll(list)
    }

    override fun getList(): ArrayList<Dj.ProgramsBean> {
        return playList
    }

    private fun initVisualizer() {
        visualizer?.release()
        visualizer = Visualizer(mMediaPlayer.audioSessionId)
        visualizer!!.setDataCaptureListener(object : Visualizer.OnDataCaptureListener {
            override fun onWaveFormDataCapture(
                visualizer: Visualizer,
                bytes: ByteArray,
                samplingRate: Int
            ) {
            }

            override fun onFftDataCapture(
                visualizer: Visualizer,
                fft: ByteArray,
                samplingRate: Int
            ) {
                val model = FloatArray(fft.size / 2 + 1)
                model[0] = abs(fft[1].toFloat())
                var j = 1
                var i = 2
                while (i < fft.size / 2) {
                    model[j] = hypot(fft[i].toDouble(), fft[i + 1].toDouble()).toFloat()
                    i += 2
                    j++
                    model[j] = abs(fft[j].toFloat())
                }
                //model即为最终用于绘制的数据
                mViewControl?.onVisualizeView(model)
            }
        }, Visualizer.getMaxCaptureRate() / 2, false, true)

        visualizer!!.enabled = true

    }

    private fun loadSongUrl(callback: (String) -> Unit) {
        val id = playList[pos].mainSong.id
        val url = "$BASE_URL$SONG_URL?id=$id"
        Log.d(TAG, "loadSong: $url")
        val request: Request = Request.Builder()
            .url(url)
            .get()
            .build()
        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d(TAG, "onFailure: ")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.body != null) {
                    val json = response.body!!.string()
                    val song = Gson().fromJson(json, SongUrl::class.java)
                    if (song != null && song.data != null) {
                        callback.invoke(song.data[0].url)
                    }
                }
            }
        })
    }

}