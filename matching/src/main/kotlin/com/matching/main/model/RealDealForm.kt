package com.matching.main.model

import java.math.BigDecimal
import javax.persistence.*

data class RealDealForm(

    val realContractId : Long? = null,

    val realContractType : String,

    val apartmentName : String,

    val dealAmount : BigDecimal = BigDecimal.ZERO,

    val deposit : BigDecimal = BigDecimal.ZERO,

    val monthlyRent : BigDecimal = BigDecimal.ZERO,

    val regionalCode : Int,

    val sigungu : String,

    val dong : String,

    val ji : Int,

    val bun : Int,

    val floor : Int,

    val areaForExclusiveUse : BigDecimal = BigDecimal.ZERO,

    val landArea : BigDecimal = BigDecimal.ZERO,

    val contractType : String,

    val contractTerm : String,

    val reqGbn : String,

    val buildYear : Int,

    val dealYear : Int,

    val dealMonth : Int,

    val dealDay : Int,

    val rdealerLawdnm : String,

    val cancelDealDay : String,

    val cancelDealType : Int,

    val contractRenewal : Int,

    val previousContractMonthly : BigDecimal = BigDecimal.ZERO,

    val previousContractDeposit : BigDecimal = BigDecimal.ZERO










)
