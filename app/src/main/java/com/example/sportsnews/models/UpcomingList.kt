package com.example.sportsnews.models


import com.google.gson.annotations.SerializedName

data class UpcomingList(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("upcomingMatches")
    val upcomingMatches: List<UpcomingMatche>
) {
    data class UpcomingMatche(
        @SerializedName("frontTeam")
        val frontTeam: FrontTeam,
        @SerializedName("matchDate")
        val matchDate: String,
        @SerializedName("matchId")
        val matchId: Int,
        @SerializedName("matchName")
        val matchName: String,
        @SerializedName("matchTime")
        val matchTime: String,
        @SerializedName("oppTeam")
        val oppTeam: OppTeam
    ) {
        data class FrontTeam(
            @SerializedName("frontTeamLogo")
            val frontTeamLogo: String,
            @SerializedName("frontTeamName")
            val frontTeamName: String
        )

        data class OppTeam(
            @SerializedName("oppTeamLogo")
            val oppTeamLogo: String,
            @SerializedName("oppTeamName")
            val oppTeamName: String
        )
    }
}