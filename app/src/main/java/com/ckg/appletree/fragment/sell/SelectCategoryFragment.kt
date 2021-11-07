package com.ckg.appletree.fragment.sell

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentSelectCategoryBinding
import com.ckg.appletree.databinding.FragmentTmpBinding
import com.ckg.appletree.fragment.zAdapter.SelectCategoryAdapter
import com.ckg.appletree.fragment.zItem.SelectCategoryItem

class SelectCategoryFragment() : BaseKotlinFragment<FragmentSelectCategoryBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_select_category

    lateinit var itemList : MutableList<SelectCategoryItem>

    override fun initStartView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        setItemList()
        binding.rv.layoutManager = GridLayoutManager(requireContext(),3)
        binding.rv.adapter = SelectCategoryAdapter(requireActivity(),requireContext(),itemList)
    }

    fun setItemList() {
        itemList = mutableListOf(SelectCategoryItem(R.drawable.ic_mac_black,getString(R.string.Mac),1),
            SelectCategoryItem(R.drawable.ic_mac_black,getString(R.string.Mac),1),
            SelectCategoryItem(R.drawable.ic_mac_black,getString(R.string.Mac),1),
            SelectCategoryItem(R.drawable.ic_mac_black,getString(R.string.Mac),1),
            SelectCategoryItem(R.drawable.ic_mac_black,getString(R.string.Mac),1),
            SelectCategoryItem(R.drawable.ic_mac_black,getString(R.string.Mac),1))
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