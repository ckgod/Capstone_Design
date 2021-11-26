package com.ckg.appletree.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.ckg.appletree.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetFragment<T : ViewDataBinding> : BottomSheetDialogFragment() {
    lateinit var binding: T

    abstract val layoutResourceId: Int

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initAfterBinding()

    abstract fun reLoadUI()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        if (!(::binding.isInitialized)) {
            binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
            initStartView()
            initDataBinding()
            initAfterBinding()
        }
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)
        reLoadUI()
        return binding.root
    }
}