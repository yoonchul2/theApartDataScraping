package com.realdealbatch.entity
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name ="TB_dong")
data class Dong(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq : Long? = null,

    @Column(name = "dong_num")
    val dongNum: String,

    @Column(name = "house_total")
    val houseTotal: String





)