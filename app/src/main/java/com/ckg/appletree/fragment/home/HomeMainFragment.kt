package com.ckg.appletree.fragment.home

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.activity.MainActivity
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentHomeMainBinding
import com.ckg.appletree.databinding.FragmentMainBinding
import com.ckg.appletree.fragment.zAdapter.CategoryAdapter
import com.ckg.appletree.fragment.zItem.CategoryItem

class HomeMainFragment() : BaseKotlinFragment<FragmentHomeMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_home_main

    lateinit var categoryList: MutableList<CategoryItem>

    override fun initStartView() {
//        (requireActivity() as? MainActivity)?.setupBottomNavigationBar()
        setCategoryItem()
        binding.rvCategory.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvCategory.adapter =
            CategoryAdapter(requireActivity(), requireContext(), categoryList)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {

    }

    private fun setCategoryItem() {
        categoryList = mutableListOf(
            CategoryItem(R.drawable.ic_mac_black, getString(R.string.Mac)),
            CategoryItem(R.drawable.ic_imac_black, getString(R.string.iMac)),
            CategoryItem(R.drawable.ic_iphone_black, getString(R.string.iPhone)),
            CategoryItem(R.drawable.ic_watch_black, getString(R.string.Watch)),
            CategoryItem(R.drawable.ic_ipad_black, getString(R.string.iPad)),
            CategoryItem(R.drawable.ic_etc_black, getString(R.string.Etc))
        )
    }

    companion object {
        const val TAG = "HomeMainFragment"
    }

}