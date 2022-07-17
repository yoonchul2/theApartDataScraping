package com.matching.main.entity


import java.math.BigDecimal
import javax.management.monitor.StringMonitor
import javax.persistence.*

@Entity
@Table(name ="mart_djy_04")//층별개요
data class Martdjy04(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="idx")
        val idx: Long?=null,

        val bldgPk: String,

        val address: String,

        val addressDoro: String,

        val bldgNm: String,

        @Column(length = 5)
        val sigunguCd: String,

        @Column(length = 5)
        val dongCd: String,

        @Column(length = 1)
        val landDivCd: String,

        @Column(length = 4)
        val bun: String,

        @Column(length = 4)
        val ji: String,

        val specialLandNm: String,

        @Column(length = 20)
        val block: String,

        @Column(length = 20)
        val lot: String,

        @Column(length = 12)
        val addressDoroCd: String,

        @Column(length = 5)
        val addressDoroLawdCd: String,

        @Column(length = 1)
        val addressDoroUpdownCd: String,

        @Column(length = 5)
        val addressDoroBun: Int,

        @Column(length = 5)
        val addressDoroJi: Int,

        @Column(length = 100)
        val bldgDongNM : String,

        @Column(length = 2)
        val floorDivCd : String,

        @Column(length = 100)
        val floorDivNm : String,

        @Column(length = 4)
        val floorNum : Int,

        @Column(length = 100)
        val floorNumNm : String,

        @Column(length = 2)
        val strcCd : String,

        @Column(length = 100)
        val strcNm : String,

        val etcStrcNm : String,

        @Column(length = 5)
        val mainUseCd : String,

        @Column(length = 100)
        val mainUseNm : String,

        val etcUseNm : String,

        val extent : BigDecimal = BigDecimal.ZERO,

        @Column(length = 1)
        val mainStrcCd : String,

        @Column(length = 100)
        val mainStrcNm : String,

        @Column(length = 1)
        val areaExctYn : String,

        @Column(length = 8)
        val createDt : String





        )
