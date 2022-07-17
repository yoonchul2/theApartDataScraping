package com.matching.main.service

import com.matching.main.entity.Martdjy06
import com.matching.main.entity.Martdjy08
import com.realdealbatch.query.batchQuery
import lombok.extern.log4j.Log4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.math.BigDecimal


@Service
@Log4j
class BatchServiceImpl : BatchService {


    @Autowired
    lateinit var  jdbcTemplate: JdbcTemplate



    override fun insert06(file: String): String {
        val ind = BufferedReader(FileReader(file))
        var str: String? = ""
        var list: MutableList<Martdjy06> = mutableListOf()
        var data: MutableList<String> = mutableListOf()
        do {
            if (str != "") {
                data = str?.split("|") as MutableList<String>
                list.add(
                    Martdjy06(
                        bldgPk = data[0],
                        bldgDivCd = data[1],
                        bldgDivNm = data[2],
                        bldgKindCd = data[3],
                        bldgKindNm = data[4],
                        address = data[5],
                        addressDoro = data[6],
                        bldgNm = data[7],
                        sigunguCd = data[8],
                        dongCd = data[9],
                        landDivCd = data[10],
                        bun = data[11],
                        ji = data[12],
                        specialLandNm = data[13],
                        block = data[14],
                        lot = data[15],
                        addressDoroCd = data[16],
                        addressDoroLawdCd = data[17],
                        addressDoroUpdownCd = data[18],
                        addressDoroBun = data[19],
                        addressDoroJi = data[20],
                        bldgDongNm = data[21],
                        bldgHoNm = data[22],
                        floorDivCd = data[23],
                        floorDivNm = data[24],
                        floorNum = BigDecimal(data[25]),
                        extentDivCd = data[26],
                        extentDivNm = data[27],
                        mainStrcCd = data[28],
                        mainStrcNm = data[29],
                        floorNumNm = data[30],
                        strcCd = data[31],
                        strcNm = data[32],
                        etcStrcNm = data[33],
                        mainUseCd = data[34],
                        mainUseNm = data[35],
                        etcUseNm = data[36],
                        extent = BigDecimal(data[37]),
                        createDt = data[38]
                    )
                )
                println("size:" + list.size)
                if (list.size == 100000) {
                    batchQuery(jdbcTemplate).insert06(list)
                    list = mutableListOf()
                }
            }
        } while (ind.readLine().also { str = it } != null)
        ind.close()
        batchQuery(jdbcTemplate).insert06(list)

        val string = "성공"
        return string
    }

    override fun insert08(file: String): String {
        val ind = BufferedReader(FileReader(file))
        var str: String? = ""
        var list: MutableList<Martdjy08> = mutableListOf()
        var data2: MutableList<String> = mutableListOf()
        var data : MutableList<String> = mutableListOf()
        do{
            if(str != "") {
                data = str?.split("|") as MutableList<String>

                if(data[20] == ""){
                    data[20] = "0"
                }
                if(data[21] == ""){
                    data[21] = "0"
                }
                list.add(
                    Martdjy08(
                        bldgPk = data[0],
                        bldgDivCd = data[1],
                        bldgDivNm =  data[2],
                        bldgKindCd = data[3],
                        bldgKindNm = data[4],
                        address = data[5],
                        addressDoro = data[6],
                        bldgNm = data[7],
                        sigunguCd = data[8],
                        dongCd = data[9],
                        landDivCd = data[10],
                        bun = data[11],
                        ji = data[12],
                        specialLandNm = data[13],
                        block = data[14],
                        lot = data[15],
                        etcLandNum = data[16].toInt(),
                        addressDoroCd = data[17],
                        addressDoroLawdCd = data[18],
                        addressDoroUpdownCd = data[19],
                        addressDoroBun = data[20].toInt(),
                        addressDoroJi = data[21].toInt(),
                        standardDt = data[22],
                        price = data[23].toBigDecimal(),
                        createDt = data[24]
                    )
                )
            }
            println("size:" + list.size)
            if(list.size == 100000){
                batchQuery(jdbcTemplate).insert08(list)
                list = mutableListOf()
            }

        } while (ind.readLine().also { str = it } != null)
        ind.close()
        batchQuery(jdbcTemplate).insert08(list)
//        System.out.println("-------------------------")
//        System.out.println(data2)
//        System.out.println("-------------------------")

        val stringArr = "성공"
        return stringArr
    }

    override fun update08(file: String): String {
        TODO("Not yet implemented")
    }

    override fun update06(file: String): String {
        val ind = BufferedReader(FileReader(file))
        var str: String? = ""
        var list: MutableList<Martdjy06> = mutableListOf()
        var data: MutableList<String> = mutableListOf()
        do {
            if (str != "") {
                data = str?.split("|") as MutableList<String>
                list.add(
                    Martdjy06(
                        bldgPk = data[0],
                        bldgDivCd = data[1],
                        bldgDivNm = data[2],
                        bldgKindCd = data[3],
                        bldgKindNm = data[4],
                        address = data[5],
                        addressDoro = data[6],
                        bldgNm = data[7],
                        sigunguCd = data[8],
                        dongCd = data[9],
                        landDivCd = data[10],
                        bun = data[11],
                        ji = data[12],
                        specialLandNm = data[13],
                        block = data[14],
                        lot = data[15],
                        addressDoroCd = data[16],
                        addressDoroLawdCd = data[17],
                        addressDoroUpdownCd = data[18],
                        addressDoroBun = data[19],
                        addressDoroJi = data[20],
                        bldgDongNm = data[21],
                        bldgHoNm = data[22],
                        floorDivCd = data[23],
                        floorDivNm = data[24],
                        floorNum = BigDecimal(data[25]),
                        extentDivCd = data[26],
                        extentDivNm = data[27],
                        mainStrcCd = data[28],
                        mainStrcNm = data[29],
                        floorNumNm = data[30],
                        strcCd = data[31],
                        strcNm = data[32],
                        etcStrcNm = data[33],
                        mainUseCd = data[34],
                        mainUseNm = data[35],
                        etcUseNm = data[36],
                        extent = BigDecimal(data[37]),
                        createDt = data[38]
                    )
                )
                println("size:" + list.size)
                if (list.size == 100000) {
                    batchQuery(jdbcTemplate).update06(list)
                    list = mutableListOf()
                }
            }
        } while (ind.readLine().also { str = it } != null)
        ind.close()
        batchQuery(jdbcTemplate).update06(list)

        val string = "성공"
        return string
    }

}