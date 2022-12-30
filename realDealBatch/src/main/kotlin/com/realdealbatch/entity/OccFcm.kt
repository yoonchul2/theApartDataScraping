package com.realdealbatch.entity
import javax.persistence.*

@Entity
@Table(name ="TB_occ_fcm")
data class OccFcm(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq : Long? = null,
    @Column(name = "ho_seq")
    var hoSeq: Long?=null,

    @Column(name = "o_seq")
    var oSeq: Long?=null,

    @Column(name = "of_seq")
    var ofSeq: Long?=null,

    @Column(name = "fcm")
    val fcm: String,


    @Column(name = "notice")
    @Enumerated(EnumType.STRING)
    val notice: holderState,

    @Column(name = "vote")
    @Enumerated(EnumType.STRING)
    val vote: holderState,

    @Column(name = "complaint")
    @Enumerated(EnumType.STRING)
    val complaint: holderState,

    @Column(name = "car")

    @Enumerated(EnumType.STRING)
    val car: holderState,

    @Column(name = "move")
    @Enumerated(EnumType.STRING)
    val move: holderState,
    @Column(name = "interior")
    @Enumerated(EnumType.STRING)
    val interior: holderState,

    @Column(name = "community")
    @Enumerated(EnumType.STRING)
    val community: holderState,



) {
    enum class sexState {
        남,
        여,
        미입력
    }

    enum class holderState {
        Y,
        N
    }
}