package com.ckg.appletree.fragment.sell

import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentSelectCategoryBinding
import com.ckg.appletree.databinding.FragmentTmpBinding

class SelectCategoryFragment() : BaseKotlinFragment<FragmentSelectCategoryBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_select_category

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
        const val TAG = "SelectCategoryFragment"
    }
}