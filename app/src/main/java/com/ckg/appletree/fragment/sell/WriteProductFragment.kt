package com.ckg.appletree.fragment.sell

import androidx.core.net.toUri
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ckg.appletree.R
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentWriteProductBinding
import com.ckg.appletree.utils.ViewUtils

class WriteProductFragment() : BaseKotlinFragment<FragmentWriteProductBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_write_product

    override val showBottomSheetFlag: Boolean
        get() = false

    private val navArgs : WriteProductFragmentArgs by navArgs()

    override fun initStartView() {
        showCustomToast(navArgs.photoUri)
//        binding.ivPicture.setImageURI(navArgs.photoUri.toUri())
        Glide.with(requireContext()).load(navArgs.photoUri.toUri())
            .apply(RequestOptions().transform(CenterCrop()))
            .into(binding.ivPicture)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "WriteProductFragment"
    }
}