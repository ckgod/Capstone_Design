package com.ckg.appletree.ui.fragment.profile

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.databinding.FragmentSellingListBinding
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentTmpBinding
import com.ckg.appletree.ui.fragment.home.ProductListFragment
import com.ckg.appletree.ui.fragment.home.ProductListFragmentDirections
import com.ckg.appletree.ui.fragment.zAdapter.ProductAdapter
import com.ckg.appletree.ui.fragment.zAdapter.ProductAdapterListener

class SellingListFragment() : BaseKotlinFragment<FragmentSellingListBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_selling_list

    private val viewModel by lazy { ProfileViewModel() }

    override fun initStartView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        showProgress()
        viewModel.getProductList(5)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {
        viewModel.productListResponse.observe(this@SellingListFragment, Observer {
            if(it == null) {
                showNetworkError()
            }
            else {
                Log.d(ProductListFragment.TAG, it.toString())
                if(it.code == 200) {
                    binding.rvProduct.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.VERTICAL,false)
                    binding.rvProduct.adapter = ProductAdapter(requireActivity(),requireContext(),it.list).apply {
                        setListener(object : ProductAdapterListener {
                            override fun clickItem(itemId : Int) {
                                findNavController().navigate(SellingListFragmentDirections.actionSellingListFragmentToProductDetailFragment(itemId))
                            }
                        })
                    }
                }
            }
            hideProgress()
        })
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "SellingListFragment"
    }
}