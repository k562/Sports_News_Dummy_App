package com.example.sportsnews.models


import com.google.gson.annotations.SerializedName

data class NewInfo(
    @SerializedName("message")
    val message: String,
    @SerializedName("news")
    val news: List<New>,
    @SerializedName("status")
    val status: Int
) {
    data class New(
        @SerializedName("newsDescription")
        val newsDescription: String,
        @SerializedName("newsId")
        val newsId: Int,
        @SerializedName("newsImage")
        val newsImage: String,
        @SerializedName("newsTitle")
        val newsTitle: String
    )
}