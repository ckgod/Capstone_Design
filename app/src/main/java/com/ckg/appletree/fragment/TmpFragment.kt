package com.ckg.appletree.fragment

import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentTmpBinding

class TmpFragment() : BaseKotlinFragment<FragmentTmpBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_tmp

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "TmpFragment"
    }
}