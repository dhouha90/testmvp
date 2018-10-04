package com.example.dchikhaoui.testmvp.Presenter

import com.example.dchikhaoui.testmvp.Model.ListPlayer
import com.example.dchikhaoui.testmvp.Model.Player
import com.example.dchikhaoui.testmvp.Network.HttpService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlayerPresenter {
    fun getListPlayer(mClubName: String): Observable<ListPlayer> {
        return HttpService().getClient()
                .searchPlayer(mClubName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }
}