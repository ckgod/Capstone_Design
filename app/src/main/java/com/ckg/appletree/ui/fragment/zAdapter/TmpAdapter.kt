package com.ckg.appletree.ui.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ckg.appletree.databinding.ItemCategoryBinding
import com.ckg.appletree.ui.fragment.zItem.CategoryItem

class TmpAdapter(private val activity : Activity, private val context : Context, private val items : MutableList<CategoryItem>) : RecyclerView.Adapter<TmpAdapter.TmpVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TmpVH {
        val itemBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TmpVH(itemBinding)
    }

    override fun onBindViewHolder(holder: TmpVH, position: Int) {
        val item: CategoryItem = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class TmpVH(var binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem) {

        }
    }

    companion object {
        const val TAG = "TmpAdapter"
    }

}