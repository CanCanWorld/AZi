package com.zrq.azi.ui

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.zrq.azi.R
import com.zrq.azi.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater, container, false)
    }

    override fun initData() {
        /**
         * 手机登录
         * 邮箱登录
         * 游客登录
         */

    }

    override fun initEvent() {
        mBinding.apply {

            tvVisitorLogin.setOnClickListener {
            }

            tvEmailLogin.setOnClickListener {
            }

            btnLogin.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.homeFragment)
            }

        }
    }

}