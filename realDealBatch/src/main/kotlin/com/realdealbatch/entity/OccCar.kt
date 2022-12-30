package com.realdealbatch.entity
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name ="TB_car_occ")
data class OccCar(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq : Long? = null,


    @Column(name = "ho_seq")
    val hoSeq: Long,

    @Column(name = "of_seq")
    val ofSeq: Long,

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    val state: houseState,

    @Column(name = "car_apy_day")
    val carApyDay: LocalDate,

    @Column(name = "car_num1")
    val carNum1: String,
    @Column(name = "car_num2")
    val carNum2: String,

    @Column(name = "car_kind")
    val carKind: String,

    @Column(name = "car_reg_day")
    val carRegDay: LocalDate,

    @Column(name = "car_reg_doc")
    val carRegDoc: String,

    @Column(name = "rej_reason")
    val rejReason: String
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