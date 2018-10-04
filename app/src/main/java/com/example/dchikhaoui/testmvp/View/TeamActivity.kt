package com.example.dchikhaoui.testmvp.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import com.example.dchikhaoui.testmvp.Model.Team
import com.example.dchikhaoui.testmvp.Presenter.TeamPresenter
import com.example.dchikhaoui.testmvp.R
import com.example.dchikhaoui.testmvp.Utils.StringUtils
import com.example.dchikhaoui.testmvp.View.Adaptater.TeamAdaptater
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class TeamActivity : AppCompatActivity() {
    var TAG: String = PlayerActivity::class.java.getSimpleName()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
        var mChampionShipName: String = getIntent().getExtras().getString(StringUtils().CHAMPIONSHIP_NAME)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()!!.setTitle(mChampionShipName)

        val rv: RecyclerView = findViewById(R.id.list_team)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        var mTeamAdaptater = TeamAdaptater()
        rv.adapter = mTeamAdaptater
        TeamPresenter().getListTeam(mChampionShipName)
                .flatMapIterable { items -> items.teams }
                .subscribe(object : Observer<Team> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(mTeam: Team) {
                        mTeamAdaptater.addItem(mTeam)
                    }

                    override fun onError(e: Throwable) {
                        Log.i(TAG, "error : " + e.toString())
                    }

                    override fun onComplete() {
                        mTeamAdaptater.notifyDataSetChanged()
                    }
                })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
