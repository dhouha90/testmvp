package com.example.dchikhaoui.testmvp.Presenter

import com.example.dchikhaoui.testmvp.Model.ChampionShip
import com.example.dchikhaoui.testmvp.Network.HttpService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class ChampionShipPresenter {
    fun getListChampion(): Observable<ChampionShip> {
        return HttpService().getClient()
                .getListChampion()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMapIterable { items -> items.leagues }

    }

}