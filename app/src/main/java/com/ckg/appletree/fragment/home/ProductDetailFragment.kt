package com.ckg.appletree.fragment.home

import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentProductDetailBinding
import com.ckg.appletree.databinding.FragmentTmpBinding

class ProductDetailFragment() : BaseKotlinFragment<FragmentProductDetailBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_product_detail

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
        const val TAG = "ProductDetailFragment"
    }
}