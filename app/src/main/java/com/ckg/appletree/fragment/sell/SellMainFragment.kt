package com.ckg.appletree.fragment.sell

import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentSellMainBinding

class SellMainFragment() : BaseKotlinFragment<FragmentSellMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_sell_main

    override fun initStartView() {
        binding.ctlCategoryContainer.setOnClickListener {
            findNavController().navigate(SellMainFragmentDirections.actionSellMainToSelectCategoryFragment())
        }
        binding.ctlCameraContainer.setOnClickListener {
            findNavController().navigate(SellMainFragmentDirections.actionSellMainToOnboardFragment())
        }
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "SellMainFragment"
    }

}