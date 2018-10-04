package com.example.dchikhaoui.testmvp.Presenter

import com.example.dchikhaoui.testmvp.Model.ListTeam
import com.example.dchikhaoui.testmvp.Model.Team
import com.example.dchikhaoui.testmvp.Network.HttpService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TeamPresenter {
    fun getListTeam(mTeamName: String): Observable<ListTeam> {
        return HttpService().getClient()
                .searchTeam(mTeamName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}
