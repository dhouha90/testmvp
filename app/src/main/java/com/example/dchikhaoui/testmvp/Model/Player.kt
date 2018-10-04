package com.example.dchikhaoui.testmvp.Model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide


data class Player(val idPlayer: String,
                  val idTeam: String,
                  val idSoccerXML: String,
                  val idPlayerManager: String,
                  val strNationality: String,
                  val strPlayer: String,
                  val strTeam: String,
                  val strSport: String,
                  val intSoccerXMLTeamID: String,
                  val dateBorn: String,
                  val dateSigned: String,
                  val strSigning: String,
                  val strWage: String,
                  val strBirthLocation: String,
                  val strDescriptionEN: String,
                  val strDescriptionDE: String,
                  val strDescriptionFR: String,
                  val strDescriptionCN: String,
                  val strDescriptionIT: String,
                  val strDescriptionJP: String,
                  val strDescriptionRU: String,
                  val strDescriptionES: String,
                  val strDescriptionPT: String,
                  val strDescriptionSE: String,
                  val strDescriptionNL: String,
                  val strDescriptionHU: String,
                  val strDescriptionNO: String,
                  val strDescriptionIL: String,
                  val strDescriptionPL: String,
                  val strGender: String,
                  val strPosition: String,
                  val strCollege: String,
                  val strFacebook: String,
                  val strWebsite: String,
                  val strTwitter: String,
                  val strInstagram: String,
                  val strYoutube: String,
                  val strHeight: String,
                  val strWeight: String,
                  val intLoved: String,
                  val strThumb: String,
                  val strCutout: String,
                  val strBanner: String,
                  val strFanart1: String,
                  val strFanart2: String,
                  val strFanart3: String,
                  val strFanart4: String,
                  val strLocked: String) {


    override fun toString(): String {
        return "Player(idPlayer='$idPlayer', idTeam='$idTeam', idSoccerXML='$idSoccerXML', idPlayerManager='$idPlayerManager', strNationality='$strNationality', strPlayer='$strPlayer', strTeam='$strTeam', strSport='$strSport', intSoccerXMLTeamID='$intSoccerXMLTeamID', dateBorn='$dateBorn', dateSigned='$dateSigned', strSigning='$strSigning', strWage='$strWage', strBirthLocation='$strBirthLocation', strDescriptionEN='$strDescriptionEN', strDescriptionDE='$strDescriptionDE', strDescriptionFR='$strDescriptionFR', strDescriptionCN='$strDescriptionCN', strDescriptionIT='$strDescriptionIT', strDescriptionJP='$strDescriptionJP', strDescriptionRU='$strDescriptionRU', strDescriptionES='$strDescriptionES', strDescriptionPT='$strDescriptionPT', strDescriptionSE='$strDescriptionSE', strDescriptionNL='$strDescriptionNL', strDescriptionHU='$strDescriptionHU', strDescriptionNO='$strDescriptionNO', strDescriptionIL='$strDescriptionIL', strDescriptionPL='$strDescriptionPL', strGender='$strGender', strPosition='$strPosition', strCollege='$strCollege', strFacebook='$strFacebook', strWebsite='$strWebsite', strTwitter='$strTwitter', strInstagram='$strInstagram', strYoutube='$strYoutube', strHeight='$strHeight', strWeight='$strWeight', intLoved='$intLoved', strThumb='$strThumb', strCutout='$strCutout', strBanner='$strBanner', strFanart1='$strFanart1', strFanart2='$strFanart2', strFanart3='$strFanart3', strFanart4='$strFanart4', strLocked='$strLocked')"
    }

}

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("imageURL")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }
}