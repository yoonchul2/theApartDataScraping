package com.matching.main.controller

import com.matching.main.entity.Martdjy06
import com.matching.main.model.UserForm
import com.matching.main.repository.RealDealRepository
import com.matching.main.service.userService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.*
import java.math.BigDecimal
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

    @Autowired
    lateinit var realDealRepository : RealDealRepository


    @Value("\${etc.data.file}")
    lateinit var file: String


    @Autowired
    lateinit var  jdbcTemplate: JdbcTemplate

    fun maxf2(a: Int, b: Int) = if(a > b) a else b

    @PostMapping("/ss")
    fun test(@RequestBody userForm: UserForm){
        println("userForm:")
        println("userForm:${userForm}")
        userService.userSave(userForm)
    }


    @PostMapping("/ssff")
    fun  test222() : String{
        return "성공임 ㅋㅋㅋㅋㅋ"
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
//        for (fullPath in fileList) {
//            println(testsss(realPath, fullPath))
//        }
        val content = readFile(test!!, StandardCharsets.UTF_8)
        println(content)
        return  fileList
    }

//    @PostMapping("/ssss")
//    fun testssd(): MutableList<Any>? {
//
////        for (0 < .. <){
////
////        }
//////        }
////        val content = readFile(test!!, StandardCharsets.UTF_8)
////        println(content)
////        return  fileList
//    }
    fun readFile(path: String, encoding: Charset): Array<Martdjy06> {
        val file = File(path)
//        val inp: InputStream = FileInputStream(file)
//        val bytes = ByteArray(file.length().toInt())
//        var offset = 0
//        while (offset < bytes.size) {
//            val result = inp.read(bytes, offset, bytes.size - offset)
//            if (result == -1) {
//                break
//            }
//            offset += result
//        }

        val ind = BufferedReader(FileReader(file))
        var str: String? = ""
        var list: MutableList<Martdjy06> = mutableListOf()
        var data : MutableList<String> = mutableListOf()
        do{
            if(str != "") {
                data = str?.split("|") as MutableList<String>

                list.add(
                    Martdjy06(
                        bldgPk = data[0],
                        bldgDivCd = data[1],
                        bldgDivNm =  data[2],
                        bldgKindCd = data[3],
                        bldgKindNm = data[4],
                        address = data[5],
                        addressDoro = data[6],
                        bldgNm = data[7],
                        sigunguCd = data[8],
                        dongCdd = data[9],
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
                        floorNum = BigDecimal(data[25]) ,
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
                data = mutableListOf()
                println("size:" + list.size)
                if(list.size == 100){

                    println("ddssgg${list.size}")
                    jdbcTemplate.batchUpdate(
                        "insert into mart_djy_06 (address_doro,extent) values (?, ?)", // bulk insert에 사용할 기본 쿼리
                        list, // insert할 모델
                        100 // 1번의 batch로 함께 insert할 batch 사이즈
                    ) { ps, argument ->
                        ps.setString(1,argument.addressDoro)
                        ps.setBigDecimal(2,argument.extent)

                    }
                    list = mutableListOf()
                    println("ddssggs${list.size}")
                }
            }
        } while (ind.readLine().also { str = it } != null)
        ind.close()

//        val listdata: ArrayList<Martdjy06?>  = object : ArrayList<Martdjy06?>()  {
//            init {
//                list.forEach{
//                    add(
//                        Martdjy06(
//                            bldgPk = i[0],
//                            bldgDivCd = data[1],
//                            bldgDivNm =  data[2],
//                            bldgKindCd = data[3],
//                            bldgKindNm = data[4],
//                            address = data[5],
//                            addressDoro = data[6],
//                            bldgNm = data[7],
//                            sigunguCd = data[8],
//                            dongCdd = data[9],
//                            landDivCd = data[10],
//                            bun = data[11],
//                            ji = data[12],
//                            specialLandNm = data[13],
//                            block = data[14],
//                            lot = data[15],
//                            addressDoroCd = data[16],
//                            addressDoroLawdCd = data[17],
//                            addressDoroUpdownCd = data[18],
//                            addressDoroBun = data[19],
//                            addressDoroJi = data[20],
//                            bldgDongNm = data[21],
//                            bldgHoNm = data[22],
//                            floorDivCd = data[23],
//                            floorDivNm = data[24],
//                            floorNum = BigDecimal(data[25]) ,
//                            extentDivCd = data[26],
//                            extentDivNm = data[27],
//                            mainStrcCd = data[28],
//                            mainStrcNm = data[29],
//                            floorNumNm = data[30],
//                            strcCd = data[31],
//                            strcNm = data[32],
//                            etcStrcNm = data[33],
//                            mainUseCd = data[34],
//                            mainUseNm = data[35],
//                            etcUseNm = data[36],
//                            extent = BigDecimal(data[37]),
//                            createDt = data[38]
//                        )
//                    )
//
//                }
//            }
//        }
        jdbcTemplate.batchUpdate(
            " INSERT INTO mart_djy_06 ( " +
                    "address" +
                    ") values (" +
                    "?" +
                    ")", // bulk insert에 사용할 기본 쿼리
            list, // insert할 모델
            1000000 // 1번의 batch로 함께 insert할 batch 사이즈
        ) { ps, argument ->
            ps.setString(1,argument.address)


        }

        val stringArr = list.toTypedArray()
        return stringArr
    }


    @PostMapping("/register")
    fun downloadFile(url: URL?=null, outputFileName: String?=null) {
        var url: URL?
        var reader: BufferedReader?

        url = URL(
            "https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=abc_bridge&logNo=221173285900&view=img_2"
        )
        val con : HttpURLConnection = url.openConnection() as HttpURLConnection
        con.requestMethod = "GET"
        con.readTimeout = 1000
        con.connect()

        reader  = BufferedReader(InputStreamReader(con.inputStream,"UTF8"))

        var inputLine : String?  = null
        while ((inputLine == reader.readLine()) != null){
            println(inputLine)
        }
        reader.close()
    }



    @PostMapping("/register2")
    fun downloadFile2(url: URL?=null, outputFileName: String?=null) {

        var address  = "https://www.7-zip.org/a/7z1806-x64.exe"
        val fileName: String = address.substring(
            address.lastIndexOf("/") + 1, address.length
        )
        val website = URL(address)
        val rbc = Channels.newChannel(website.openStream())
        val fos = FileOutputStream(fileName)

        fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE) // 처음부터 끝까지 다운로드

        fos.close()

        println("파일 다운로드되었음")
    }
}
