package com.ckg.appletree.fragment

import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentHomeMainBinding
import com.ckg.appletree.databinding.FragmentMainBinding

class HomeMainFragment() : BaseKotlinFragment<FragmentHomeMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_home_main

    override fun initStartView() {
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "HomeMainFragment"
    }

}