package com.example.dchikhaoui.testmvp.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import com.example.dchikhaoui.testmvp.Model.Player
import com.example.dchikhaoui.testmvp.Presenter.PlayerPresenter
import com.example.dchikhaoui.testmvp.R
import com.example.dchikhaoui.testmvp.Utils.StringUtils
import com.example.dchikhaoui.testmvp.View.Adaptater.PlayerAdaptater
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class PlayerActivity : AppCompatActivity() {
    var TAG: String = PlayerActivity::class.java.getSimpleName()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        var mClubName: String = getIntent().getExtras().getString(StringUtils().Team_NAME)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()!!.setTitle(mClubName)
        val rv: RecyclerView = findViewById(R.id.list_player)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        var mPlayerAdaptater = PlayerAdaptater()
        rv.adapter = mPlayerAdaptater
        PlayerPresenter().getListPlayer(mClubName)
                .flatMapIterable { items -> items.player }
                .subscribe(object : Observer<Player> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(mPlayer: Player) {
                        mPlayerAdaptater.addItem(mPlayer)
                    }

                    override fun onError(e: Throwable) {
                        Log.i(TAG, "error : " + e.toString())
                    }

                    override fun onComplete() {
                        mPlayerAdaptater.notifyDataSetChanged()
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