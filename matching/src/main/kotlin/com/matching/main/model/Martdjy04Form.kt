package com.matching.main.model


import java.math.BigDecimal
import javax.management.monitor.StringMonitor
import javax.persistence.*

data class Martdjy04Form(


        val bldgPk: String,

        val address: String,

        val addressDoro: String,

        val bldgNm: String,

        val sigunguCd: String,

        val dongCd: String,

        val landDivCd: String,

        val bun: String,

        val ji: String,

        val specialLandNm: String,

        val block: String,

        val lot: String,

        val addressDoroCd: String,

        val addressDoroLawdCd: String,

        val addressDoroUpdownCd: String,

        val addressDoroBun: Int,

        val addressDoroJi: Int,

        val bldgDongNM : String,

        val floorDivCd : String,

        val floorDivNm : String,

        val floorNum : Int,

        val floorNumNm : String,

        val strcCd : String,

        val strcNm : String,

        val etcStrcNm : String,

        val mainUseCd : String,

        val mainUseNm : String,

        val etcUseNm : String,

        val extent : BigDecimal = BigDecimal.ZERO,

        val mainStrcCd : String,

        val mainStrcNm : String,

        val areaExctYn : String,

        val createDt : String





        )
