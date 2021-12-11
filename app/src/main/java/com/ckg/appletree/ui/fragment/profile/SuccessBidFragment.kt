package com.ckg.appletree.ui.fragment.profile

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.databinding.FragmentSuccessBidBinding
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentTmpBinding
import com.ckg.appletree.ui.fragment.zAdapter.ChatRoomListAdapter

class SuccessBidFragment() : BaseKotlinFragment<FragmentSuccessBidBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_success_bid

    private val viewModel by lazy { ProfileViewModel() }

    override fun initStartView() {
        showProgress()
        viewModel.getRoomList()
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {
        viewModel.chatRoomListResponse.observe(this@SuccessBidFragment, Observer {
            if(it == null) {
                showNetworkError()
            }
            else {
                if(it.code == 200) {
                    binding.rvChat.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                    binding.rvChat.adapter = ChatRoomListAdapter(requireActivity(),requireContext(),it.list)
                }
            }
            hideProgress()
        })
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "SuccessBidFragment"
    }
}