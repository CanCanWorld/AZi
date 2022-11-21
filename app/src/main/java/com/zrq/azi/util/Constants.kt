package com.zrq.azi.util

object Constants {

    const val BASE_URL = "https://www.zhangruiqian.ga"

    const val LOGIN_VISITOR = "/register/anonimous"

    // /login/cellphone?phone=xxx&password=yyy /login/cellphone?phone=xxx&md5_password=yyy /login/cellphone?phone=xxx&captcha=1234
    const val LOGIN_NUMBER = "/login/cellphone"

    // /captcha/sent?phone=13xxx
    const val SENT_CAPTCHA = "/captcha/sent"

    // /captcha/verify?phone=13xxx&captcha=1597
    const val VERIFY_CAPTCHA = "/captcha/verify"

    const val LOGOUT = "/logout"

    const val USER_PLAY_LIST = "/user/playlist"

    const val PLAY_LIST_ALL = "/playlist/track/all"

    const val DJ_PROGRAM = "/dj/program"

    const val SONG_URL = "/song/url"

    const val DATABASE_NAME = "azi_player"

    const val DATABASE_VERSION = 3

    const val FIELD_ID = "_id"

    //歌单表
    const val LIST_TABLE = "list_table"

    const val LIST_NAME = "name"

    const val LIST_ID = "list_id"

    const val LIST_COUNT = "count"

    const val LIST_COVER = "cover"

    const val LIST_SONGS = "list_songs"

}