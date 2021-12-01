package com.ckg.appletree.api.model

import com.google.gson.annotations.SerializedName

class DefaultResponse(
    @SerializedName("code")
    var code: Int,
    @SerializedName("msg")
    var msg: String,
    @SerializedName("success")
    var success: Boolean
) {

}