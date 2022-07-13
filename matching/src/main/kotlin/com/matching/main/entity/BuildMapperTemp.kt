package com.matching.main.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name ="build_mapper_temp")
data class BuildMapperTemp(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkBuildMapper")
    val pkBuildMapper : Long? = null,

    val pkBldgMaster : Int,

    val pkBldgDetail : Int,

    val bldgNm : String,

    @Column(length = 5)
    val sigunguCd : String,

    @Column(length = 5)
    val dongDd : String,

    @Column(length = 10)
    val bun : String,

    @Column(length = 10)
    val ji : String,

    val address : String,

    val addressDoro : String,

    @Column(length = 12)
    val addressDoroCd : String,

    val privateExtent : BigDecimal = BigDecimal.ZERO,

    @Column(length = 100)
    val mainUsseNm : String,

    @Column(length = 2)
    val newYn : String




)
