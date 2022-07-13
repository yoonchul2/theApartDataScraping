package com.matching.main.entity

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name ="region_cd")
data class RegionCd(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idx")
    val idx : Long? = null,

    val lawdCd : String,

    val lawdCd2 : String,

    val lawdCd5 : String,

    val level : BigDecimal = BigDecimal.ZERO,

    val sigunguCd : String,

    val dongCd : String,

    val lawdCd2Nm : String,

    val lawdCd5Nm : String,

    val lawdCdNm : String,

    val lat : BigDecimal = BigDecimal.ZERO,

    val lon : BigDecimal = BigDecimal.ZERO















)
