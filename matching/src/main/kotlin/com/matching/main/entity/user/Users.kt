package com.matching.main.entity.user


import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name ="users")
data class Users(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idx")
        val idx: Long? = null,

        val id : String,

        val lastAccess : LocalDateTime = LocalDateTime.now()


) {
        companion object {
                fun builder(): Any {
                        return Users
                }
        }
}
