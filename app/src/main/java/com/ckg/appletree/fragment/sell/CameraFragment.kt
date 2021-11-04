package com.ckg.appletree.fragment.sell

import android.Manifest
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentCameraBinding
import com.ckg.appletree.databinding.FragmentTmpBinding
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission

class CameraFragment() : BaseKotlinFragment<FragmentCameraBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_camera

    override val showBottomSheetFlag: Boolean
        get() = false

    override fun initStartView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnConfirm.setOnClickListener {
            binding.cardExplain.visibility = View.GONE
        }
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
        TedPermission.with(requireContext())
            .setPermissionListener(object : PermissionListener {
                override fun onPermissionGranted() {
//                    startActivity(Intent(this@LaunchActivity, MainActivity::class.java))
//                    finish()
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    for(i in deniedPermissions!!)
                        Log.d(TAG, i)
                }

            })
            .setDeniedMessage("상품 사진을 찍으려면 권한을 허가하셔야합니다.")
            .setPermissions(Manifest.permission.CAMERA)
            .check()
    }

    companion object {
        const val TAG = "CameraFragment"
    }
}