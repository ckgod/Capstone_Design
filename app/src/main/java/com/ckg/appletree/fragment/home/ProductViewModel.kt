package com.ckg.appletree.fragment.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ckg.appletree.api.RemoteRepository
import com.ckg.appletree.api.model.ProductDetailResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductViewModel : ViewModel() {
    private val remoteRepository: RemoteRepository =
        RemoteRepository()

    private var _productDetailResponse : MutableLiveData<ProductDetailResponse> = MutableLiveData()
    val productDetailResponse get() = _productDetailResponse

    fun getProductDetail(itemId : Int) {
        CompositeDisposable().add(
            remoteRepository.getProductDetail(itemId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        productDetailResponse.postValue(response)
                    }, { throwable ->
                        Log.d(TAG,"throwable.localizedMessage : ${throwable.localizedMessage}")
                        productDetailResponse.postValue(null)
                    })
        )
    }

    companion object{
        const val TAG = "ProductViewModel"
    }
}