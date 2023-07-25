package com.example.sportsnews


import com.google.gson.annotations.SerializedName

data class ListMatch(
//    @SerializedName("MatchList")
//    val matchList: ArrayList<Match>,
//    @SerializedName("message")
//    val message: String,
//    @SerializedName("status")
//    val status: Int

   val league : String ,
   val frontteam_countryName : String ,
   val frontteam_logo : Int ,
   val time : String ,
   val date : String ,
   val opponentteam_countryName : String ,
   val opponentteam_logo : Int ,
//   val table  : String ,
//   val schedule : String




)


 // {
 //   data class Match(
//        @SerializedName("date")
//        val date: String,
//        @SerializedName("front_team_code")
//        val frontTeamCode: String,
//        @SerializedName("front_team_id")
//        val frontTeamId: Int,
//        @SerializedName("front_team_logo")
//        val frontTeamLogo: String,
//        @SerializedName("front_team_name")
//        val frontTeamName: String,
//        @SerializedName("league")
//        val league: String,
//        @SerializedName("match_id")
//        val matchId: String,
//        @SerializedName("opp_team_code")
//        val oppTeamCode: String,
//        @SerializedName("opp_team_id")
//        val oppTeamId: Int,
//        @SerializedName("opp_team_logo")
//        val oppTeamLogo: String,
//        @SerializedName("opp_team_name")
//        val oppTeamName: String,
//        @SerializedName("status")
//        val status: String,
//        @SerializedName("time")
//        val time: String,
//        @SerializedName("toss")
//        val toss: String
 //   )
// }