package com.realdealbatch.query

import com.matching.main.entity.Martdjy06
import com.matching.main.entity.Martdjy08
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

class batchQuery( private val jdbcTemplate: JdbcTemplate) {


    fun insert06(list: MutableList<Martdjy06>){
        runBlocking {
            jdbcTemplate.batchUpdate(
                "insert into mart_djy_06 (address_doro,extent) values (?, ?)", // bulk insert에 사용할 기본 쿼리
                list, // insert할 모델
                100 // 1번의 batch로 함께 insert할 batch 사이즈
            ) { ps, argument ->
                ps.setString(1, argument.addressDoro)
                ps.setBigDecimal(2, argument.extent)
            }
        }
    }

    fun insert08(list: MutableList<Martdjy08>){
        runBlocking {
            jdbcTemplate.batchUpdate(
                "insert into mart_djy_08 (bldg_pk, bldg_div_cd, bldg_div_nm, bldg_kind_cd, bldg_kind_nm, address, address_doro, bldg_nm, sigungu_cd, dong_cd, land_div_cd, bun, ji, special_land_nm, block, lot, etc_land_num, address_doro_cd, address_doro_lawd_cd, address_doro_updown_cd, address_doro_bun, address_doro_ji, standard_dt, price, create_dt) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", // bulk insert에 사용할 기본 쿼리
                list, // insert할 모델
                100000 // 1번의 batch로 함께 insert할 batch 사이즈
            ) { ps, argument ->
                ps.setString(1, argument.bldgPk)
                ps.setString(2,argument.bldgDivCd)
                ps.setString(3,argument.bldgDivNm)
                ps.setString(4,argument.bldgKindCd)
                ps.setString(5,argument.bldgKindNm)
                ps.setString(6,argument.address)
                ps.setString(7,argument.addressDoro)
                ps.setString(8,argument.bldgNm)
                ps.setString(9,argument.sigunguCd)
                ps.setString(10,argument.dongCd)
                ps.setString(11,argument.landDivCd)
                ps.setString(12,argument.bun)
                ps.setString(13,argument.ji)
                ps.setString(14,argument.specialLandNm)
                ps.setString(15,argument.block)
                ps.setString(16,argument.lot)
                ps.setInt(17,argument?.etcLandNum!!)
                ps.setString(18,argument.addressDoroCd)
                ps.setString(19,argument.addressDoroLawdCd)
                ps.setString(20,argument.addressDoroUpdownCd)
                ps.setInt(21,argument?.addressDoroBun!!)
                ps.setInt(22,argument?.addressDoroJi!!)
                ps.setBigDecimal(23,argument.price)
                ps.setString(25,argument.createDt)


            }
        }
    }


    fun update06(list: MutableList<Martdjy06>){
        runBlocking {
            jdbcTemplate.batchUpdate(
                "update mart_djy_06 set bun = ? * 1, ji = ? *1", // bulk insert에 사용할 기본 쿼리
                list, // insert할 모델
                100000 // 1번의 batch로 함께 insert할 batch 사이즈
            ) { ps, argument ->
                ps.setString(1, argument.bun)
                ps.setString(2, argument.ji)

            }
        }
    }

    fun update08(list: MutableList<Martdjy06>){
        runBlocking {
            jdbcTemplate.batchUpdate(
                "update mart_djy_08 set bun = ? * 1, ji = ? *1", // bulk insert에 사용할 기본 쿼리
                list, // insert할 모델
                100000 // 1번의 batch로 함께 insert할 batch 사이즈
            ) { ps, argument ->
                ps.setString(1, argument.bun)
                ps.setString(2, argument.ji)

            }
        }
    }
}