package com.realdealbatch.query

import com.matching.main.entity.Martdjy03
import com.matching.main.entity.Martdjy04
import com.matching.main.entity.Martdjy06
import com.matching.main.entity.Martdjy08
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

class batchQuery( private val jdbcTemplate: JdbcTemplate) {


    fun insert06(list: MutableList<Martdjy06>){
        runBlocking {
            jdbcTemplate.batchUpdate(
                "insert into mart_djy_06 (bldg_pk, bldg_div_cd, bldg_div_nm, bldg_kind_cd, bldg_kind_nm, address, address_doro, bldg_nm, sigungu_cd, dong_cd, land_div_cd, bun, ji, special_land_nm, block, lot, address_doro_cd, address_doro_lawd_cd, address_doro_updown_cd, address_doro_bun, address_doro_ji, bldg_dong_nm, bldg_ho_nm, floor_div_cd, floor_div_nm, floor_num, extent_div_cd, extent_div_nm, main_strc_cd, main_strc_nm, floor_num_nm, strc_cd, strc_nm, etc_strc_nm, main_use_cd, main_use_nm, etc_use_nm, extent, create_dt) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", // bulk insert에 사용할 기본 쿼리
                list, // insert할 모델
                100 // 1번의 batch로 함께 insert할 batch 사이즈
            ) { ps, argument ->
                ps.setString(1, argument.bldgPk)
                ps.setString(2, argument.bldgDivCd)
                ps.setString(3, argument.bldgDivNm)
                ps.setString(4, argument.bldgKindCd)
                ps.setString(5, argument.bldgKindNm)
                ps.setString(6, argument.address)
                ps.setString(7, argument.addressDoro)
                ps.setString(8, argument.bldgNm)
                ps.setString(9, argument.sigunguCd)
                ps.setString(10, argument.dongCd)
                ps.setString(11, argument.landDivCd)
                ps.setString(12, argument.bun)
                ps.setString(13, argument.ji)
                ps.setString(14, argument.specialLandNm)
                ps.setString(15, argument.block)
                ps.setString(16, argument.lot)
                ps.setString(17, argument.addressDoroCd)
                ps.setString(18, argument.addressDoroLawdCd)
                ps.setString(19, argument.addressDoroUpdownCd)
                ps.setString(20, argument.addressDoroBun)
                ps.setString(21, argument.addressDoroJi)
                ps.setString(22, argument.bldgDongNm)
                ps.setString(23, argument.bldgHoNm)
                ps.setString(24, argument.floorDivCd)
                ps.setString(25, argument.floorDivNm)
                ps.setBigDecimal(26, argument.floorNum)
                ps.setString(27, argument.extentDivCd)
                ps.setString(28, argument.extentDivNm)
                ps.setString(29, argument.mainStrcCd)
                ps.setString(30, argument.mainStrcNm)
                ps.setString(31, argument.floorNumNm)
                ps.setString(32, argument.strcCd)
                ps.setString(33, argument.strcNm)
                ps.setString(34, argument.etcStrcNm)
                ps.setString(35, argument.mainUseCd)
                ps.setString(36, argument.mainUseNm)
                ps.setString(37, argument.etcUseNm)
                ps.setBigDecimal(38, argument.extent)
                ps.setString(39,argument.createDt)



            }
        }
    }

    fun insert08(list: MutableList<Martdjy08>){
        runBlocking {
            jdbcTemplate.batchUpdate(
                "insert into mart_djy_08 (bldg_pk, bldg_div_cd, bldg_div_nm, bldg_kind_cd, bldg_kind_nm, address, address_doro, bldg_nm, sigungu_cd, dong_cd, land_div_cd, bun, ji, special_land_nm, block, lot, etc_land_num, address_doro_cd, address_doro_lawd_cd, address_doro_updown_cd, address_doro_bun, address_doro_ji, standard_dt, price, create_dt) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", // bulk insert에 사용할 기본 쿼리
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
                ps.setString(23, argument.standardDt)
                ps.setBigDecimal(24,argument.price)
                ps.setString(25,argument.createDt)



            }
        }
    }

