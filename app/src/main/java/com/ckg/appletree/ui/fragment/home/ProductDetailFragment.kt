package com.ckg.appletree.ui.fragment.home

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.ckg.appletree.R
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentProductDetailBinding

class ProductDetailFragment() : BaseKotlinFragment<FragmentProductDetailBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_product_detail

    override val showBottomSheetFlag: Boolean
        get() = false

    private val viewModel by lazy { ProductViewModel() }
    private val safeArgs : ProductDetailFragmentArgs by navArgs()

    override fun initStartView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        viewModel.getProductDetail(safeArgs.itemId)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {
        viewModel.productDetailResponse.observe(this@ProductDetailFragment, Observer {
            if(it == null) {
                showNetworkError()
            }
            else {
                Log.d(TAG, it.toString())
                if(it.code == 200) {
                    binding.tvCategory.text = it.data.categoryName
                    binding.tvTitle.text = it.data.title
                    binding.tvContent.text = it.data.content
                    binding.tvFixPrice.text = it.data.limitPrice.toString()
                    binding.tvSellPrice.text = it.data.sellPrice.toString()
                    Glide.with(requireContext()).load(it.data.imageUrls[0])
                        .apply(RequestOptions().transform(CenterCrop()))
                        .transition(DrawableTransitionOptions.withCrossFade(200))
                        .into(binding.ivImage)
                }
            }
        })
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "ProductDetailFragment"
    }
}