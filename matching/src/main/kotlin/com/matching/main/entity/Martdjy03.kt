package com.matching.main.entity


import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name ="mart_djy_03") //표제부
data class Martdjy03(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="idx")
        val idx: Long?=null,

        val bldgPk : String,

        @Column(length = 1)
        val bldgDivCd : String,

        val bldgDivNm : String,

        @Column(length = 1)
        val bldgKindCd : String,

        val bldgKindNm : String,

        val address : String,

        val addressDoro : String,

        val bldgNm  : String,

        @Column(length = 5)
        val sigunguCd : String,

        @Column(length = 5)
        val dongCd : String,

        @Column(length = 1)
        val landDivCd : String,

        @Column(length = 4)
        val bun : String,

        @Column(length = 4)
        val ji : String,
        
        val specialLandNm : String,

        @Column(length = 20)
        val block : String,

        @Column(length = 20)
        val lot : String,

        @Column(length = 5)
        val etcLandNum : Int,

        @Column(length = 12)
        val addressDoroCd : String,

        @Column(length = 5)
        val addressDoroLawdCd : String,

        @Column(length = 1)
        val addressDoroUpdownCd : String,

        @Column(length = 5)
        val addressDoroBun : Int,

        @Column(length = 5)
        val addressDoroJi : Int,

        val bldgDongNm : String,

        @Column(length = 1)
        val mainStrcCd : String,

        @Column(length = 100)
        val mainStrcNm : String,

        val platArea : BigDecimal = BigDecimal.ZERO,

        val archArea : BigDecimal = BigDecimal.ZERO,

        val bcRat : BigDecimal = BigDecimal.ZERO,

        val totArea : BigDecimal = BigDecimal.ZERO,

        val vlRatEstmTotArea : BigDecimal = BigDecimal.ZERO,

        val vlRat : BigDecimal = BigDecimal.ZERO,

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

        @Column(length = 2)
        val roofCd : String,

        @Column(length = 100)
        val roofCdNm : String,

        val etcRoof : String,

        @Column(length = 5)
        val hhldCnt : Int,

        @Column(length = 5)
        val fmlyCnt : Int,

        val heit : BigDecimal = BigDecimal.ZERO,

        @Column(length = 5)
        val grndFlrCnt : Int,

        @Column(length = 5)
        val ugrndFlrCnt : Int,

        @Column(length = 5)
        val rideUseElvtCnt : Int,

        @Column(length = 5)
        val emgenUseElvtCnt : Int,

        @Column(length = 5)
        val atchBldCnt : Int,

        val atchBldArea : BigDecimal = BigDecimal.ZERO,

        val totDongTotArea : BigDecimal = BigDecimal.ZERO,

        @Column(length = 6)
        val indrMechUtcnt : Int,

        val indrMechArea : BigDecimal = BigDecimal.ZERO,

        @Column(length = 6)
        val oudrMechUtcnt : Int,

        val oudrMechArea : BigDecimal = BigDecimal.ZERO,

        @Column(length = 6)
        val indrAutoUtcnt : Int,

        val indrAutoArea : BigDecimal = BigDecimal.ZERO,

        @Column(length = 6)
        val oudrAutoUtcnt : Int,

        val oudrAutoArea : BigDecimal = BigDecimal.ZERO,

        @Column(length = 8)
        val pmsDay : String,

        @Column(length = 8)
        val stcnsDay : String,

        @Column(length = 8)
        val useAprDay : String,

        @Column(length = 4)
        val pmsnoYear : String,

        @Column(length = 7)
        val pmsnoKikCd : String,

        val pmsnoKikCdNm : String,

        @Column(length = 4)
        val pmsnoGbCd : String,

        @Column(length = 100)
        val pmsnoGbCdNm : String,

        @Column(length = 5)
        val hoCnt : Int,

        @Column(length = 4)
        val engrGrade : String,

        val engrRat : BigDecimal = BigDecimal.ZERO,

        @Column(length = 5)
        val engrEpi : Int,

        @Column(length = 1)
        val gnBldGrade : String,

        @Column(length = 5)
        val gnBldCert : Int,

        @Column(length = 1)
        val itgBldGrade : String,

        @Column(length = 5)
        val itgBldCert : Int,

        val createDt : String,

        @Column(length = 1)
        val rserthqkDsgnApplyYn : String,

        val rserthqkAblty : String
        )
