package com.zrq.azi.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.gson.JsonObject
import com.tencent.mmkv.MMKV
import com.zrq.azi.R
import com.zrq.azi.databinding.FragmentLoginBinding
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.LOGIN_NUMBER
import com.zrq.azi.util.Constants.SENT_CAPTCHA
import com.zrq.azi.util.Util.httpGet
import org.json.JSONObject

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater, container, false)
    }

    private var loginType: Int = TYPE_VISITOR

    override fun initData() {
    }

    override fun initEvent() {
        mBinding.apply {

            tvLeft.setOnClickListener {
                loginType = when (loginType) {
                    TYPE_EMAIL -> {
                        //跳转手机登录
                        tvLeft.visibility = View.VISIBLE
                        tvRight.visibility = View.VISIBLE
                        textInputNumber.visibility = View.VISIBLE
                        llPassword.visibility = View.VISIBLE
                        tvLeft.text = "游客登录"
                        tvRight.text = "邮箱登录"
                        textInputNumber.hint = "手机号"
                        textInputPassword.hint = "验证码"
                        tvCardTitle.text = "手机登录"
                        btnGetVerification.visibility = View.VISIBLE
                        TYPE_NUMBER
                    }
                    else -> {
                        //跳转游客登录
                        tvLeft.visibility = View.GONE
                        tvRight.visibility = View.VISIBLE
                        textInputNumber.visibility = View.GONE
                        llPassword.visibility = View.GONE
                        tvRight.text = "手机登录"
                        tvCardTitle.text = "游客登录"
                        TYPE_VISITOR
                    }
                }
            }

            tvRight.setOnClickListener {
                loginType = when (loginType) {
                    TYPE_VISITOR -> {
                        //跳转手机登录
                        tvLeft.visibility = View.VISIBLE
                        tvRight.visibility = View.VISIBLE
                        textInputNumber.visibility = View.VISIBLE
                        llPassword.visibility = View.VISIBLE
                        tvLeft.text = "游客登录"
                        tvRight.text = "密码登录"
                        textInputNumber.hint = "手机号"
                        textInputPassword.hint = "验证码"
                        tvCardTitle.text = "手机登录"
                        btnGetVerification.visibility = View.VISIBLE
                        TYPE_NUMBER
                    }
                    else -> {
                        //跳转邮箱登录
                        tvLeft.visibility = View.VISIBLE
                        tvRight.visibility = View.GONE
                        textInputNumber.visibility = View.VISIBLE
                        llPassword.visibility = View.VISIBLE
                        textInputNumber.hint = "手机号"
                        textInputPassword.hint = "密码"
                        tvLeft.text = "手机登录"
                        tvCardTitle.text = "密码登录"
                        btnGetVerification.visibility = View.GONE
                        TYPE_EMAIL
                    }
                }
            }

            btnLogin.setOnClickListener {
                when (loginType) {
                    TYPE_VISITOR -> {
                        Navigation.findNavController(requireActivity(), R.id.fragment_container)
                            .navigate(R.id.homeFragment)
                    }
                    TYPE_NUMBER -> {
                        val number = etNumber.text.toString()
                        val captcha = etPassword.text.toString()
                        if (number == "") {
                            Toast.makeText(requireContext(), "请输入手机号", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                        if (captcha == "") {
                            Toast.makeText(requireContext(), "请输入验证码", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                        loginWithCaptcha(number, captcha)
                    }
                    TYPE_EMAIL -> {
                        val number = etNumber.text.toString()
                        val password = etPassword.text.toString()
                        if (number == "") {
                            Toast.makeText(requireContext(), "请输入手机号", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                        if (password == "") {
                            Toast.makeText(requireContext(), "请输入密码", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                        loginWithPassword(number, password)
                    }
                    else -> {}
                }
            }

            btnGetVerification.setOnClickListener {
                val number = etNumber.text.toString()
                if (number == "") {
                    Toast.makeText(requireContext(), "请输入手机号", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                getVerification(number)
            }
        }
    }

    private fun getVerification(number: String) {
        val url = "$BASE_URL$SENT_CAPTCHA?phone=$number"
        httpGet(url) { success, msg ->
            if (success) {
                Log.d(TAG, "getVerification: $msg")
            } else {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                Log.e(TAG, "getVerification: $msg")
            }
        }
    }

    private fun loginWithCaptcha(number: String, captcha: String) {
        val url = "$BASE_URL$LOGIN_NUMBER?phone=$number&captcha=$captcha"
        httpGet(url) { success, msg ->
            if (success) {
                Log.d(TAG, "loginWithCaptcha: $msg")
                JSONObject(msg).let {
                    if (it["code"] == 200) {
                        val uid = JSONObject(it["id"].toString()).get("id").toString()
                        Log.d(TAG, "getVerification: $uid")
                        MMKV.defaultMMKV().putString("uid", uid)
                    }
                }
            } else {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                Log.e(TAG, "loginWithCaptcha: $msg")
            }
        }
    }

    private fun loginWithPassword(number: String, password: String) {
        val url = "$BASE_URL$LOGIN_NUMBER?phone=$number&password=$password"
        httpGet(url) { success, msg ->
            if (success) {
                Log.d(TAG, "loginWithPassword: $msg")
            } else {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                Log.e(TAG, "loginWithPassword: $msg")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mainModel.hidePlayBar()
    }

    companion object {
        const val TAG = "LoginFragment"

        const val TYPE_VISITOR = 0
        const val TYPE_NUMBER = 1
        const val TYPE_EMAIL = 2
    }

}