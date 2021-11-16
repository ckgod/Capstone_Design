package com.ckg.appletree.api.model

import com.google.gson.annotations.SerializedName

class RandomNumResponse(
    @SerializedName("code")
    var code: Int,
    @SerializedName("data")
    var data: String,
    @SerializedName("msg")
    var msg: String,
    @SerializedName("success")
    var success: Boolean
) {

}