package com.example.bbl.entity


import javax.persistence.*

@Entity
@Table(name ="user")
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idx")
        val idx: Long? =null,

        val userId : String


)
