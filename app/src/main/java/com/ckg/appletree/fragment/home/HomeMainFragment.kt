package com.ckg.appletree.fragment.home

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.activity.MainActivity
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentHomeMainBinding
import com.ckg.appletree.databinding.FragmentMainBinding
import com.ckg.appletree.fragment.zAdapter.CategoryAdapter
import com.ckg.appletree.fragment.zAdapter.RecentAdapter
import com.ckg.appletree.fragment.zAdapter.RecentAdapterListener
import com.ckg.appletree.fragment.zItem.CategoryItem
import com.ckg.appletree.fragment.zItem.RecentItem

class HomeMainFragment() : BaseKotlinFragment<FragmentHomeMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_home_main

    lateinit var categoryList: MutableList<CategoryItem>
    lateinit var recentList: MutableList<RecentItem>

    override fun initStartView() {
        setCategoryItem()
        setRecentItem()
        binding.rvCategory.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvCategory.adapter =
            CategoryAdapter(requireActivity(), requireContext(), categoryList)
        binding.rvRecent.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvRecent.adapter =
            RecentAdapter(requireActivity(), requireContext(), recentList).apply {
                setListener(object : RecentAdapterListener{
                    override fun clickItem() {
                        findNavController().navigate(HomeMainFragmentDirections.actionHomeMainToProductDetailFragment(1))
                    }
                })
            }
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {

    }

    private fun setCategoryItem() {
        categoryList = mutableListOf(
            CategoryItem(R.drawable.ic_mac_black, getString(R.string.Mac),3),
            CategoryItem(R.drawable.ic_imac_black, getString(R.string.iMac),2),
            CategoryItem(R.drawable.ic_iphone_black, getString(R.string.iPhone),1),
            CategoryItem(R.drawable.ic_watch_black, getString(R.string.Watch),4),
            CategoryItem(R.drawable.ic_ipad_black, getString(R.string.iPad),5),
            CategoryItem(R.drawable.ic_etc_black, getString(R.string.Etc),6)
        )
    }
    private fun setRecentItem() {
        recentList = mutableListOf(
            RecentItem(1, R.drawable.dummy_7),
            RecentItem(1, R.drawable.dummy_3),
            RecentItem(1, R.drawable.dummy_2),
            RecentItem(1, R.drawable.dummy_4),
            RecentItem(1, R.drawable.dummy_6),
            RecentItem(1, R.drawable.dummy_5),
            RecentItem(1, R.drawable.dummy_1)
        )
    }

    companion object {
        const val TAG = "HomeMainFragment"
    }

}