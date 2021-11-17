package com.ckg.appletree.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ckg.appletree.R
import com.ckg.appletree.databinding.ItemCategoryBinding
import com.ckg.appletree.databinding.ItemProductBinding
import com.ckg.appletree.fragment.home.HomeMainFragmentDirections
import com.ckg.appletree.fragment.zItem.CategoryItem
import com.ckg.appletree.fragment.zItem.ProductItem
import com.ckg.appletree.utils.ViewUtils

interface ProductAdapterListener{
    fun clickItem()
}

class ProductAdapter(private val activity : Activity, private val context : Context, private val items : MutableList<ProductItem>) : RecyclerView.Adapter<ProductAdapter.ProductVH>() {
    lateinit var productAdapterListener: ProductAdapterListener

    fun setListener(productAdapterListener: ProductAdapterListener) {
        this.productAdapterListener = productAdapterListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val itemBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductVH(itemBinding)
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val item: ProductItem = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ProductVH(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductItem) {
            Glide.with(context).load(item.image)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(ViewUtils.convertDpToPixel(8f,context).toInt())))
                .into(binding.ivImage)
            binding.tvProductTitle.text = item.title
            binding.tvPrice.text = "${item.price}원"
            binding.tvFixLowerPrice.text = "고정하한가 ${item.fixLower}원"
            itemView.setOnClickListener {
                productAdapterListener.clickItem()
            }
        }
    }

    companion object {
        const val TAG = "ProductAdapter"
        const val MAC = 1
        const val IMAC = 2
        const val IPHONE = 3
        const val WATCH = 4
        const val IPAD = 5
        const val ETC = 6
    }

}