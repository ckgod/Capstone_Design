package com.ckg.appletree.api.model

import com.google.gson.annotations.SerializedName

class WebSocketRequest(
    @SerializedName("type")
    var type: String,
    @SerializedName("sessionId")
    var sessionId: String,
    @SerializedName("content")
    var content: String,
    @SerializedName("nickname")
    var nickname: String
) {
}