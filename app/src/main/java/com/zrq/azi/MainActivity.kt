package com.zrq.azi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zrq.azi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initData()
        initEvent()
    }

    private lateinit var mBinding: ActivityMainBinding

    private fun initData() {

    }

    private fun initEvent() {

    }

}