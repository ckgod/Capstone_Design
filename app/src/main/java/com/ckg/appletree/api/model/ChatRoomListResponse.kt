package com.ckg.appletree.api.model

import com.google.gson.annotations.SerializedName

data class ChatRoomListResponse(
    @SerializedName("code")
    var code: Int,
    @SerializedName("list")
    var list: MutableList<Data>,
    @SerializedName("msg")
    var msg: String,
    @SerializedName("success")
    var success: Boolean
) {
    data class Data(
        @SerializedName("chatRoomId")
        var chatRoomId: Int,
        @SerializedName("itemId")
        var itemId: Int,
        @SerializedName("lastMessage")
        var lastMessage: String,
        @SerializedName("lastMessageTime")
        var lastMessageTime: Any,
        @SerializedName("nickname")
        var nickname: String,
        @SerializedName("price")
        var price: Int,
        @SerializedName("sellerNickname")
        var sellerNickname: String,
        @SerializedName("title")
        var title: String
    )
}