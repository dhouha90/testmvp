package com.example.dchikhaoui.testmvp.Network

import com.example.dchikhaoui.testmvp.Model.ChampionShip
import com.example.dchikhaoui.testmvp.Model.ListChampionShip
import com.example.dchikhaoui.testmvp.Model.ListPlayer
import com.example.dchikhaoui.testmvp.Model.ListTeam
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface HttpInterface {
    @GET("search_all_teams.php")
    fun searchTeam(@Query("l") teamName: String): Observable<ListTeam>

    @GET("searchplayers.php")
    fun searchPlayer(@Query("t") eventName: String): Observable<ListPlayer>

    @GET("all_leagues.php")
    fun getListChampion(): Observable<ListChampionShip>
}