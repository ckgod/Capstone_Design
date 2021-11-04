package com.ckg.appletree.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.ckg.appletree.databinding.ItemRecentBinding
import com.ckg.appletree.fragment.zItem.RecentItem

class RecentAdapter(private val activity : Activity, private val context : Context, private val items : MutableList<RecentItem>) : RecyclerView.Adapter<RecentAdapter.RecentVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentVH {
        val itemBinding = ItemRecentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentVH(itemBinding)
    }

    override fun onBindViewHolder(holder: RecentVH, position: Int) {
        val item: RecentItem = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class RecentVH(var binding: ItemRecentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecentItem) {
            Glide.with(context).load(item.image)
                .apply(RequestOptions().transform(CenterCrop()))
                .into(binding.ivImage)
        }
    }

    companion object {
        const val TAG = "RecentAdapter"
    }
}