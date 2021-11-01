package com.ckg.appletree.fragment.home

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentProductListBinding
import com.ckg.appletree.databinding.FragmentTmpBinding

class ProductListFragment() : BaseKotlinFragment<FragmentProductListBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_product_list

    private val safeArgs : ProductListFragmentArgs by navArgs()

    override fun initStartView() {
        binding.tvTitle.text = safeArgs.categoryName
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
        const val TAG = "ProductListFragment"
    }
}