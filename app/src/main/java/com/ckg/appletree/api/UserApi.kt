package com.ckg.appletree.api

import com.ckg.appletree.api.model.*
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

class UserApi {
    interface UserApiImpl{
        @POST("/v1/login")
        fun postLogin(@Body params: LoginRequest): Observable<LoginResponse>

        @GET("/v1/item/{itemId}")
        fun getProductDetail(@Path("itemId") itemId : Int) : Observable<ProductDetailResponse>

        @GET("/v1/item")
        fun getProduceList(@Query("categoryId") categoryId : Int) : Observable<ProductListResponse>

        @GET("/v1/chat")
        fun getChatRoomList() : Observable<ChatRoomListResponse>

        @GET("/v1/user/on_sale")
        fun getSellingList() : Observable<ProductListResponse>
    }
}