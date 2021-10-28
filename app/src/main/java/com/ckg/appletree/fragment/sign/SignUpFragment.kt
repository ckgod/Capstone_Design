package com.ckg.appletree.fragment.sign

import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentSignUpBinding

class SignUpFragment() : BaseKotlinFragment<FragmentSignUpBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_sign_up

    override val showBottomSheetFlag: Boolean
        get() = false

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
        const val TAG = "SignUpFragment"
    }
}