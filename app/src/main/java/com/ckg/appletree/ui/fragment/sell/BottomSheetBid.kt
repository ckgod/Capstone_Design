package com.ckg.appletree.ui.fragment.sell

import com.ckg.appletree.R
import com.ckg.appletree.databinding.BottomSheetBidBinding
import com.ckg.appletree.ui.base.BaseBottomSheetFragment

interface BottomSheetBidListener{
    fun clickComplete()
}

class BottomSheetBid : BaseBottomSheetFragment<BottomSheetBidBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.bottom_sheet_bid

    lateinit var listener: BottomSheetBidListener

    fun setBottomSheetBidListener(bottomSheetBidListener: BottomSheetBidListener) {
        this.listener = bottomSheetBidListener
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setWindowAnimations(-1)
    }

    override fun initStartView() {
        binding.btnComplete.setOnClickListener {
            listener.clickComplete()
        }
        binding.btnDelete.setOnClickListener {
            dismiss()
        }
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {

    }

    companion object{
        const val TAG = "BottomSheetBid"
    }

}