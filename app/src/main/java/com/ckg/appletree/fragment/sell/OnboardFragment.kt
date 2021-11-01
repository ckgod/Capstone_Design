package com.ckg.appletree.fragment.sell

import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentOnboardingBinding
import com.ckg.appletree.databinding.FragmentTmpBinding

class OnboardFragment() : BaseKotlinFragment<FragmentOnboardingBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_onboarding

    override fun initStartView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
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