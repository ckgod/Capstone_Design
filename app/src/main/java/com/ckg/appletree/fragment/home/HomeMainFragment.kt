package com.ckg.appletree.fragment.home

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentHomeMainBinding
import com.ckg.appletree.databinding.FragmentMainBinding
import com.ckg.appletree.fragment.zAdapter.CategoryAdapter
import com.ckg.appletree.fragment.zItem.CategoryItem

class HomeMainFragment() : BaseKotlinFragment<FragmentHomeMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_home_main

    lateinit var categoryList : MutableList<CategoryItem>

    override fun initStartView() {
        categoryList = mutableListOf()
        categoryList.add(CategoryItem(R.drawable.ic_mac,getString(R.string.Mac)))
        categoryList.add(CategoryItem(R.drawable.ic_mac,getString(R.string.iMac)))
        categoryList.add(CategoryItem(R.drawable.ic_mac,getString(R.string.iPhone)))
        categoryList.add(CategoryItem(R.drawable.ic_mac,getString(R.string.Watch)))
        categoryList.add(CategoryItem(R.drawable.ic_mac,getString(R.string.iPad)))
        categoryList.add(CategoryItem(R.drawable.ic_mac,getString(R.string.Etc)))
        binding.rvCategory.layoutManager = GridLayoutManager(requireContext(),3)
        binding.rvCategory.adapter = CategoryAdapter(requireActivity(),requireContext(),categoryList)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {

    }

    companion object {
        const val TAG = "HomeMainFragment"
    }

}