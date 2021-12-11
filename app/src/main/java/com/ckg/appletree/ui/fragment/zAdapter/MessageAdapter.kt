package com.ckg.appletree.ui.fragment.zAdapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ckg.appletree.databinding.ReceiveItemBinding
import com.ckg.appletree.databinding.SendItemBinding
import com.ckg.appletree.ui.fragment.zItem.TextMessage

class MessageAdapter(private val activity : Activity, private val context : Context, private val items : MutableList<TextMessage>) : RecyclerView.Adapter<MessageAdapter.MessageVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageVH {
        when(viewType) {
            SENDER -> {
                val itemBinding = SendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MessageVH(itemBinding)
            }
            RECEIVER -> {
                val itemBinding = ReceiveItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MessageVH(itemBinding)
            }
        }
        val itemBinding = ReceiveItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageVH(itemBinding)
    }

    override fun onBindViewHolder(holder: MessageVH, position: Int) {
        val item: TextMessage = items[position]
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        val item: TextMessage = items[position]
        return when(item.isReceived){
            true -> RECEIVER
            false -> SENDER
        }
    }

    override fun getItemCount(): Int = items.size

    inner class MessageVH : RecyclerView.ViewHolder {
        private var senderBinding : SendItemBinding? = null
        private var receiverBinding : ReceiveItemBinding? = null

        constructor(binding : SendItemBinding) : super(binding.root) {
            senderBinding = binding
        }
        constructor(binding: ReceiveItemBinding) : super(binding.root) {
            receiverBinding = binding
        }

        fun bind(item : TextMessage) {
//            val sdf = SimpleDateFormat("a h시 m분", Locale.KOREA)
            when(item.isReceived) {
                true -> { // 받은거
                    receiverBinding?.let { binding ->
                        binding.nameView.text = item.nickname // other
                        binding.contentView.text = item.content
                        binding.timeView.text = ""
                    }
                }
                false -> { // 보낸거
                    senderBinding?.let { binding ->
                        binding.nameView.text = "나" // me
                        binding.contentView.text = item.content
                        binding.timeView.text = ""
                    }
                }
            }
        }
    }

    companion object {
        const val TAG = "MessageAdapter"
        const val SENDER = 1
        const val RECEIVER = 2
    }

}