package com.ckg.appletree.ui.fragment.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ckg.appletree.api.model.ChatRoomListResponse
import com.ckg.appletree.api.repository.RemoteRepository
import com.ckg.appletree.api.model.ProductDetailResponse
import com.ckg.appletree.api.model.ProductListResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProfileViewModel : ViewModel() {
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

    private var _productListResponse : MutableLiveData<ProductListResponse> = MutableLiveData()
    val productListResponse get() = _productListResponse

    fun getSellingList() {
        CompositeDisposable().add(
            remoteRepository.getSellingList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        productListResponse.postValue(response)
                    }, { throwable ->
                        Log.d(TAG,"throwable.localizedMessage : ${throwable.localizedMessage}")
                        productListResponse.postValue(null)
                    })
        )
    }

    private var _chatRoomListResponse : MutableLiveData<ChatRoomListResponse> = MutableLiveData()
    val chatRoomListResponse get() = _chatRoomListResponse

    fun getRoomList(){
        CompositeDisposable().add(
            remoteRepository.getChatRoomList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        chatRoomListResponse.postValue(response)
                    }, { throwable ->
                        Log.d(TAG,"throwable.localizedMessage : ${throwable.localizedMessage}")
                        chatRoomListResponse.postValue(null)
                    })
        )
    }

    companion object{
        const val TAG = "ProductViewModel"
    }
}