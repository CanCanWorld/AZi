package com.zrq.azi

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tencent.mmkv.MMKV
import com.zrq.azi.adapter.PlayListAdapter
import com.zrq.azi.adapter.ViewpagerAdapter
import com.zrq.azi.bean.Song
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.dao.ListDaoImpl
import com.zrq.azi.databinding.ActivityMainBinding
import com.zrq.azi.databinding.DialogBottomBinding
import com.zrq.azi.databinding.DialogSongListBinding
import com.zrq.azi.databinding.DialogTipBinding
import com.zrq.azi.db.SongDatabaseHelper
import com.zrq.azi.service.PlayerService
import com.zrq.azi.interfaces.IPlayerControl
import com.zrq.azi.interfaces.IPlayerViewControl
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.util.Constants.ADD_DEL
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.MMKV_SHOW_TIP
import com.zrq.azi.util.Constants.TYPE_BAR
import com.zrq.azi.util.Constants.TYPE_MORE
import com.zrq.azi.util.Util.httpGet
import com.zrq.azi.view.VisualizeView

class MainActivity : AppCompatActivity(), IPlayerViewControl {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        requestPermissions()
        mainModel = ViewModelProvider(this).get(MainModel::class.java)
        initService()
        MMKV.initialize(this)
        initData()
        initEvent()
    }

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mainModel: MainModel

    private lateinit var listDaoImpl: ListDaoImpl

    private lateinit var mVpAdapter: ViewpagerAdapter

    private lateinit var songListAdapter: PlayListAdapter
    private val mPlayList = ArrayList<Song>()
    private val mShowList = ArrayList<Song>()
    private val songList = ArrayList<UserPlayList.PlaylistDTO>()
    private var song: Song? = null


    private val dialogTip: AlertDialog by lazy {
        AlertDialog.Builder(this, R.style.NormalDialogStyle)
            .setView(dialogTipBinding.root)
            .setCancelable(true)
            .create()
    }
    private val dialogTipBinding by lazy {
        DialogTipBinding.inflate(LayoutInflater.from(this))
    }

    private val bottomDialog: BottomSheetDialog by lazy {
        BottomSheetDialog(this).apply {
            setContentView(bindingBottomDialog.root)
        }
    }

    private val bindingBottomDialog by lazy {
        DialogBottomBinding.inflate(LayoutInflater.from(this))
    }

    private val songListDialog: AlertDialog by lazy {
        AlertDialog.Builder(this, R.style.NormalDialogStyle)
            .setView(dialogSongListBinding.root)
            .setCancelable(true)
            .create()
    }

    private val dialogSongListBinding by lazy {
        DialogSongListBinding.inflate(LayoutInflater.from(this))
    }

    //服务
    private fun initService() {
        val intent = Intent(this, PlayerService::class.java)
        val connection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                val mPlayerControl: IPlayerControl = service as IPlayerControl
                mainModel.playerControl = mPlayerControl
                mainModel.playerControl?.registerViewControl(this@MainActivity)
            }

            override fun onServiceDisconnected(name: ComponentName?) {
            }
        }
        startService(intent)
        bindService(intent, connection, BIND_AUTO_CREATE)
    }

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.P)
    private fun initData() {
        //数据库
        listDaoImpl = ListDaoImpl(SongDatabaseHelper(this))
        mainModel.listDaoImpl = listDaoImpl

        //mainModel
        mainModel.hidePlayBar = {
            mBinding.llPlayerBar.visibility = View.GONE
            mBinding.visualizeView.visibility = View.GONE
        }
        mainModel.showPlayBar = {
            mBinding.llPlayerBar.visibility = View.VISIBLE
            mBinding.visualizeView.visibility = View.VISIBLE
        }

        mVpAdapter = ViewpagerAdapter(this, mPlayList)
        mBinding.apply {
            viewPager.adapter = mVpAdapter
            visualizeView.setMode(VisualizeView.SINGLE)
        }
        mainModel.setScreen = {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            val lp: WindowManager.LayoutParams = window.attributes
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            window.attributes = lp
        }

        initDialog()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initDialog() {

        songListAdapter = PlayListAdapter(this, songList, object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Log.d(TAG, "onItemClick: ${songList.size}")
                val url = "$BASE_URL$ADD_DEL?op=add&pid=${songList[position].id}&tracks=${song?.id}"
                httpGet(url) { success, msg ->
                    if (success && msg.contains("\"status\":200")) {
                        Toast.makeText(this@MainActivity, "收藏成功", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        dialogSongListBinding.apply {
            recyclerView.adapter = songListAdapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        if (mainModel.listDaoImpl != null) {
            if (mainModel.listDaoImpl!!.listAllList().size != 0) {
                songList.clear()
                songList.addAll(mainModel.listDaoImpl!!.listAllList())
                songListAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "获取歌单失败，尝试主界面刷新", Toast.LENGTH_SHORT).show()
            }
        }

        //提示框dialog
        dialogTipBinding.apply {
            dialogTipBinding.btnEnsure.setOnClickListener {
                if (cbNeverTip.isChecked)
                    MMKV.defaultMMKV().putBoolean("show_tip", false)
                dialogTip.dismiss()
            }
            dialogTipBinding.tvApi.movementMethod = LinkMovementMethod.getInstance()
            dialogTipBinding.tvProject.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initEvent() {
        //提示框
        if (MMKV.defaultMMKV().decodeBool(MMKV_SHOW_TIP, true))
            dialogTip.show()

        mBinding.apply {
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    mainModel.position.postValue(position)
                    Log.d(TAG, "onPageSelected: $position")
                    mainModel.playerControl?.let {
                        it.setList(mPlayList)
                        it.play(position)
                    }
                }
            })

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (fromUser) {
                        mainModel.playerControl?.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }

            })
        }

        mainModel.apply {
            position.observe(this@MainActivity) {
                mBinding.viewPager.setCurrentItem(it, false)
            }

            playList.observe(this@MainActivity) {
                mPlayList.clear()
                mPlayList.addAll(it)
                mVpAdapter.notifyDataSetChanged()
            }

            showList.observe(this@MainActivity) {
                mShowList.clear()
                mShowList.addAll(it)
            }

            showBottomSheetDialog = { pos, type ->
                when (type) {
                    TYPE_MORE -> {
                        if (pos > mShowList.size) {
                            Toast.makeText(this@MainActivity, "指针越界", Toast.LENGTH_SHORT).show()
                        } else
                            song = mShowList[pos]
                    }
                    TYPE_BAR -> {
                        if (pos > mPlayList.size) {
                            Toast.makeText(this@MainActivity, "指针越界", Toast.LENGTH_SHORT).show()
                        } else
                            song = mPlayList[pos]
                    }
                }
                song?.let { song ->
                    bindingBottomDialog.apply {
                        tvSongName.text = song.name
                        tvSinger.text = song.singer
                        Glide.with(this@MainActivity)
                            .load(song.coverUrl)
                            .into(ivCover)
                        Glide.with(this@MainActivity)
                            .load(song.coverUrl)
                            .into(ivBackground)
                        btnDownload.setOnClickListener {
                            Toast.makeText(this@MainActivity, "没做", Toast.LENGTH_SHORT).show()
                        }
                        btnLove.setOnClickListener { _ ->
                            songListDialog.show()
                        }
                        btnComment.setOnClickListener { _ ->
                            mainModel.commentId = song.id
                            Navigation.findNavController(this@MainActivity, R.id.fragment_container)
                                .navigate(R.id.commentFragment)
                            bottomDialog.cancel()
                        }
                        btnSinger.setOnClickListener {
                            Toast.makeText(this@MainActivity, "没做", Toast.LENGTH_SHORT).show()
                        }
                        btnAlbum.setOnClickListener {
                            Toast.makeText(this@MainActivity, "没做", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                bottomDialog.show()
            }

            hideBottomSheetDialog = {
                bottomDialog.hide()
            }
        }

    }

    //权限
    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, 1)
    }

    companion object {
        val PERMISSIONS = arrayOf(
            Manifest.permission.RECORD_AUDIO,
        )
        const val TAG = "MainActivity"
    }

    override fun onSeekChange(progress: Int, elapsedTime: Int) {
        Log.d(TAG, "onSeekChange: $progress")
        mBinding.seekBar.progress = progress
    }

    override fun onSongPlayOver(position: Int) {
        mBinding.viewPager.setCurrentItem(position, true)
    }

    override fun onVisualizeView(mode: FloatArray) {
        mBinding.visualizeView.setData(mode)
    }

}
