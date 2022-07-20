package com.matching.main.service

import com.matching.main.entity.*
import com.realdealbatch.query.batchQuery
import lombok.extern.log4j.Log4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.io.BufferedReader
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
                        bun = ((data[11]).toInt()*1).toString(),
                        ji = ((data[12]).toInt()*1).toString(),
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
                        bun = ((data[11].toInt())*1).toString(),
                        ji = ((data[12].toInt())*1).toString(),
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


    override fun insert03(file: String): String {
        val ind = BufferedReader(FileReader(file))
        var str: String? = ""
        var list: MutableList<Martdjy03> = mutableListOf()
        var data: MutableList<String> = mutableListOf()
        do {
            if (str != "") {
                data = str?.split("|") as MutableList<String>
                list.add(
                    Martdjy03(
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
                        etcLandNum = data[16].toInt(),
                        addressDoroCd = data[17],
                        addressDoroLawdCd = data[18],
                        addressDoroUpdownCd = data[19],
                        addressDoroBun = data[20].toInt(),
                        addressDoroJi = data[21].toInt(),
                        bldgDongNm = data[22],
                        mainStrcCd = data[23],
                        mainStrcNm = data[24],
                        platArea = data[25].toBigDecimal(),
                        archArea = data[26].toBigDecimal(),
                        bcRat = data[27].toBigDecimal(),
                        totArea = data[28].toBigDecimal(),
                        vlRatEstmTotArea = data[29].toBigDecimal(),
                        vlRat = data[30].toBigDecimal(),
                        strcCd = data[31],
                        strcNm = data[32],
                        etcStrcNm = data[33],
                        mainUseCd = data[34],
                        mainUseNm = data[35],
                        etcUseNm = data[36],
                        roofCd = data[37],
                        roofCdNm = data[38],
                        etcRoof = data[39],
                        hhldCnt = data[40].toInt(),
                        fmlyCnt = data[41].toInt(),
                        heit = data[42].toBigDecimal(),
                        grndFlrCnt = data[43].toInt(),
                        ugrndFlrCnt = data[44].toInt(),
                        rideUseElvtCnt = data[45].toInt(),
                        emgenUseElvtCnt = data[46].toInt(),
                        atchBldCnt = data[47].toInt(),
                        atchBldArea = data[48].toBigDecimal(),
                        totDongTotArea = data[49].toBigDecimal(),
                        indrMechUtcnt = data[50].toInt(),
                        indrMechArea = data[51].toBigDecimal(),
                        oudrMechUtcnt = data[52].toInt(),
                        oudrMechArea = data[53].toBigDecimal(),
                        indrAutoUtcnt = data[54].toInt(),
                        indrAutoArea = data[55].toBigDecimal(),
                        oudrAutoUtcnt = data[56].toInt(),
                        oudrAutoArea = data[57].toBigDecimal(),
                        pmsDay = data[58],
                        stcnsDay = data[59],
                        useAprDay = data[60],
                        pmsnoYear = data[61],
                        pmsnoKikCd = data[62],
                        pmsnoKikCdNm = data[63],
                        pmsnoGbCd = data[64],
                        pmsnoGbCdNm = data[65],
                        hoCnt = data[66].toInt(),
                        engrGrade = data[67],
                        engrRat = data[68].toBigDecimal(),
                        engrEpi = data[69].toInt(),
                        gnBldGrade = data[70],
                        gnBldCert = data[71].toInt(),
                        itgBldGrade = data[72],
                        itgBldCert = data[73].toInt(),
                        createDt = data[74],
                        rserthqkDsgnApplyYn = data[75],
                        rserthqkAblty = data[76]

                )
                )
                println("size:" + list.size)
                if (list.size == 10000) {
                    batchQuery(jdbcTemplate).insert03(list)
                    list = mutableListOf()
                }
            }
        } while (ind.readLine().also { str = it } != null)
        ind.close()
        batchQuery(jdbcTemplate).insert03(list)

        val string = "성공"
        return string
    }

    override fun insert04(file: String): String {
        val ind = BufferedReader(FileReader(file))
        var str: String? = ""
        var list: MutableList<Martdjy04> = mutableListOf()
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
                    Martdjy04(
                        bldgPk=data[0],
                        address=data[1],
                        addressDoro=data[2],
                        bldgNm=data[3],
                        sigunguCd=data[4],
                        dongCd=data[5],
                        landDivCd=data[6],
                        bun=data[7],
                        ji=data[8],
                        specialLandNm=data[9],
                        block=data[10],
                        lot=data[11],
                        addressDoroCd=data[12],
                        addressDoroLawdCd=data[13],
                        addressDoroUpdownCd=data[14],
                        addressDoroBun=data[15].toInt(),
                        addressDoroJi=data[16].toInt(),
                        bldgDongNM=data[17],
                        floorDivCd=data[18],
                        floorDivNm=data[19],
                        floorNum=data[20].toInt(),
                        floorNumNm=data[21],
                        strcCd=data[22],
                        strcNm=data[23],
                        etcStrcNm=data[24],
                        mainUseCd=data[25],
                        mainUseNm=data[26],
                        etcUseNm=data[27],
                        extent=data[28].toBigDecimal(),
                        mainStrcCd=data[29],
                        mainStrcNm=data[30],
                        areaExctYn=data[31],
                        createDt=data[32]
                    )
                )
            }
            println("size:" + list.size)
            if(list.size == 10000){
                batchQuery(jdbcTemplate).insert04(list)
                list = mutableListOf()
            }

        } while (ind.readLine().also { str = it } != null)
        ind.close()
        batchQuery(jdbcTemplate).insert04(list)

        val stringArr = "성공"
        return stringArr
    }



    override fun insertBuildMapperTemp(){
       var tempSelectData : MutableList<BuildMapperTemp> =  batchQuery(jdbcTemplate).selectBuildMapper()
        var listData : MutableList<BuildMapperTemp> = mutableListOf()

        tempSelectData.forEach{ data ->
            listData.add(data)
            println("size: ${listData.size}")
            if(listData.size == 100000){
                batchQuery(jdbcTemplate).insertBuildMapper(listData)
                listData = mutableListOf()
            }
        }
        batchQuery(jdbcTemplate).insertBuildMapper(listData)

        println("fin!")
 //       return batchQuery(jdbcTemplate).selectBuildMapper()

    }



}