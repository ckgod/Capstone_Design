package com.ckg.appletree.ui.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ckg.appletree.R
import com.ckg.appletree.databinding.ItemCategoryBinding
import com.ckg.appletree.ui.fragment.home.HomeMainFragmentDirections
import com.ckg.appletree.ui.fragment.zItem.CategoryItem

class CategoryAdapter(private val activity : Activity, private val context : Context, private val items : MutableList<CategoryItem>) : RecyclerView.Adapter<CategoryAdapter.CategoryVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val itemBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryVH(itemBinding)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        val item: CategoryItem = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class CategoryVH(var binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem) {
            binding.tvTitle.text = item.name
            binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(context, item.icon))
            itemView.setOnClickListener {
                activity.findNavController(R.id.nav_host_fragment_container_in_main_activity).
                navigate(HomeMainFragmentDirections.actionHomeMainToProductListFragment(item.name, item.type))
            }
        }
    }

    companion object {
        const val TAG = "CategoryAdapter"
        const val MAC = 1
        const val IMAC = 2
        const val IPHONE = 3
        const val WATCH = 4
        const val IPAD = 5
        const val ETC = 6
    }

}