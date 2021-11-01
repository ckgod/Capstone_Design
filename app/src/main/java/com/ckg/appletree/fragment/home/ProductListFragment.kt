package com.ckg.appletree.fragment.home

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentProductListBinding
import com.ckg.appletree.databinding.FragmentTmpBinding
import com.ckg.appletree.fragment.zAdapter.ProductAdapter
import com.ckg.appletree.fragment.zItem.ProductItem

class ProductListFragment() : BaseKotlinFragment<FragmentProductListBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_product_list

    private val safeArgs : ProductListFragmentArgs by navArgs()
    lateinit var productList : MutableList<ProductItem>

    override fun initStartView() {
        binding.tvTitle.text = safeArgs.categoryName
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        productList = mutableListOf(ProductItem(1,R.drawable.dummy_1,"dumm","dadf","adfa"),
            ProductItem(2,R.drawable.dummy_1,"dumm","dadf","adfa"),
            ProductItem(3,R.drawable.dummy_1,"dumm","dadf","adfa"),
            ProductItem(4,R.drawable.dummy_1,"dumm","dadf","adfa"),
            ProductItem(4,R.drawable.dummy_1,"dumm","dadf","adfa"),
            ProductItem(4,R.drawable.dummy_1,"dumm","dadf","adfa"),
            ProductItem(4,R.drawable.dummy_1,"dumm","dadf","adfa"))
        binding.rvProduct.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.rvProduct.adapter = ProductAdapter(requireActivity(),requireContext(),productList)
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