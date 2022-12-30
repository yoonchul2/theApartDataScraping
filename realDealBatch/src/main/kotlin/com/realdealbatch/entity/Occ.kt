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
        ����,

        ��û,

        ����
    }

    enum class state2{
        ����,

        ������,

        ���
    }
    enum class houseState {
        �ڰ�,
        ����,
        �Ӵ�,
        �������ǹ����,
        ���������,
        ��Ÿ
    }

    enum class rejectState {
        ȸ������,
        ����������,
        ��������,
        ��������,
        ��������
    }
}