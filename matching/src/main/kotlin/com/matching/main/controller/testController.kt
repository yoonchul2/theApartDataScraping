package com.matching.main.controller


import com.matching.main.entity.Martdjy08
import com.matching.main.service.BatchService
import com.matching.main.service.userService
import com.realdealbatch.query.batchQuery

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.channels.Channels
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets


@RestController
@RequestMapping("test")
class testController {

    @Autowired
    lateinit var userService : userService




    @Value("\${etc.data.file}")
    lateinit var file: String


    @Autowired
    lateinit var  jdbcTemplate: JdbcTemplate

    @Autowired
    lateinit var  batchService: BatchService



    @PostMapping("/insert06")
    fun insert06(): MutableList<Any>? {
        var fileList: MutableList<Any> = mutableListOf()
        val path = File(file)
        val fileArr: Array<File> = path.listFiles()
        var test : String? = ""

        for (file in fileArr) {
            test = file.canonicalPath.toString() + File.separator.toString()
            fileList.add(test)
        }
        kotlin.runCatching {
            //쿼리실행
            batchService.insert06(test!!)
        }.onFailure {
            it.printStackTrace()
        }.onSuccess {
            println(it)
        }

        return  fileList
    }

    @PostMapping("/update06")
    fun update06(): MutableList<Any>? {
        var fileList: MutableList<Any> = mutableListOf()
        val path = File(file)
        val fileArr: Array<File> = path.listFiles()
        var test : String? = ""

        for (file in fileArr) {
            test = file.canonicalPath.toString() + File.separator.toString()
            fileList.add(test)
        }
        kotlin.runCatching {
            //쿼리실행
            batchService.update06(test!!)
        }.onFailure {
            it.printStackTrace()
        }.onSuccess {
            println(it)
        }

        return  fileList
    }

    @PostMapping("/insert08")
    fun insert08(): MutableList<Any>? {
        var fileList: MutableList<Any> = mutableListOf()
        val path = File(file)
        val fileArr: Array<File> = path.listFiles()
        var test : String? = ""

        for (file in fileArr) {
            test = file.canonicalPath.toString() + File.separator.toString()
            fileList.add(test)
        }
        kotlin.runCatching {
            //쿼리실행
            batchService.insert08(test!!)
        }.onFailure {
            it.printStackTrace()
        }.onSuccess {
            println(it)
        }

        return  fileList
    }

    @PostMapping("/update08")
    fun update08(): MutableList<Any>? {
        var fileList: MutableList<Any> = mutableListOf()
        val path = File(file)
        val fileArr: Array<File> = path.listFiles()
        var test : String? = ""

        for (file in fileArr) {
            test = file.canonicalPath.toString() + File.separator.toString()
            fileList.add(test)
        }
        kotlin.runCatching {
            //쿼리실행
            batchService.update08(test!!)
        }.onFailure {
            it.printStackTrace()
        }.onSuccess {
            println(it)
        }

        return  fileList
    }
    @PostMapping("/sss")
    fun testss(): MutableList<Any>? {

        var fileList: MutableList<Any> = mutableListOf()

        println(file)
        val path = File(file)
        println(path)
        val fileArr: Array<File> = path.listFiles()
        println(fileArr[0])

        var test : String? = ""

        for (file in fileArr) {
                     test = file.canonicalPath.toString() + File.separator.toString()

                    println("--------")
                    println(test)
                    fileList.add(test)


        }

        val content = readFile(test!!, StandardCharsets.UTF_8)
        println(content)
        return  fileList
    }



    fun readFile(path: String, encoding: Charset): Array<Martdjy08> {
        val file = File(path)
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
        System.out.println("-------------------------")
        System.out.println(data2)
        System.out.println("-------------------------")

        val stringArr = list.toTypedArray()
        return stringArr
    }
}
