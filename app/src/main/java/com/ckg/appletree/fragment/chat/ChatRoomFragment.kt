package com.ckg.appletree.fragment.chat

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentChatRoomBinding
import com.ckg.appletree.fragment.zAdapter.MessageAdapter
import com.ckg.appletree.fragment.zItem.TextMessage

class ChatRoomFragment() : BaseKotlinFragment<FragmentChatRoomBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_chat_room

    private val viewModel by lazy { ChatViewModel() }
    lateinit var messageList : MutableList<TextMessage>

    override fun initStartView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        setDummy()
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvChat.adapter = MessageAdapter(requireActivity(),requireContext(),messageList)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    fun setDummy() {
        messageList = mutableListOf(
            TextMessage("고창국","1","1","강정훈",12,"hihi",true,true),
            TextMessage("강정훈","1","1","고창국",12,"hihi",false,true),
            TextMessage("고창국","1","1","강정훈",12,"hihi",true,true),
            TextMessage("강정훈","1","1","고창국",12,"hihi",false,true),)
    }

    companion object {
        const val TAG = "ChatRoomFragment"
    }
}