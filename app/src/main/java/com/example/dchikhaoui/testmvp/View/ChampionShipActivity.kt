package com.example.dchikhaoui.testmvp.View

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.util.Log
import com.example.dchikhaoui.testmvp.Model.ChampionShip
import com.example.dchikhaoui.testmvp.Presenter.ChampionShipPresenter
import com.example.dchikhaoui.testmvp.R
import com.example.dchikhaoui.testmvp.Utils.StringUtils
import com.example.dchikhaoui.testmvp.View.Adaptater.ChampionShipAdaptater
import com.example.dchikhaoui.testmvp.databinding.ActivityChampionshipBinding
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class ChampionShipActivity : AppCompatActivity() {
    lateinit var mActivity: ActivityChampionshipBinding
    var adapter: ChampionShipAdaptater = ChampionShipAdaptater()
    var TAG: String = PlayerActivity::class.java.getSimpleName()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = DataBindingUtil.setContentView(this, R.layout.activity_championship)
        mActivity.search.setActivated(true)
        mActivity.search.setQueryHint(getResources().getString(R.string.championShip_Placeholder))
        mActivity.search.onActionViewExpanded();
        mActivity.search.setIconified(false)
        mActivity.search.clearFocus()
        var searchView: SearchView = findViewById(R.id.search)
        ChampionShipPresenter().getListChampion()
                .subscribe(object : Observer<ChampionShip> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(mChampionship: ChampionShip) {
                        adapter.addData(mChampionship)
                    }

                    override fun onError(e: Throwable) {
                        Log.i(TAG, "error : " + e.toString())
                    }

                    override fun onComplete() {
                        adapter.notifyDataSetChanged()
                    }
                })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onQueryTextChange(newText: String): Boolean {
                adapter.getFilter().filter(newText)
                mActivity.listView.setAdapter(adapter)
                mActivity.listView.setOnItemClickListener { parent, view, position, id ->
                    val intent = Intent(applicationContext, TeamActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString(StringUtils().CHAMPIONSHIP_NAME, adapter.mData[position])
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                return false
            }

        })
    }
}