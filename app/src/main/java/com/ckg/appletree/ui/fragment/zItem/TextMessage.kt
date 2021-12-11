package com.ckg.appletree.ui.fragment.zItem

import com.google.gson.annotations.SerializedName


class TextMessage(
    @SerializedName("type")
    var type: String,

    @SerializedName("sessionId")
    var sessionId: String,

    @SerializedName("content")
    var content: String,

    @SerializedName("isReceived")
    var isReceived: Boolean,

    @SerializedName("nickname")
    var nickname: String,

    ){}

