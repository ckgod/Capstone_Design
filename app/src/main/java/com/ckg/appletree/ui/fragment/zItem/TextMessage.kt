package com.ckg.appletree.ui.fragment.zItem

import com.google.gson.annotations.SerializedName


class TextMessage(
    @SerializedName("senderName")
    var senderName: String,

    @SerializedName("senderId")
    var senderId: String,

    @SerializedName("receiverId")
    var receiverId: String,

    @SerializedName("receiverName")
    var receiverName: String,

    @SerializedName("timeStamp")
    var timeStamp: Long,

    @SerializedName("contents")
    var messageContent: String,

    @SerializedName("isReceived")
    var isReceived: Boolean,

    @SerializedName("isSendComplete")
    var isSendComplete: Boolean
    ){}

