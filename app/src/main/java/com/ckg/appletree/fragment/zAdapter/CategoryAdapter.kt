package com.ckg.appletree.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ckg.appletree.databinding.ItemCategoryBinding
import com.ckg.appletree.fragment.zItem.CategoryItem

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
        }
    }

    companion object {
        const val TAG = "CategoryAdapter"
    }

}