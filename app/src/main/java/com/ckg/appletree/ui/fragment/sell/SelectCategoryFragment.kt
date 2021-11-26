package com.ckg.appletree.ui.fragment.sell

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentSelectCategoryBinding
import com.ckg.appletree.ui.fragment.zAdapter.SelectCategoryAdapter
import com.ckg.appletree.ui.fragment.zAdapter.SelectCategoryListener
import com.ckg.appletree.ui.fragment.zItem.SelectCategoryItem

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
        binding.rv.adapter = SelectCategoryAdapter(requireActivity(),requireContext(),itemList).apply {
            setAdapterListener(object : SelectCategoryListener {
                override fun clickCategory(itemType: String) {
                    findNavController().previousBackStackEntry?.savedStateHandle?.set("categoryResult", itemType)
                    findNavController().popBackStack()
                }
            })
        }
    }

    fun setItemList() {
        itemList = mutableListOf(SelectCategoryItem(R.drawable.ic_mac_black,getString(R.string.Mac),1),
            SelectCategoryItem(R.drawable.ic_imac_black,getString(R.string.iMac),2),
            SelectCategoryItem(R.drawable.ic_iphone_black,getString(R.string.iPhone),3),
            SelectCategoryItem(R.drawable.ic_watch_black,getString(R.string.Watch),4),
            SelectCategoryItem(R.drawable.ic_ipad_black,getString(R.string.iPad),5),
            SelectCategoryItem(R.drawable.ic_etc_black,getString(R.string.Etc),6))
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