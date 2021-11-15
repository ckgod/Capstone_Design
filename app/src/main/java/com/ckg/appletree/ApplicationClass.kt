package com.ckg.appletree

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        if (spToken == null) {
            spToken = applicationContext.getSharedPreferences(X_ACCESS_TOKEN, Context.MODE_PRIVATE)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }

    companion object {  // Retrofit 인스턴스
        const val TAG = "ApplicationClass"

        var emailPattern : String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        var X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        var instance: ApplicationClass? = null

        var sSharedPreferences: SharedPreferences? = null

        // jwt Token 저장
        var spToken : SharedPreferences? = null
    }
}