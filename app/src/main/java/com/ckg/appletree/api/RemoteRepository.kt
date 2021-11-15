package com.ckg.appletree.api

import com.ckg.appletree.api.model.*
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody

class RemoteRepository {
    fun postLogin(loginRequest: LoginRequest): Observable<LoginResponse> {
        return RetrofitCreator.create(
            UserApi.UserApiImpl::class.java
        ).postLogin(params = loginRequest)
    }
}