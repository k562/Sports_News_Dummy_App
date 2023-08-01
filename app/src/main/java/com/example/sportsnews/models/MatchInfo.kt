package com.example.sportsnews.models


import com.google.gson.annotations.SerializedName

data class MatchInfo(
    @SerializedName("info")
    val info: Info,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
) {
    data class Info(
        @SerializedName("matchData")
        val matchData: MatchData,
        @SerializedName("scoreInfo")
        val scoreInfo: ScoreInfo,
        @SerializedName("venue")
        val venue: Venue
    ) {
        data class MatchData(
            @SerializedName("frontTeam")
            val frontTeam: FrontTeam,
            @SerializedName("matchName")
            val matchName: String,
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

        data class ScoreInfo(
            @SerializedName("date")
            val date: String,
            @SerializedName("match")
            val match: String,
            @SerializedName("refry")
            val refry: String,
            @SerializedName("series")
            val series: String,
            @SerializedName("time")
            val time: String
        )

        data class Venue(
            @SerializedName("capacity")
            val capacity: String,
            @SerializedName("city")
            val city: String,
            @SerializedName("stadium")
            val stadium: String
        )
    }
}