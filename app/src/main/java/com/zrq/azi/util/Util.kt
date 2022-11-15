package com.zrq.azi.util

object Util {
    fun formatDuration(duration: Int): String {
        if (duration == 0) return "00:00"
        val m = duration / (60 * 1000)
        val s = (duration - 60 * 1000 * m) / 1000
        return String.format("%02d", m) + ":" + String.format("%02d", s)
    }
}