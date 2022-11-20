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
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.tencent.mmkv.MMKV
import com.zrq.azi.adapter.ViewpagerAdapter
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.dao.ListDaoImpl
import com.zrq.azi.databinding.ActivityMainBinding
import com.zrq.azi.databinding.DialogTipBinding
import com.zrq.azi.db.SongDatabaseHelper
import com.zrq.azi.service.PlayerService
import com.zrq.azi.interfaces.IPlayerControl
import com.zrq.azi.interfaces.IPlayerViewControl
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
    private val list = ArrayList<SongOfList.SongsDTO>()
    private var dialogTip: AlertDialog? = null
    private val dialogTipBinding by lazy {
        DialogTipBinding.inflate(LayoutInflater.from(this))
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

        mVpAdapter = ViewpagerAdapter(this, list)
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
        if (MMKV.defaultMMKV().decodeBool("show_tip", true))
            showTipDialog()

        mBinding.apply {
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.d(TAG, "onPageSelected: $position")
                    mainModel.playerControl?.let {
                        it.setList(list)
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
                list.clear()
                list.addAll(it)
                mVpAdapter.notifyDataSetChanged()
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