    fun insert03(list: MutableList<Martdjy03>){
        runBlocking {
            jdbcTemplate.batchUpdate(
                "insert into mart_djy_03 (bldg_pk,bldg_div_cd,bldg_div_nm,bldg_kind_cd,bldg_kind_nm,address,address_doro,bldg_nm,sigungu_cd,dong_cd,land_div_cd,bun,ji,special_land_nm,block,lot,etc_land_num,address_doro_cd,address_doro_lawd_cd,address_doro_updown_cd,address_doro_bun,address_doro_ji,bldg_dong_nm,main_strc_cd,main_strc_nm,platArea,archArea,bcRat,totArea,vlRatEstmTotArea,vlRat,strc_cd,strc_nm,etc_strc_nm,main_use_cd,main_use_nm,etc_use_nm,roofCd,roofCdNm,etcRoof,hhldCnt,fmlyCnt,heit,grndFlrCnt,ugrndFlrCnt,rideUseElvtCnt,emgenUseElvtCnt,atchBldCnt,atchBldArea,totDongTotArea,indrMechUtcnt,indrMechArea,oudrMechUtcnt,oudrMechArea,indrAutoUtcnt,indrAutoArea,oudrAutoUtcnt,oudrAutoArea,pmsDay,stcnsDay,useAprDay,pmsnoYear,pmsnoKikCd,pmsnoKikCdNm,pmsnoGbCd,pmsnoGbCdNm,hoCnt,engrGrade,engrRat,engrEpi,gnBldGrade,gnBldCert,itgBldGrade,itgBldCert,create_dt,rserthqkDsgnApplyYn,rserthqkAblty) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", // bulk insert에 사용할 기본 쿼리
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
                ps.setInt(17,argument.etcLandNum)
                ps.setString(18,argument.addressDoroCd)
                ps.setString(19,argument.addressDoroLawdCd)
                ps.setString(20,argument.addressDoroUpdownCd)
                ps.setInt(21,argument.addressDoroBun)
                ps.setInt(22,argument.addressDoroJi)
                ps.setString(23,argument.bldgDongNm)
                ps.setString(24,argument.mainStrcCd)
                ps.setString(25,argument.mainStrcNm)
                ps.setBigDecimal(26,argument.platArea)
                ps.setBigDecimal(27,argument.archArea)
                ps.setBigDecimal(28,argument.bcRat)
                ps.setBigDecimal(29,argument.totArea)
                ps.setBigDecimal(30,argument.vlRatEstmTotArea)
                ps.setBigDecimal(31,argument.vlRat)
                ps.setString(32,argument.strcCd)
                ps.setString(33,argument.strcNm)
                ps.setString(34,argument.etcStrcNm)
                ps.setString(35,argument.mainUseCd)
                ps.setString(36,argument.mainUseNm)
                ps.setString(37,argument.etcUseNm)
                ps.setString(38,argument.roofCd)
                ps.setString(39,argument.roofCdNm)
                ps.setString(40,argument.etcRoof)
                ps.setInt(41,argument.hhldCnt)
                ps.setInt(42,argument.fmlyCnt)
                ps.setBigDecimal(43,argument.heit)
                ps.setInt(44,argument.grndFlrCnt)
                ps.setInt(45,argument.ugrndFlrCnt)
                ps.setInt(46,argument.rideUseElvtCnt)
                ps.setInt(47,argument.emgenUseElvtCnt)
                ps.setInt(48,argument.atchBldCnt)
                ps.setBigDecimal(49,argument.atchBldArea)
                ps.setBigDecimal(50,argument.totDongTotArea)
                ps.setInt(51,argument.indrMechUtcnt)
                ps.setBigDecimal(52,argument.indrMechArea)
                ps.setInt(53,argument.oudrMechUtcnt)
                ps.setBigDecimal(54,argument.oudrMechArea)
                ps.setInt(55,argument.indrAutoUtcnt)
                ps.setBigDecimal(56,argument.indrAutoArea)
                ps.setInt(57,argument.oudrAutoUtcnt)
                ps.setBigDecimal(58,argument.oudrAutoArea)
                ps.setString(59,argument.pmsDay)
                ps.setString(60,argument.stcnsDay)
                ps.setString(61,argument.useAprDay)
                ps.setString(62,argument.pmsnoYear)
                ps.setString(63,argument.pmsnoKikCd)
                ps.setString(64,argument.pmsnoKikCdNm)
                ps.setString(65,argument.pmsnoGbCd)
                ps.setString(66,argument.pmsnoGbCdNm)
                ps.setInt(67,argument.hoCnt)
                ps.setString(68,argument.engrGrade)
                ps.setBigDecimal(69,argument.engrRat)
                ps.setInt(70,argument.engrEpi)
                ps.setString(71,argument.gnBldGrade)
                ps.setInt(72,argument.gnBldCert)
                ps.setString(73,argument.itgBldGrade)
                ps.setInt(74,argument.itgBldCert)
                ps.setString(75,argument.createDt)
                ps.setString(76,argument.rserthqkDsgnApplyYn)
                ps.setString(77,argument.rserthqkAblty)

            }
        }
    }


