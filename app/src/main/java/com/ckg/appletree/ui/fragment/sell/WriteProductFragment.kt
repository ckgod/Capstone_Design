package com.ckg.appletree.ui.fragment.sell

import android.annotation.SuppressLint
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.ckg.appletree.R
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentWriteProductBinding
import java.text.DecimalFormat

class WriteProductFragment() : BaseKotlinFragment<FragmentWriteProductBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_write_product

    override val showBottomSheetFlag: Boolean
        get() = false

    private val navArgs : WriteProductFragmentArgs by navArgs()
    lateinit var decimalFormat : DecimalFormat
    lateinit var decimalFormat2: DecimalFormat
    var resultString = ""
    var resultString2 = ""

    override fun initStartView() {
        binding.btnComplete.setOnClickListener {
            showProgress()
            Handler().postDelayed({
                hideProgress()
                findNavController().navigate(WriteProductFragmentDirections.actionWriteProductFragmentToSellMain())
                showCustomToast("상품 등록이 완료되었습니다.")
            }, 1500)
        }
        decimalFormat = DecimalFormat("#,###")
        decimalFormat2 = DecimalFormat("#,###")
        Glide.with(requireContext()).load(navArgs.photoUri.toUri())
            .apply(RequestOptions().transform(CenterCrop()))
            .into(binding.ivPicture)

        binding.etFixPrice.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!TextUtils.isEmpty(p0.toString()) && !p0.toString().equals(resultString)){
                    resultString = decimalFormat.format((p0.toString().replace(",","")).toDouble());
                    binding.etFixPrice.setText(resultString);
                    binding.etFixPrice.setSelection(resultString.length);
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        binding.etSellPrice.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!TextUtils.isEmpty(p0.toString()) && !p0.toString().equals(resultString2)){
                    resultString2 = decimalFormat2.format((p0.toString().replace(",","")).toDouble());
                    binding.etSellPrice.setText(resultString2);
                    binding.etSellPrice.setSelection(resultString2.length);
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

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