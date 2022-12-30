package com.realdealbatch.controller

//import org.springframework.batch.core.Job
//import org.springframework.batch.core.JobParametersBuilder
import com.realdealbatch.service.DataService
import org.jsoup.Connection
import org.jsoup.Connection.Response
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.FormElement
import org.jsoup.select.Elements
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.nio.charset.Charset
import java.time.LocalDate
import java.util.zip.ZipFile


@RestController
@RequestMapping( "test2")
class BatchController2(
) {

        @Autowired
        lateinit var dataService: DataService
    @Value("\${etc.data.file3}")
    lateinit var file3: String







//    @PostMapping("/batch2")
//    fun test(){
//        jobLauncher.run(
//            job, JobParametersBuilder()
//                .addString("datetime", LocalDateTime.now().toString())
//                .toJobParameters()
//        )
//    }


    @PostMapping("/apart2")
    fun apart(){
        dataService.recivePublicData()
    }

    val searchSite = "https://apt.dozn.co.kr"

    val searchSite2 = "https://www.mois.go.kr/frt/bbs/type001/commonSelectBoardList.do?bbsId=BBSMSTR_000000000052"


    //크롤링(주민등록업무 담당 행정기관 및 관할구역 변경내역)
    @PostMapping("/getJcode")
    fun getJcodeScraping2(): String {

        val date = LocalDate.now()

        val doc = Jsoup.connect(searchSite2)
            .userAgent("Mozilla/5.0")
            .timeout(10*1000)
            .data("searchWrd", "주민등록업무 담당 행정기관 및 관할구역 변경내역(${date.year}. ${date.monthValue}. ${date.dayOfMonth}. 시행)")
            .get()
        println(doc.body())


        val doc2 = Jsoup.connect(searchSite2)
            .data("searchWrd", "행정동 및 관할구역")
            .userAgent("Mozilla/5.0")
            .timeout(10*1000)
            .post()
        //submit 폼 찾기
        val form : FormElement  = doc2.selectFirst("form[name=\"subForm\"]") as FormElement


        val findUrl = form.select("a").attr("abs:href")

        val movePage  = Jsoup.connect(findUrl)
            .userAgent("Mozilla/5.0")
            .timeout(10*1000).get()

        //페이지이동후 파일데이터가있는 폼 찾기
        val form2 : FormElement  = movePage.selectFirst("form[name=\"frm\"]") as FormElement

        //파일 다운로드 링크
        val fileUrl = form2.select(".download a").get(1).attr("abs:href")

        return doc.toString()
    }

    //크롤링(주민등록업무 담당 행정기관 및 관할구역 변경내역)
    @PostMapping("/getJcode2")
    fun getJcodeScraping(): String {

        val date = LocalDate.now()

        val doc : Response = Jsoup.connect(searchSite)
            .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
            .timeout(10*1000)
            .data("txtUser_id", "apt4u")
            .data("txtUser_pw", "green292001")
//            .data("description", "아파트 관리업무의 새로운 리더","txtUser_pw", "green29200")
            .method(Connection.Method.POST)
            .execute();


        val document: Document = doc.parse()
        document.select("input[id=\"txtUser_id\"]").`val`("apt4u")
        document.select("input[id=\"txtUser_pw\"]").`val`("green29200")

        val inputElements: Element? = document.getElementById("btnConfirm")

        println("ㅎㅇ" + inputElements)

        // 로그인 버튼 찾기
        // 로그인 버튼 찾기
//        val docs: Document = Jsoup.parse(doc.toString())
//
//        val zz : Element? = doc.body().selectFirst("form[id=\"form1\"]")



        val movePage  = Jsoup.connect(searchSite)
            .userAgent("Mozilla/5.0")
            .timeout(10*1000).get()

//        val form   = doc.select("input[id=\"txtUser_id\"]").`val`("apt4u")

        //submit 폼 찾기
//        val form : FormElement  = doc.body()selectFirst("form[id=\"form1\"]") as FormElement
//
//
////        println(form)
//        val findUrl = form.select("a").attr("abs:href")
//
//        val iframes: Elements = doc.select("iframe#mainFrame")
//        val src: String = iframes.attr("src")
//
//        val movePage  = Jsoup.connect(findUrl)
//            .userAgent("Mozilla/5.0")
//            .timeout(10*1000).get()
        return doc.body().toString()
//        //페이지이동후 파일데이터가있는 폼 찾기
//        val form2 : FormElement  = movePage.selectFirst("form[name=\"frm\"]") as FormElement
//
//        //파일 다운로드 링크
//        val fileUrl = form2.select(".download a").get(1).attr("abs:href")
//
//        val url = URL(fileUrl)
//        url?.openStream().use {
//            Channels.newChannel(it).use { rbc ->
//                FileOutputStream("${file3}/${date.year}-${date.monthValue}-${date.dayOfMonth}.zip").use { fos ->
//                    fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE)
//                }
//            }
//        }
//        unZip("${file3}/${date.year}-${date.monthValue}-${date.dayOfMonth}.zip",file3)

    }

    //파일 압축해제
    fun unZip(zipFilePath: String, targetPath: String) {
        var entryFolder  = ""
        var entryDate  = ""
        ZipFile(zipFilePath, Charset.forName("euc-kr")).use { zip ->
            zip.entries().asSequence().forEach { entry ->
                var excelFolder  = "excel/"

                //폴더 없을시에 최초생성
                if (entry.isDirectory) {
                    entryFolder = entry.name
                    entryDate = entry.name.substring(6,14)
                    File(targetPath, excelFolder).mkdirs()
                } else {
                    zip.getInputStream(entry).use { input ->
                        val fileName = "KIKcd_B." + entryDate + "(말소코드포함).xlsx"
                        var replaceEntryName =entry.name.replace(entryFolder,"")
                        if(fileName == replaceEntryName ) {
                            File(targetPath, excelFolder + replaceEntryName).outputStream().use { output ->
                                input.copyTo(output)
                            }
                        }
                    }
                }
            }
        }
    }



//    fun `가즈아`(zipFilePath: String, targetPath: String) {
//        FileInputStream("excel-read-sample.xlsx").use { fis ->
//            val wb = ReadableWorkbook(fis)
//            val cellValues = wb.firstSheet.openStream().parallel()
//                .map { row: Row ->
//                    // cell 을 data class로 변환한다.
//                    rowCellsToDataClass(
//                        row.stream() // parallel로 처리해도 된다.
//                    )
//                }
//                .collect(Collectors.toList())
//            cellValues.forEach{o->println(o)}
//        }
//    }

    // stream을 활용하든 다른 header 맵퍼를 사용하든 알아서
//     fun rowCellsToDataClass(stream: Stream<Cell>) : CellValue {
//        val cells = stream.toList()
//        return CellValue(cells[0].value.toString(), cells[1].value.toString(), cells[2].value.toString())
//    }
}