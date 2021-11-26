package com.ckg.appletree.ui.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ckg.appletree.databinding.ItemSelectCategoryBinding
import com.ckg.appletree.ui.fragment.zItem.SelectCategoryItem

interface SelectCategoryListener{
    fun clickCategory(itemType : String)
}

class SelectCategoryAdapter(private val activity : Activity, private val context : Context, private val items : MutableList<SelectCategoryItem>) : RecyclerView.Adapter<SelectCategoryAdapter.SelectCategoryVH>() {
    lateinit var listener : SelectCategoryListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectCategoryVH {
        val itemBinding = ItemSelectCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectCategoryVH(itemBinding)
    }

    override fun onBindViewHolder(holder: SelectCategoryVH, position: Int) {
        val item: SelectCategoryItem = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun setAdapterListener(selectCategoryListener: SelectCategoryListener) {
        this.listener = selectCategoryListener
    }

    inner class SelectCategoryVH(var binding: ItemSelectCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SelectCategoryItem) {
            binding.tvTitle.text = item.name
            binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(context, item.icon))
            itemView.setOnClickListener {
                listener.clickCategory(item.name)
            }
        }
    }

    companion object {
        const val TAG = "SelectCategoryAdapter"
    }

}