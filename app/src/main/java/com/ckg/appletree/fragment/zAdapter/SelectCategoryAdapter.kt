package com.ckg.appletree.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ckg.appletree.R
import com.ckg.appletree.databinding.ItemCategoryBinding
import com.ckg.appletree.databinding.ItemSelectCategoryBinding
import com.ckg.appletree.fragment.home.HomeMainFragmentDirections
import com.ckg.appletree.fragment.zItem.CategoryItem
import com.ckg.appletree.fragment.zItem.SelectCategoryItem

class SelectCategoryAdapter(private val activity : Activity, private val context : Context, private val items : MutableList<SelectCategoryItem>) : RecyclerView.Adapter<SelectCategoryAdapter.SelectCategoryVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectCategoryVH {
        val itemBinding = ItemSelectCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectCategoryVH(itemBinding)
    }

    override fun onBindViewHolder(holder: SelectCategoryVH, position: Int) {
        val item: SelectCategoryItem = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class SelectCategoryVH(var binding: ItemSelectCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SelectCategoryItem) {

        }
    }

    companion object {
        const val TAG = "SelectCategoryAdapter"
    }

}