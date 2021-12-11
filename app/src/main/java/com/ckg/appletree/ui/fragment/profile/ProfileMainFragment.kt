package com.ckg.appletree.ui.fragment.profile

import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentProfileMainBinding

class ProfileMainFragment() : BaseKotlinFragment<FragmentProfileMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_profile_main

    override fun initStartView() {
        binding.tvTab3.setOnClickListener{
            findNavController().navigate(ProfileMainFragmentDirections.actionProfileMainToSuccessBidFragment())
        }
        binding.tvTab2.setOnClickListener {
            findNavController().navigate(ProfileMainFragmentDirections.actionProfileMainToSellingListFragment())
        }
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "ProfileMainFragment"
    }

}