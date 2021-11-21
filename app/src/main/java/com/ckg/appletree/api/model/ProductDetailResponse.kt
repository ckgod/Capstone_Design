package com.ckg.appletree.api.model

import com.google.gson.annotations.SerializedName

data class ProductDetailResponse(
    @SerializedName("code")
    var code: Int,
    @SerializedName("data")
    var data: Data,
    @SerializedName("msg")
    var msg: String,
    @SerializedName("success")
    var success: Boolean
) {
    data class Data(
        @SerializedName("categoryId")
        var categoryId: Int,
        @SerializedName("categoryName")
        var categoryName: String,
        @SerializedName("content")
        var content: String,
        @SerializedName("imageUrls")
        var imageUrls: MutableList<String>,
        @SerializedName("itemId")
        var itemId: Int,
        @SerializedName("limitPrice")
        var limitPrice: Int,
        @SerializedName("nickname")
        var nickname: String,
        @SerializedName("over")
        var over: Boolean,
        @SerializedName("sellPrice")
        var sellPrice: Int,
        @SerializedName("seller")
        var seller: Boolean,
        @SerializedName("title")
        var title: String,
        @SerializedName("userId")
        var userId: Int
    )
}