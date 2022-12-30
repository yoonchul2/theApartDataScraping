package com.realdealbatch.entity
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name ="TB_ho")
@NoArgsConstructor
data class Ho(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq : Long? = null,
    @Column(name = "d_seq")
    val DSeq: Long?=null,
    @Column(name = "l_seq")
    val LSeq: Long,
    @Column(name = "ho_num")
    val hoNum: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "import_kind")
    var importKind: States = States.N,



)
{

    enum class States {
        Y, N
    }
}