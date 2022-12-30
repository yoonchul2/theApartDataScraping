package com.realdealbatch

import com.realdealbatch.entity.Occ
import com.realdealbatch.entity.OccExpenses
import com.realdealbatch.entity.OccFcm
import com.realdealbatch.entity.OccFm
import com.realdealbatch.repository.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.dhatim.fastexcel.Workbook
import org.dhatim.fastexcel.reader.Cell
import org.dhatim.fastexcel.reader.ReadableWorkbook
import org.dhatim.fastexcel.reader.Row
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.streams.toList

@SpringBootTest
class RealDealBatchApplicationTests {

    @Test
    fun contextLoads() {

        var fileList: MutableList<Any> = mutableListOf()
        val path = File("C:/Users/mrsbok/Downloads/A08897_202211_Man2070 (1).txt")
//        val fileArr: Array<File> = path.listFiles()
        var test : String? = ""

        val reader = BufferedReader(FileReader(path, Charsets.UTF_8))
        var ii = 0;
        var iix = 0;
        var list : MutableList<Int> = mutableListOf()
        reader.lines().forEach {

            when(it){
                "<mangoji>" -> list.add(ii)
                "<manjojeong>" -> list.add(ii)
            }

            ii++
        }
        reader.lines().forEach {

         if(list[0] < iix && iix < list[1]){
            var list2 =  it.split("|")

             var data = OccExpenses()
         }
            iix++
        }


        println(list)
//        for (file in fileArr) {
//            test = file.canonicalPath.toString() + File.separator.toString()
//            fileList.add(test)
//        }

    }
    var occId : Long ?= null
    var hoIdx : Long ?= null
    var ofIdx : Long ?= null

    @Autowired
    lateinit var  hoRepository: HoRepository

    @Autowired
    lateinit var  dongRepository: DongRepository

    @Autowired
    lateinit var  lineRepository: LineRepository


    @Autowired
    lateinit var  occRepository: OccRepository

    @Autowired
    lateinit var  occFmRepository: OccFmRepository

    @Autowired
    lateinit var  occFcmRepository: OccFcmRepository

    @Autowired
    lateinit var  occCarRepository: OccCarRepository

    @Test
    fun teszzz() {
        var data = 0;
        val path = File("file/8897단지입주현황_6.xlsx")
        val workbook = XSSFWorkbook(path)
        var worksheet = workbook.getSheetAt(0)
        for (rowIndex in 0 until worksheet.physicalNumberOfRows) {
            println("---")
            println(rowIndex)
            println(rowIndex)
            println("---")
                val row = worksheet.getRow(rowIndex)
            println(row.getCell(0).stringCellValue)
            println(row)
                println(row.getCell(23).stringCellValue)
            var occ : Occ ?= null
            var occfcms : OccFcm?= null

            var occfm : OccFm ?= null
            var sex : OccFm.sexState ?= null

            if(row.getCell(23).stringCellValue == "세대주"){

                val dongId = dongRepository.findDongByDongNum(row.getCell(1).stringCellValue);


                val hoId = hoRepository.findHoByDSeqAndHoNum(dongId.seq!!,row.getCell(2).stringCellValue)
                println(hoId)
                hoIdx = hoId.seq
                occ = Occ(null,hoId.seq!!, LocalDate.now(), null
                    ,Occ.houseState.기타,row.getCell(12).stringCellValue
                    , "", null,Occ.state1.입주, LocalDateTime.now(),Occ.rejectState.가족사항)
//
//
                occId = occRepository.save(occ).seq
//            hoId.importKind = Ho.States.Y
//            hoRepository.save(hoId)


            }
            println("324234")

            if(row.getCell(0) != null){
                occfm = OccFm(null,occId,OccFm.holderState.N,row.getCell(23).stringCellValue ?: "",row.getCell(4).stringCellValue ?: "",
                    "", OccFm.sexState.미입력,row.getCell(12).stringCellValue ?: "" , "","")
                occFmRepository.save(occfm)

                occfcms = OccFcm(null,hoIdx,occId,occfm.seq,"",OccFcm.holderState.N,
                    OccFcm.holderState.N,
                    OccFcm.holderState.N,
                    OccFcm.holderState.N,
                    OccFcm.holderState.N,
                    OccFcm.holderState.N,
                    OccFcm.holderState.N)
                occFcmRepository.save(occfcms)
            }


        }

    }

    fun rowCellsToDataClass3(stream: Stream<Cell>) {
        println(stream)
        println(stream)
        println(stream)
        var occ : Occ ?= null
        var occfcms : OccFcm?= null

        var occfm : OccFm ?= null
        var sex : OccFm.sexState ?= null

        val cells = stream.toList()
        if(cells[23].value == "세대주"){
            println(cells)
            val dongId = dongRepository.findDongByDongNum(cells[1].rawValue);


            println(dongId)

            val hoId = hoRepository.findHoByDSeqAndHoNum(dongId.seq!!,cells[2].rawValue)
            println(hoId)
            hoIdx = hoId.seq
            occ = Occ(null,hoId.seq!!, LocalDate.now(), null
                ,Occ.houseState.기타,cells[12].value.toString()
                , "", null,Occ.state1.입주, LocalDateTime.now(),Occ.rejectState.가족사항)
//
//
            occId = occRepository.save(occ).seq
//            hoId.importKind = Ho.States.Y
//            hoRepository.save(hoId)


    }

        if(cells[0].value != null){
            occfm = OccFm(null,occId,OccFm.holderState.N,cells[23].value.toString() ?: "",cells[4].value.toString() ?: "",
                "", OccFm.sexState.미입력,cells[12].value.toString() ?: "" , "","")
            occFmRepository.save(occfm)

            occfcms = OccFcm(null,hoIdx,occId,occfm.seq,"",OccFcm.holderState.N,
                OccFcm.holderState.N,
                OccFcm.holderState.N,
                OccFcm.holderState.N,
                OccFcm.holderState.N,
                OccFcm.holderState.N,
                OccFcm.holderState.N)
            occFcmRepository.save(occfcms)
        }


    }
}
