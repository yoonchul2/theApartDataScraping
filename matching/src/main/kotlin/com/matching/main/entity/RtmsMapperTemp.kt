package com.matching.main.entity

import java.math.BigDecimal
import java.sql.Time
import javax.persistence.*

@Entity
@Table(name ="rtms_mapper_temp")
data class RtmsMapperTemp(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkRtmsMapper")
    val pkRtmsMapper : Long? = null,

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

    @Column(length = 10)
    val genDt : String,

    val privateExtent : BigDecimal = BigDecimal.ZERO,

    @Column(length = 2)
    val newYn : String,

    @Column(length = 11)
    val type : String,

    @Column(length = 2)
    val useYn : String,

    val instDt : Time




)
