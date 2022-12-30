package com.realdealbatch.entity
import lombok.NoArgsConstructor
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name ="TB_line")
data class line(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq : Long? = null,
    @Column(name = "d_seq")
    val dSeq: Long,
    @Column(name = "line")
    val line: String,
    @Column(name = "stair_start")
    val stairStart : Long,
    @Column(name = "stair_end")
    val stairEnd : Long,

    @Column(name = "ho_start")
    val hoStart : Float,

    @Column(name = "ho_end")
    val hoEnd : Float,
    @Column(name = "stair_type")
    val stairType : state1,

    @Column(name = "ho_type")
    val hoType : state1,

    @Column(name = "b_area")
    val bArea : Float,

    @Column(name = "j_area")
    val jArea : Float,





)
{

    enum class state1 {
        Y,

        N
    }

}