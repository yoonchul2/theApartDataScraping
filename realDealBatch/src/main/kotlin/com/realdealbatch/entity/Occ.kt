package com.realdealbatch.entity
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name ="TB_occ")
data class Occ(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq : Long? = null,


    @Column(name = "ho_seq")
    val hoSeq: Long,


    @Column(name = "import_day")
    val importDay: LocalDate,

    @Column(name = "export_day")
    val exportDay: LocalDate?=null,

    @Enumerated(EnumType.STRING)
    @Column(name = "house_kind")
    val houseKind: houseState?=null,
    @Column(name = "house_tel")
    val houseTel: String,
    @Column(name = "memo")
    val memo: String,
    @Column(name = "reject")
    val reject: String?=null,

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    val state: state1?=null,
    @Column(name = "create_at")
    val createAt: LocalDateTime,

    @Column(name = "reject_step")
    @Enumerated(EnumType.STRING)
    val rejectStep: rejectState?=null,





)
{


    enum class state1 {
        입주,

        신청,

        거절
    }

    enum class state2{
        입주,

        미입주,

        퇴거
    }
    enum class houseState {
        자가,
        전세,
        임대,
        소유자의배우자,
        직계존비속,
        기타
    }

    enum class rejectState {
        회원가입,
        세대주정보,
        가족사항,
        차량정보,
        소유정보
    }
}