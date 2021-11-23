package com.ckg.appletree.fragment

import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentMainBinding
import com.ckg.appletree.databinding.FragmentProfileMainBinding

class ProfileMainFragment() : BaseKotlinFragment<FragmentProfileMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_profile_main

    override fun initStartView() {
        binding.tvTab1.setOnClickListener{
            findNavController().navigate(ProfileMainFragmentDirections.actionProfileMainToChatRoomFragment())
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