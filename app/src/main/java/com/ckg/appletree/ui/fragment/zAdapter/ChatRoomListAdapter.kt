package com.ckg.appletree.ui.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ckg.appletree.R
import com.ckg.appletree.api.model.ChatRoomListResponse
import com.ckg.appletree.databinding.ItemCategoryBinding
import com.ckg.appletree.databinding.ItemChatRoomBinding
import com.ckg.appletree.ui.fragment.home.HomeMainFragmentDirections
import com.ckg.appletree.ui.fragment.profile.SuccessBidFragmentDirections
import com.ckg.appletree.ui.fragment.zItem.CategoryItem

class ChatRoomListAdapter(private val activity : Activity, private val context : Context, private val items : MutableList<ChatRoomListResponse.Data>) : RecyclerView.Adapter<ChatRoomListAdapter.ChatRoomListVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRoomListVH {
        val itemBinding = ItemChatRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatRoomListVH(itemBinding)
    }

    override fun onBindViewHolder(holder: ChatRoomListVH, position: Int) {
        val item: ChatRoomListResponse.Data = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ChatRoomListVH(var binding: ItemChatRoomBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChatRoomListResponse.Data) {
            binding.tvNickname.text = item.nickname
            binding.tvProductTitle.text = item.title
            itemView.setOnClickListener {
                activity.findNavController(R.id.nav_host_fragment_container_in_main_activity).
                navigate(SuccessBidFragmentDirections.actionSuccessBidFragmentToChatRoomFragment(item.title, item.sellerNickname, item.nickname, item.price))
            }
        }
    }

    companion object {
        const val TAG = "ChatRoomListAdapter"
    }

}