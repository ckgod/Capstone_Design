package com.ckg.appletree.ui.fragment.home

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentProductListBinding
import com.ckg.appletree.ui.fragment.zAdapter.ProductAdapter
import com.ckg.appletree.ui.fragment.zAdapter.ProductAdapterListener

class ProductListFragment() : BaseKotlinFragment<FragmentProductListBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_product_list

    private val viewModel by lazy { ProductViewModel() }
    private val safeArgs : ProductListFragmentArgs by navArgs()

    override fun initStartView() {
        showProgress()
        viewModel.getProductList(safeArgs.categoryId)
        binding.tvTitle.text = safeArgs.categoryName
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {
        viewModel.productListResponse.observe(this@ProductListFragment, Observer {
            if(it == null) {
                showNetworkError()
            }
            else {
                Log.d(TAG, it.toString())
                if(it.code == 200) {
                    binding.rvProduct.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                    binding.rvProduct.adapter = ProductAdapter(requireActivity(),requireContext(),it.list).apply {
                        setListener(object : ProductAdapterListener{
                            override fun clickItem(itemId : Int) {
                                findNavController().navigate(ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(itemId))
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

    private fun setDummy() {
//        productList = mutableListOf(ProductItem(1,R.drawable.dummy_1,"알짜배기 아이맥 얼마 안남았다.","1,200,000","1,490,000"),
//            ProductItem(2,R.drawable.dummy_2,"아이맥2011 27인치 i7","500,000","510,000"),
//            ProductItem(3,R.drawable.dummy_3,"아이맥27inch 2014 고사양 팝니다.","1,200,000","1,300,000"),
//            ProductItem(4,R.drawable.dummy_4,"아이맥 21.5 2011년형 램 16기가 제품 25만원 판매합니다","240,000","250,000"),
//            ProductItem(4,R.drawable.dummy_5,"(끌올,가격인하) 아이맥 2013 late 27인치","450,000","500,000"),
//            ProductItem(4,R.drawable.dummy_6,"2020 아이맥27 / i9 10코어 / 5700XT / 1TB / 10 Gigabit Ethernet","4,000,000","4,100,000"),
//            ProductItem(4,R.drawable.dummy_7,"아이맥 27인치 5K Late 2015 중급형 팝니다","950,000","970,000"))
    }

    companion object {
        const val TAG = "ProductListFragment"
    }
}