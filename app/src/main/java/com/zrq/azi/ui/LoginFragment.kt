package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.gson.Gson
import com.zrq.azi.R
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.databinding.FragmentLoginBinding
import com.zrq.azi.util.Constants
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.LOGIN_NUMBER_PASSWORD
import okhttp3.*
import java.io.IOException

/**
 * 游客登录
 * 手机登录
 * 邮箱登录
 */
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater, container, false)
    }

    private var loginType: Int = LOGIN_VISITOR

    override fun initData() {
    }

    override fun initEvent() {
        mBinding.apply {

            tvLeft.setOnClickListener {
                loginType = when (loginType) {
                    LOGIN_EMAIL -> {
                        //跳转手机登录
                        tvLeft.visibility = View.VISIBLE
                        tvRight.visibility = View.VISIBLE
                        etNumber.visibility = View.VISIBLE
                        llPassword.visibility = View.VISIBLE
                        tvLeft.text = "游客登录"
                        tvRight.text = "邮箱登录"
                        etNumber.hint = "手机号"
                        etPassword.hint = "验证码"
                        tvCardTitle.text = "手机登录"
                        btnGetVerification.visibility = View.VISIBLE
                        LOGIN_NUMBER
                    }
                    else -> {
                        //跳转游客登录
                        tvLeft.visibility = View.GONE
                        tvRight.visibility = View.VISIBLE
                        etNumber.visibility = View.GONE
                        llPassword.visibility = View.GONE
                        tvRight.text = "手机登录"
                        tvCardTitle.text = "游客登录"
                        LOGIN_VISITOR
                    }
                }
            }

            tvRight.setOnClickListener {
                loginType = when (loginType) {
                    LOGIN_VISITOR -> {
                        //跳转手机登录
                        tvLeft.visibility = View.VISIBLE
                        tvRight.visibility = View.VISIBLE
                        etNumber.visibility = View.VISIBLE
                        llPassword.visibility = View.VISIBLE
                        tvLeft.text = "游客登录"
                        tvRight.text = "邮箱登录"
                        etNumber.hint = "手机号"
                        etPassword.hint = "验证码"
                        tvCardTitle.text = "手机登录"
                        btnGetVerification.visibility = View.VISIBLE
                        LOGIN_NUMBER
                    }
                    else -> {
                        //跳转邮箱登录
                        tvLeft.visibility = View.VISIBLE
                        tvRight.visibility = View.GONE
                        etNumber.visibility = View.VISIBLE
                        llPassword.visibility = View.VISIBLE
                        etNumber.hint = "邮箱"
                        etPassword.hint = "密码"
                        tvLeft.text = "手机登录"
                        tvCardTitle.text = "邮箱登录"
                        btnGetVerification.visibility = View.GONE
                        LOGIN_EMAIL
                    }
                }
            }

            btnLogin.setOnClickListener {
                when (loginType) {
                    LOGIN_VISITOR -> {
                        Navigation.findNavController(requireActivity(), R.id.fragment_container)
                            .navigate(R.id.homeFragment)
                    }
                    LOGIN_NUMBER -> {
                        loginNumberPassword()
                    }
                    LOGIN_EMAIL -> {

                    }
                    else -> {}
                }
            }

        }
    }

    private fun loginNumberPassword() {
        Thread {
            Log.d(HomeFragment.TAG, "loadUserPlayList: ")
            val url = "$BASE_URL$LOGIN_NUMBER_PASSWORD?phone=17860487013&password=zhang123..."
            val request: Request = Request.Builder()
                .url(url)
                .get()
                .build()
            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call, response: Response) {
                    if (response.body != null) {
                        val json = response.body!!.string()
                        Log.d(TAG, "onResponse: $json")
                    } else {
                    }
                }
            })
        }.start()
    }

    override fun onResume() {
        super.onResume()
        mainModel.hidePlayBar()
    }

    companion object {
        const val TAG = "LoginFragment"

        const val LOGIN_VISITOR = 0
        const val LOGIN_NUMBER = 1
        const val LOGIN_EMAIL = 2
    }

}