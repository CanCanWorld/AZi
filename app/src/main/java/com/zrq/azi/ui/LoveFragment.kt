package com.zrq.azi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.zrq.azi.R
import com.zrq.azi.databinding.FragmentLoveBinding

class LoveFragment : BaseFragment<FragmentLoveBinding>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoveBinding {
        return FragmentLoveBinding.inflate(LayoutInflater.from(requireContext()), container, false)
    }

    override fun initData() {
    }

    override fun initEvent() {
        mBinding.apply {
            fab.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.action_global_homeFragment)
            }
        }
    }

    companion object{
        const val TAG = "LoveFragment"
    }
}
