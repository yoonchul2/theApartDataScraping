package com.matching.main.entity

import javax.persistence.*

@Entity
@Table(name ="real_deal")
data class RealDeal(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idx")
    val idx: Long? = null,

    @Column(length = 50)
    val realContractType : String


)
