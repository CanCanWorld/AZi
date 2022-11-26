package com.zrq.azi.service

import android.media.MediaPlayer
import android.media.audiofx.Visualizer
import android.os.Binder
import android.util.Log
import com.google.gson.Gson
import com.zrq.azi.bean.Song
import com.zrq.azi.bean.SongUrl
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.SONG_URL
import com.zrq.azi.interfaces.IPlayerControl
import com.zrq.azi.interfaces.IPlayerViewControl
import com.zrq.azi.util.Util.httpGet
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.hypot

object PlayerHelper : Binder(), IPlayerControl {

    private var mViewControl: IPlayerViewControl? = null

    private var mMediaPlayer: MediaPlayer = MediaPlayer()

    private var playList = ArrayList<Song>()

    private var pos = 0

    private const val TAG = "PlayerHelper"

    private var visualizer: Visualizer? = null

    private var mTimerTask: SeekTimeTask? = null

    private var timer: Timer? = null

    init {
        mMediaPlayer.setOnCompletionListener {
            Log.d(TAG, "${playList.size}: ")
            stopTimer()
            next()
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
                startTimer()
//                initVisualizer()
            }
            startTimer()
        }
    }

    override fun next() {
        when (playList.size) {
            0 -> {}
            1 -> {}
            else -> {
                if (pos == playList.size - 1) play(0) else play(pos + 1)
                mViewControl?.onSongPlayOver(pos)
            }
        }
    }

    override fun setList(songList: ArrayList<Song>) {
        playList.clear()
        playList.addAll(songList)
    }

    override fun seekTo(progress: Int) {
        if (mMediaPlayer.duration != 0) {
            val playerSeek = mMediaPlayer.duration * progress / 100
            mMediaPlayer.seekTo(playerSeek)
        }
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
        val id = playList[pos].id
        val url = "$BASE_URL$SONG_URL?id=$id"
        httpGet(url) { success, msg ->
            if (success) {
                val song = Gson().fromJson(msg, SongUrl::class.java)
                if (song?.data?.get(0)?.url != null) {
                    callback(song.data[0].url)
                } else {
                    next()
                }
            } else {
                next()
            }
        }
    }

    private fun startTimer() {
        if (timer == null) {
            Log.d(TAG, "startTimer: ")
            timer = Timer()
            if (mTimerTask == null) {
                mTimerTask = SeekTimeTask()
            }
            timer!!.schedule(mTimerTask, 0, 2 * 1000)
        }
    }

    private fun stopTimer() {
        timer?.cancel()
        timer = null
        mTimerTask?.cancel()
        mTimerTask = null
    }

    private class SeekTimeTask : TimerTask() {
        override fun run() {
            if (mMediaPlayer.currentPosition != 0) {
                val durationPosition = 100 * mMediaPlayer.currentPosition / mMediaPlayer.duration
                mViewControl?.onSeekChange(durationPosition, mMediaPlayer.currentPosition)
            }
        }

    }

}