package com.ckg.appletree.fragment.sell

import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentOnboardingBinding
import com.ckg.appletree.databinding.FragmentTmpBinding

class OnboardFragment() : BaseKotlinFragment<FragmentOnboardingBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_onboarding

    override val showBottomSheetFlag: Boolean
        get() = false

    override fun initStartView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnOpenCamera.setOnClickListener {
            findNavController().navigate(OnboardFragmentDirections.actionOnboardFragmentToCameraFragment())
        }
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "OnboardFragment"
    }
}