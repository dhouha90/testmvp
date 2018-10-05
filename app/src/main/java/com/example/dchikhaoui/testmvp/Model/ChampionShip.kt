package com.example.dchikhaoui.testmvp.Model

data class ChampionShip(
        var idLeague: String,
        var strLeague: String,
        var strSport: String,
        var strLeagueAlternate: String
) {
    override fun toString(): String {
        return "ChampionShip(idLeague='$idLeague', strLeague='$strLeague', strSport='$strSport', strLeagueAlternate='$strLeagueAlternate')"
    }
        
        fun test(){
        }
}
