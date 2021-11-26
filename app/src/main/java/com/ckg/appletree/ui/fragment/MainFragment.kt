package com.ckg.appletree.ui.fragment

import com.ckg.appletree.R
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentMainBinding

class MainFragment() : BaseKotlinFragment<FragmentMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_main

    override fun initStartView() {
        binding.btn.setOnClickListener {
            showProgress()
        }
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "MainFragment"
    }

}