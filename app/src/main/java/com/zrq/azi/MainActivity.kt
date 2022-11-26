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
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tencent.mmkv.MMKV
import com.zrq.azi.adapter.ViewpagerAdapter
import com.zrq.azi.bean.Song
import com.zrq.azi.dao.ListDaoImpl
import com.zrq.azi.databinding.ActivityMainBinding
import com.zrq.azi.databinding.DialogBottomBinding
import com.zrq.azi.databinding.DialogTipBinding
import com.zrq.azi.db.SongDatabaseHelper
import com.zrq.azi.service.PlayerService
import com.zrq.azi.interfaces.IPlayerControl
import com.zrq.azi.interfaces.IPlayerViewControl
import com.zrq.azi.util.Constants
import com.zrq.azi.util.Constants.MMKV_SHOW_TIP
import com.zrq.azi.util.Constants.TYPE_BAR
import com.zrq.azi.util.Constants.TYPE_MORE
import com.zrq.azi.util.Util
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
    private val mPlayList = ArrayList<Song>()
    private val mShowList = ArrayList<Song>()


    private var dialogTip: AlertDialog? = null
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

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initEvent() {
        //提示框
        if (MMKV.defaultMMKV().decodeBool(MMKV_SHOW_TIP, true))
            showTipDialog()

        mBinding.apply {
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
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
                var song: Song? = null
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
                            Toast.makeText(this@MainActivity, "指针越界", Toast.LENGTH_SHORT).show()
                            Toast.makeText(this@MainActivity, "指针越界", Toast.LENGTH_SHORT).show()
                            Toast.makeText(this@MainActivity, "指针越界", Toast.LENGTH_SHORT).show()
                        } else
                            song = mPlayList[pos]
                    }
                }
                song?.let {
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
                            bottomDialog.cancel()
                        }
                        btnLove.setOnClickListener { _ ->
                            val url = "${Constants.BASE_URL}${Constants.LIKE}?id=${song.id}"
                            Util.httpGet(url) { _, msg ->
                                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                            }
                            bottomDialog.cancel()
                        }
                        btnComment.setOnClickListener { _ ->
                            mainModel.commentId = song.id
                            Navigation.findNavController(this@MainActivity, R.id.fragment_container)
                                .navigate(R.id.commentFragment)
                            bottomDialog.cancel()
                        }
                    }
                }
                bottomDialog.show()
            }

            hideBottomSheetDialog = {
                bottomDialog.hide()
            }
        }

        dialogTipBinding.apply {

            dialogTipBinding.btnEnsure.setOnClickListener {
                if (cbNeverTip.isChecked)
                    MMKV.defaultMMKV().putBoolean("show_tip", false)
                dialogTip?.dismiss()
            }
            dialogTipBinding.tvApi.movementMethod = LinkMovementMethod.getInstance()
            dialogTipBinding.tvProject.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    private fun showTipDialog() {
        if (dialogTip == null) {
            dialogTip = AlertDialog.Builder(this, R.style.NormalDialogStyle)
                .setView(dialogTipBinding.root)
                .setCancelable(true)
                .create()
        }
        dialogTip?.show()
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
