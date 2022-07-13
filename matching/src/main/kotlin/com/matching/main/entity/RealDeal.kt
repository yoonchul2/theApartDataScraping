package com.matching.main.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name ="real_deal")
data class RealDeal(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "realContractId")
    val realContractId : Long? = null,

    @Column(length = 50)
    val realContractType : String,

    val apartmentName : String,

    val dealAmount : BigDecimal = BigDecimal.ZERO,

    val deposit : BigDecimal = BigDecimal.ZERO,

    val monthlyRent : BigDecimal = BigDecimal.ZERO,

    @Column(length = 5)
    val regionalCode : Int,

    @Column(length = 40)
    val sigungu : String,

    @Column(length = 40)
    val dong : String,

    @Column(length = 4)
    val ji : Int,

    @Column(length = 4)
    val bun : Int,

    @Column(length = 3)
    val floor : Int,

    val areaForExclusiveUse : BigDecimal = BigDecimal.ZERO,

    val landArea : BigDecimal = BigDecimal.ZERO,

    @Column(length = 10)
    val contractType : String,

    @Column(length = 20)
    val contractTerm : String,

    @Column(length = 10)
    val reqGbn : String,

    @Column(length = 5)
    val buildYear : Int,

    @Column(length = 5)
    val dealYear : Int,

    @Column(length = 2)
    val dealMonth : Int,

    @Column(length = 2)
    val dealDay : Int,

    val rdealerLawdnm : String,

    @Column(length = 8)
    val cancelDealDay : String,

    @Column(length = 2)
    val cancelDealType : Int,

    @Column(length = 2)
    val contractRenewal : Int,

    val previousContractMonthly : BigDecimal = BigDecimal.ZERO,

    val previousContractDeposit : BigDecimal = BigDecimal.ZERO










)
