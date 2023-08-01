package com.example.sportsnews.models


import com.google.gson.annotations.SerializedName

data class Matchlist(
    @SerializedName("message")
    val message: String,
    @SerializedName("sportsNews")
    val sportsNews: SportsNews,
    @SerializedName("status")
    val status: Int
) {
    data class SportsNews(
        @SerializedName("latestNews")
        val latestNews: List<LatestNew>,
        @SerializedName("liveMatch")
        val liveMatch: LiveMatch,
        @SerializedName("matchesData")
        val matchesData: List<MatchesData>
    ) {
        data class LatestNew(
            @SerializedName("newsDate")
            val newsDate: String,
            @SerializedName("newsId")
            val newsId: Int,
            @SerializedName("newsImage")
            val newsImage: String,
            @SerializedName("newsLink")
            val newsLink: String,
            @SerializedName("newsTitle")
            val newsTitle: String
        )

        data class LiveMatch(
            @SerializedName("frontTeam")
            val frontTeam: FrontTeam,
            @SerializedName("matchName")
            val matchName: String,
            @SerializedName("matchStatus")
            val matchStatus: String,
            @SerializedName("oppTeam")
            val oppTeam: OppTeam,
            @SerializedName("stadiumName")
            val stadiumName: String
        ) {
            data class FrontTeam(
                @SerializedName("frontTeamLogo")
                val frontTeamLogo: String,
                @SerializedName("frontTeamName")
                val frontTeamName: String,
                @SerializedName("frontTeamScore")
                val frontTeamScore: String
            )

            data class OppTeam(
                @SerializedName("oppTeamLogo")
                val oppTeamLogo: String,
                @SerializedName("oppTeamName")
                val oppTeamName: String,
                @SerializedName("oppTeamScore")
                val oppTeamScore: String
            )
        }

        data class MatchesData(
            @SerializedName("frontTeam")
            val frontTeam: FrontTeam,
            @SerializedName("matchDate")
            val matchDate: String,
            @SerializedName("matchId")
            val matchId: Int,
            @SerializedName("oppTeam")
            val oppTeam: OppTeam,
            @SerializedName("seriesName")
            val seriesName: String
        ) {
            data class FrontTeam(
                @SerializedName("frontTeamLogo")
                val frontTeamLogo: String,
                @SerializedName("frontTeamName")
                val frontTeamName: String,
                @SerializedName("frontTeamScore")
                val frontTeamScore: String
            )

            data class OppTeam(
                @SerializedName("oppTeamLogo")
                val oppTeamLogo: String,
                @SerializedName("oppTeamName")
                val oppTeamName: String,
                @SerializedName("oppTeamScore")
                val oppTeamScore: String
            )
        }
    }
}