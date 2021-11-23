package com.ckg.appletree.fragment.chat

import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentChatRoomBinding

class ChatRoomFragment() : BaseKotlinFragment<FragmentChatRoomBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_chat_room

    private val viewModel by lazy { ChatViewModel() }

    override fun initStartView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        viewModel.runStomp()
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "ChatRoomFragment"
    }
}