package com.bokbuin.main.model

import java.math.BigDecimal


data class MartDjy06Form(

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

        val addressDoroCd : String,

        val addressDoroLawdCd : String,

        val addressDoroUpdownCd : String,

        val addressDoroBun : String,

        val addressDoroJi : String,

        val bldgDongNm : String,

        val bldgHoNm : String,

        val floorDivCd : String,

        val floorDivNm : String,

        val floorNum : BigDecimal = BigDecimal.ZERO,

        val extentDivCd : String,

        val extentDivNm : String,

        val mainStrcCd : String,

        val mainStrcNm : String,

        val floorNumNm  : String,

        val strcCd : String,

        val strcNm : String,

        val etcStrcNm : String,

        val mainUseCd : String,

        val mainUseNm : String,

        val etcUseNm : String,

        val extent : BigDecimal = BigDecimal.ZERO,

        val createDt : String


)
