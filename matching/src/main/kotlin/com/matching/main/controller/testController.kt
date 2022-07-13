package com.matching.main.controller

import com.matching.main.entity.Martdjy08
import com.matching.main.model.UserForm
import com.matching.main.service.userService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
   //@PostMapping("/sss")
   //fun testss(): MutableList<Any>? {

   //    var fileList: MutableList<Any> = mutableListOf()

   //    println(file)
   //    val path = File(file)
   //    println(path)
   //    val fileArr: Array<File> = path.listFiles()
   //    println(fileArr[0])
   //    var test : String? = ""

   //    for (file in fileArr) {
   //                 test = file.canonicalPath.toString() + File.separator.toString()

   //                println("--------")
   //                println(test)
   //                fileList.add(test)


   //    }

   //    val content = readFile(test!!, StandardCharsets.UTF_8)
   //    println(content)
   //    return  fileList
   //}



   //fun readFile(path: String, encoding: Charset): Array<Martdjy08> {
   //    val file = File(path)
   //    val ind = BufferedReader(FileReader(file))
   //    var str: String? = ""
   //    var list: MutableList<Martdjy08> = mutableListOf()
   //    var data : MutableList<String> = mutableListOf()
   //    do{
   //        if(str != "") {
   //            data = str?.split("|") as MutableList<String>

   //            list.add(
   //                Martdjy08(
   //                    bldgPk = data[0],
   //                    bldgDivCd = data[1],
   //                    bldgDivNm =  data[2],
   //                    bldgKindCd = data[3],
   //                    bldgKindNm = data[4],
   //                    address = data[5],
   //                    addressDoro = data[6],
   //                    bldgNm = data[7],
   //                    sigunguCd = data[8],
   //                    dongCd = data[9],
   //                    landDivCd = data[10],
   //                    bun = data[11],
   //                    ji = data[12],
   //                    specialLandNm = data[13],
   //                    block = data[14],
   //                    lot = data[15],
   //                    etcLandNum = data[16],
   //                    addressDoroCd = data[17],
   //                    addressDoroLawdCd = data[18],
   //                    addressDoroUpdownCd = data[19],
   //                    addressDoroBun = data[20],
   //                    addressDoroJi = data[21],
   //                    standardDt = data[22],
   //                    price = data[23],
   //                    createDt = data[24]
   //                 )
   //            )
   //            data = mutableListOf()
   //            println("size:" + list.size)
   //            if(list.size == 1000){

   //                println("ddssgg${list.size}")
   //                jdbcTemplate.batchUpdate(
   //                    "insert into mart_djy_08 (bldg_pk, bldg_div_cd, bldg_div_nm, bldg_kind_cd, bldg_kind_nm, address, address_doro, bldg_nm, sigungu_cd, dong_cd, land_div_cd, bun, ji, special_land_nm, block, lot, etc_land_num, address_doro_cd, address_doro_lawd_cd, address_doro_updown_cd, address_doro_bun, address_doro_ji, standard_dt, price, create_dt) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", // bulk insert에 사용할 기본 쿼리
   //                    list, // insert할 모델
   //                    10000000 // 1번의 batch로 함께 insert할 batch 사이즈
   //                ) { ps, argument ->
   //                    ps.setString(1, argument.bldgPk)
   //                    ps.setString(2,argument.bldgDivCd)
   //                    ps.setString(3,argument.bldgDivNm)
   //                    ps.setString(4,argument.bldgKindCd)
   //                    ps.setString(5,argument.bldgKindNm)
   //                    ps.setString(6,argument.address)
   //                    ps.setString(7,argument.addressDoro)
   //                    ps.setString(8,argument.bldgNm)
   //                    ps.setString(9,argument.sigunguCd)
   //                    ps.setString(10,argument.dongCd)
   //                    ps.setString(11,argument.landDivCd)
   //                    ps.setString(12,argument.bun)
   //                    ps.setString(13,argument.ji)
   //                    ps.setString(14,argument.specialLandNm)
   //                    ps.setString(15,argument.block)
   //                    ps.setString(16,argument.lot)
   //                    ps.setString(17,argument.etcLandNum)
   //                    ps.setString(18,argument.addressDoroCd)
   //                    ps.setString(19,argument.addressDoroLawdCd)
   //                    ps.setString(20,argument.addressDoroUpdownCd)
   //                    ps.setString(21,argument.addressDoroBun)
   //                    ps.setString(22,argument.addressDoroJi)
   //                    ps.setBigDecimal(23,argument.price)
   //                    ps.setString(25,argument.createDt)


   //                }
   //                list = mutableListOf()
   //                println("ddssggs${list.size}")
   //            }
   //        }
   //    } while (ind.readLine().also { str = it } != null)
   //    ind.close()




   //    val stringArr = list.toTypedArray()
   //    return stringArr
   //}


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
