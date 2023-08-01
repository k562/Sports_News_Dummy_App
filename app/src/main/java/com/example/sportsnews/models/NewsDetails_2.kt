package com.example.sportsnews.models


import com.google.gson.annotations.SerializedName

data class NewsDetails_2(
    @SerializedName("message")
    val message: String,
    @SerializedName("newsDetails")
    val newsDetails: NewsDetails,
    @SerializedName("status")
    val status: Int
) {
    data class NewsDetails(
        @SerializedName("highlights")
        val highlights: List<Highlight>,
        @SerializedName("trendingNews")
        val trendingNews: List<TrendingNew>
    ) {
        data class Highlight(
            @SerializedName("newsDate")
            val newsDate: String,
            @SerializedName("newsId")
            val newsId: Int,
            @SerializedName("newsImage")
            val newsImage: String,
            @SerializedName("newsTime")
            val newsTime: String,
            @SerializedName("newsTitle")
            val newsTitle: String,
            @SerializedName("newsViews")
            val newsViews: String,
            @SerializedName("newsDescription")
            val newsDescription: String,
        )

        data class TrendingNew(
            @SerializedName("newsDescription")
            val newsDescription: String,
            @SerializedName("newsId")
            val newsId: Int,
            @SerializedName("newsImage")
            val newsImage: String,
            @SerializedName("newsTitle")
            val newsTitle: String,
            @SerializedName("newsTime")
            val newsTime: String,
            @SerializedName("newsDate")
            val newsDate: String,
            @SerializedName("newsViews")
            val newsViews: String
        )
    }
}