package com.example.sportsnews.models


import com.google.gson.annotations.SerializedName

data class NewsTrendingHighlights(
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
            @SerializedName("newsSource")
            val newSource: String,
            @SerializedName("newsTime")
            val newsTime: String,
            @SerializedName("newsTitle")
            val newsTitle: String,
            @SerializedName("newsViews")
            val newsViews: String ,

        )

        data class TrendingNew(
            @SerializedName("newsDescription")
            val newsDescription: String,
            @SerializedName("newsId")
            val newsId: Int,
            @SerializedName("newsImage")
            val newsImage: String,
            @SerializedName("newsTime")
            val newsTime: String,
            @SerializedName("newsViews")
            val newsViews: String
        )
    }
}