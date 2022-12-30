package com.realdealbatch.entity
import javax.persistence.*

@Entity
@Table(name ="TB_occfm")
data class OccFm(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq : Long? = null,
    @Column(name = "o_seq")
    var OSeq: Long?=null,
    @Column(name = "is_holder")
    @Enumerated(EnumType.STRING)
    val isHolder: holderState,

    @Column(name = "relation")
    val relation: String,

    @Column(name = "name")
    val name: String = "",
    @Column(name = "birth")
    val birth: String = "",
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    val sex: sexState,
    @Column(name = "phone")
    val phone: String,
    @Column(name = "company")
    val company: String = "",
    @Column(name = "aso")
    val aso: String = ""



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