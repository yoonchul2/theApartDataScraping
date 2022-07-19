package com.matching.main.model


import java.math.BigDecimal
import javax.persistence.*


data class Martdjy03Form(


        val bldgPk : String,

        val bldgDivCd : String,

        val bldgDivNm : String,

        val bldgKindCd : String,

        val bldgKindNm : String,

        val address : String,

        val addressDoro : String,

        val bldgNm  : String,

        val sigunguCd : String,

        val dongCd : String,

        val landDivCd : String,

        val bun : String,

        val ji : String,

        val specialLandNm : String,

        val block : String,

        val lot : String,

        val etcLandNum : Int,

        val addressDoroCd : String,

        val addressDoroLawdCd : String,

        val addressDoroUpdownCd : String,

        val addressDoroBun : Int,

        val addressDoroJi : Int,

        val bldgDongNm : String,

        val mainStrcCd : String,

        val mainStrcNm : String,

        val platArea : BigDecimal = BigDecimal.ZERO,

        val archArea : BigDecimal = BigDecimal.ZERO,

        val bcRat : BigDecimal = BigDecimal.ZERO,

        val totArea : BigDecimal = BigDecimal.ZERO,

        val vlRatEstmTotArea : BigDecimal = BigDecimal.ZERO,

        val vlRat : BigDecimal = BigDecimal.ZERO,

        val strcCd : String,

        val strcNm : String,

        val etcStrcNm : String,

        val mainUseCd : String,

        val mainUseNm : String,

        val etcUseNm : String,

        val roofCd : String,

        val roofCdNm : String,

        val etcRoof : String,

        val hhldCnt : Int,

        val fmlyCnt : Int,

        val heit : BigDecimal = BigDecimal.ZERO,

        val grndFlrCnt : Int,

        val ugrndFlrCnt : Int,

        val rideUseElvtCnt : Int,

        val emgenUseElvtCnt : Int,

        val atchBldCnt : Int,

        val atchBldArea : BigDecimal = BigDecimal.ZERO,

        val totDongTotArea : BigDecimal = BigDecimal.ZERO,

        val indrMechUtcnt : Int,

        val indrMechArea : BigDecimal = BigDecimal.ZERO,

        val oudrMechUtcnt : Int,

        val oudrMechArea : BigDecimal = BigDecimal.ZERO,

        val indrAutoUtcnt : Int,

        val indrAutoArea : BigDecimal = BigDecimal.ZERO,

        val oudrAutoUtcnt : Int,

        val oudrAutoArea : BigDecimal = BigDecimal.ZERO,

        val pmsDay : String,

        val stcnsDay : String,

        val useAprDay : String,

        val pmsnoYear : String,

        val pmsnoKikCd : String,

        val pmsnoKikCdNm : String,

        val pmsnoGbCd : String,

        val pmsnoGbCdNm : String,

        val hoCnt : Int,

        val engrGrade : String,

        val engrRat : BigDecimal = BigDecimal.ZERO,

        val engrEpi : Int,

        val gnBldGrade : String,

        val gnBldCert : Int,

        val itgBldGrade : String,

        val itgBldCert : Int,

        val createDt : String,

        val rserthqkDsgnApplyYn : String,

        val rserthqkAblty : String
        )

