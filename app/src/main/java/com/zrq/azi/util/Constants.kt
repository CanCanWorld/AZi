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

    const val DAILY_SONGS = "/recommend/songs"

    const val DAILY_LIST = "/recommend/resource"

    const val LIKE = "/like"

    const val DJ_PROGRAM = "/dj/program"

    const val SONG_URL = "/song/url"

    // /comment/music?id=186016&limit=1
    const val COMMENT = "/comment/music"

    //  https://www.zhangruiqian.ga/playlist/tracks?op=add&pid=6884202385&tracks=1486506463
    const val ADD_DEL = "/playlist/tracks"


    //数据库
    const val DATABASE_NAME = "azi_player"

    const val FIELD_ID = "_id"

    const val DATABASE_VERSION = 3

    //歌单表
    const val LIST_TABLE = "list_table"

    const val LIST_NAME = "name"

    const val LIST_ID = "list_id"

    const val LIST_COUNT = "count"

    const val LIST_COVER = "cover"

    const val LIST_SONGS = "list_songs"

    //MMKV
    const val MMKV_UID = "uid"

    const val MMKV_AVATAR_URL = "avatar_url"

    const val MMKV_NICKNAME = "nickname"

    const val MMKV_SHOW_TIP = "show_tip"

    //进入歌单的类型
    const val TYPE_UNKNOWN = 0

    const val TYPE_USER_PLAY_LIST = 1

    const val TYPE_DAILY_SONGS = 2

    const val TYPE_DAILY_LIST = 3

    //点击显示详情的位置
    const val TYPE_MORE = 0

    const val TYPE_BAR = 1

}