    fun insert04(list: MutableList<Martdjy04>){
        runBlocking {
            jdbcTemplate.batchUpdate(
                "insert into mart_djy_04 (bldg_pk,address,address_doro,bldg_nm,sigungu_cd,dong_cd,land_div_cd,bun,ji,special_land_nm,block,lot,address_doro_cd,address_doro_lawd_cd,address_doro_updown_cd,address_doro_bun,address_dofo_ji,bldg_dong_nm,floor_div_cd,floor_div_nm,floor_num,floor_num_nm,strc_cd,strc_nm,etc_strc_nm,main_use_cd,main_use_nm,etc_use_nm,extent,main_strc_cd,main_strc_nm,areaExctYn,create_dt) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", // bulk insert에 사용할 기본 쿼리
                list, // insert할 모델
                100000 // 1번의 batch로 함께 insert할 batch 사이즈
            ) { ps, argument ->
                ps.setString(1, argument.bldgPk)
                ps.setString(2,argument.address)
                ps.setString(3,argument.addressDoro)
                ps.setString(4,argument.bldgNm)
                ps.setString(5,argument.sigunguCd)
                ps.setString(6,argument.dongCd)
                ps.setString(7,argument.landDivCd)
                ps.setString(8,argument.bun)
                ps.setString(9,argument.ji)
                ps.setString(10,argument.specialLandNm)
                ps.setString(11,argument.block)
                ps.setString(12,argument.lot)
                ps.setString(13,argument.addressDoroCd)
                ps.setString(14,argument.addressDoroLawdCd)
                ps.setString(15,argument.addressDoroUpdownCd)
                ps.setInt(16,argument.addressDoroBun)
                ps.setInt(17,argument.addressDoroJi)
                ps.setString(18,argument.bldgDongNM)
                ps.setString(19,argument.floorDivCd)
                ps.setString(20,argument.floorDivNm)
                ps.setInt(21,argument.floorNum)
                ps.setString(22,argument.floorNumNm)
                ps.setString(23,argument.strcCd)
                ps.setString(24,argument.strcNm)
                ps.setString(25,argument.etcStrcNm)
                ps.setString(26,argument.mainUseCd)
                ps.setString(27,argument.mainUseNm)
                ps.setString(28,argument.etcUseNm)
                ps.setBigDecimal(29,argument.extent)
                ps.setString(30,argument.mainStrcCd)
                ps.setString(31,argument.mainStrcNm)
                ps.setString(32,argument.areaExctYn)
                ps.setString(33,argument.createDt)

            }
        }
    }



}