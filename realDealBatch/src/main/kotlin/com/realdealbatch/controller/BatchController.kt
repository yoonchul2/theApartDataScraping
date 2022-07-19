package com.realdealbatch.controller

import com.realdealbatch.service.DataService
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.FormElement
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL
import java.nio.channels.Channels
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.MonthDay
import java.util.zip.ZipFile


@RestController
@RequestMapping( "test")
class BatchController(
    private var job: Job,
    private var jobLauncher: JobLauncher
) {

        @Autowired
        lateinit var dataService: DataService
    @Value("\${etc.data.file3}")
    lateinit var file3: String

    @PostMapping("/batch")
    fun test(){
        jobLauncher.run(
            job, JobParametersBuilder()
                .addString("datetime", LocalDateTime.now().toString())
                .toJobParameters()
        )
    }


    @PostMapping("/apart")
    fun apart(){
        dataService.recivePublicData()
    }

    val searchSite = "https://www.mois.go.kr/frt/bbs/type001/commonSelectBoardList.do?bbsId=BBSMSTR_000000000052"


    //크롤링(주민등록업무 담당 행정기관 및 관할구역 변경내역)
    @PostMapping("/getJcode")
    fun getJcodeScraping(){

        val date = LocalDate.now()

        val doc = Jsoup.connect(searchSite)
            .userAgent("Mozilla/5.0")
            .timeout(10*1000)
            .data("searchWrd", "주민등록업무 담당 행정기관 및 관할구역 변경내역(${date.year}. ${date.monthValue}. ${date.dayOfMonth}. 시행)")
            .get()

        val form : FormElement  = doc.selectFirst("form[name=\"subForm\"]") as FormElement

        val findUrl = form.select("a").attr("abs:href")

        val movePage  = Jsoup.connect(findUrl)
            .userAgent("Mozilla/5.0")
            .timeout(10*1000).get()

        val form2 : FormElement  = movePage.selectFirst("form[name=\"frm\"]") as FormElement

        val fileUrl = form2.select(".download a").get(1).attr("abs:href")

        val url :URL = URL( fileUrl)
        url?.openStream().use {
            Channels.newChannel(it).use { rbc ->
                FileOutputStream("${file3}/${date.year}-${date.monthValue}-${date.dayOfMonth}.zip").use { fos ->
                    fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE)
                }
            }
        }
        unZip("${file3}/${date.year}-${date.monthValue}-${date.dayOfMonth}.zip",file3)

    }

    //파일 압축해제
    fun unZip(zipFilePath: String, targetPath: String) {
        var entryFolder  = ""
        var entryDate  = ""
        ZipFile(zipFilePath, Charset.forName("euc-kr")).use { zip ->
            zip.entries().asSequence().forEach { entry ->
                var excelFolder  = "excel/"
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

}