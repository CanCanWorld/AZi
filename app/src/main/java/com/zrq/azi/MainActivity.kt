package com.zrq.azi

import android.Manifest
import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.zrq.azi.adapter.ViewpagerAdapter
import com.zrq.azi.bean.Dj
import com.zrq.azi.dao.SongDaoImpl
import com.zrq.azi.databinding.ActivityMainBinding
import com.zrq.azi.db.SongDatabaseHelper
import com.zrq.azi.service.PlayerService
import com.zrq.azi.interfaces.IPlayerControl
import com.zrq.azi.interfaces.IPlayerViewControl
import com.zrq.azi.ui.HomeFragment
import com.zrq.azi.view.VisualizeView

class MainActivity : AppCompatActivity(), IPlayerViewControl {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        requestPermissions()
        mainModel = ViewModelProvider(this).get(MainModel::class.java)
        initService()
        initData()
        initEvent()
    }

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mainModel: MainModel
    private lateinit var songDaoImpl: SongDaoImpl
    private lateinit var mVpAdapter: ViewpagerAdapter
    private val list = ArrayList<Dj.ProgramsBean>()

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

    private fun initData() {
        //数据库
        songDaoImpl = SongDaoImpl(SongDatabaseHelper(this))
        mainModel.songDaoImpl = songDaoImpl

        mVpAdapter = ViewpagerAdapter(this, list)
        mBinding.apply {
            viewPager.adapter = mVpAdapter
            visualizeView.setMode(VisualizeView.SINGLE)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initEvent() {
        mBinding.apply {
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.d(HomeFragment.TAG, "onPageSelected: $position")
                    mainModel.playerControl?.let {
                        it.setList(list)
                        it.play(position)
                    }
                }
            })
        }

        mainModel.apply {
            position.observe(this@MainActivity) {
                mBinding.viewPager.setCurrentItem(it, false)
            }
//            homeList.observe(this@MainActivity) {
//                list.clear()
//                list.addAll(it)
//                mVpAdapter.notifyDataSetChanged()
//            }
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
    }

    override fun onSeekChange(progress: Int, elapsedTime: Int) {
    }

    override fun onSongPlayOver(position: Int) {
        mBinding.viewPager.setCurrentItem(position, true)
    }

    override fun onVisualizeView(mode: FloatArray) {
        mBinding.visualizeView.setData(mode)
    }

}
