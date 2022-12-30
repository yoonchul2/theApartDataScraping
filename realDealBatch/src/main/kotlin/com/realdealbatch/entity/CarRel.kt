package com.realdealbatch.entity
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name ="TB_car_rel")
data class CarRel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq : Long? = null,


    @Column(name = "ho_seq")
    val hoSeq: Long,

    @Column(name = "reg_dt")
    val regDt: LocalDate,

    @Column(name = "end_dt")
    val endDt: LocalDate? = null,


    @Column(name = "car_num1")
    val carNum1: String,
    @Column(name = "car_num2")
    val carNum2: String,

    @Column(name = "car_kind")
    val carKind: String,

    @Column(name = "car_owner")
    val carOwner: String,


    @Column(name = "car_phone")
    val carPhone: String,

    @Column(name = "memo")
    val memo: String
    )
{

    enum class houseState {
        등록,
        변경,
        삭제,
        승인,
        거절
    }
}