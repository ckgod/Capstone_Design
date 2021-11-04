package com.ckg.appletree.fragment.sell

import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentCameraBinding
import com.ckg.appletree.databinding.FragmentTmpBinding

class CameraFragment() : BaseKotlinFragment<FragmentCameraBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_camera

    override val showBottomSheetFlag: Boolean
        get() = false

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "CameraFragment"
    }
}