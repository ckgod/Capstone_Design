package com.ckg.appletree.api.repository

import com.ckg.appletree.api.RetrofitCreator
import com.ckg.appletree.api.UserApi
import com.ckg.appletree.api.model.*
import io.reactivex.Observable

class RemoteRepository {
    fun postLogin(loginRequest: LoginRequest): Observable<LoginResponse> {
        return RetrofitCreator.create(
            UserApi.UserApiImpl::class.java
        ).postLogin(params = loginRequest)
    }

    fun getProductDetail(itemId : Int) : Observable<ProductDetailResponse> {
        return RetrofitCreator.create(
            UserApi.UserApiImpl::class.java
        ).getProductDetail(itemId)
    }

    fun getProductList(categoryId : Int) : Observable<ProductListResponse> {
        return RetrofitCreator.create(
            UserApi.UserApiImpl::class.java
        ).getProduceList(categoryId)
    }

    fun getChatRoomList() : Observable<ChatRoomListResponse> {
        return RetrofitCreator.create(
            UserApi.UserApiImpl::class.java
        ).getChatRoomList()
    }

    fun getSellingList() : Observable<ProductListResponse> {
        return RetrofitCreator.create(
            UserApi.UserApiImpl::class.java
        ).getSellingList()
    }

}