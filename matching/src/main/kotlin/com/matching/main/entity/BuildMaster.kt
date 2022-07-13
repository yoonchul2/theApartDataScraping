package com.matching.main.entity

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name ="build_master")
data class BuildMaster(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkBuildMaster")
    val pkBuildMaster : Long? = null,

    val bldgNm : String,

    @Column(length = 10)
    val lawdCd : String,

    val address : String,

    val addressDoro : String,

    @Column(length = 10)
    val bun : String,

    @Column(length = 10)
    val ji : String,

    val instDt : Date











)
