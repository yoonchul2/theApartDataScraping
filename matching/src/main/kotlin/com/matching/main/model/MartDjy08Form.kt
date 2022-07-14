package com.bokbuin.main.model

import java.math.BigDecimal


data class MartDjy08Form(

        val bldgPk: String,

        val bldgDivCd: String,

        val bldgDivNm: String,

        val bldgKindCd: String,

        val bldgKindNm: String,

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

        val etcLandNum: Int,

        val addressDoroCd: String,

        val addressDoroLawdCd: String,

        val addressDoroUpdownCd: String,

        val addressDoroBun: Int,

        val addressDoroJi: Int,

        val standardDt: String,

        val price: BigDecimal = BigDecimal.ZERO,

        val createDt: String

)
