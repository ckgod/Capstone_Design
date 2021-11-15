package com.ckg.appletree.api

import com.ckg.appletree.api.model.*
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

class UserApi {
    interface UserApiImpl{
        @POST("/v1/sign-in")
        fun postLogin(@Body params: LoginRequest): Observable<LoginResponse>
    }
}