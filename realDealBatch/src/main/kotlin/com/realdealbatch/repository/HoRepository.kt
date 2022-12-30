package com.realdealbatch.repository



import com.realdealbatch.entity.Ho
import org.springframework.data.jpa.repository.JpaRepository


interface HoRepository  : JpaRepository<Ho, Long> {

//    fun findHoByHoNumAndDSeq(ho: String,dSeq :Long) : Ho
    fun findHoByHoNum(ho: String) : Ho
    fun findHoBySeqAndHoNum(dseq:Long,ho: String) : Ho
    fun findHoByDSeqAndHoNum(dseq:Long,ho: String) : Ho
}