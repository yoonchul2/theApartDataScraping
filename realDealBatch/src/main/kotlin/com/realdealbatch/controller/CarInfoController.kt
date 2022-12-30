package com.realdealbatch.controller

//import org.springframework.batch.core.Job
//import org.springframework.batch.core.JobParametersBuilder
import com.google.common.collect.Table
import com.realdealbatch.entity.*
import com.realdealbatch.repository.*
import com.realdealbatch.service.DataService
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.dhatim.fastexcel.reader.Cell
import org.dhatim.fastexcel.reader.ReadableWorkbook
import org.dhatim.fastexcel.reader.Row
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.streams.toList


@RestController
@RequestMapping( "car")
class CarInfoController(
) {

            @Autowired
            lateinit var dataService: DataService
        @Value("\${etc.data.file3}")
        lateinit var file3: String

    @Autowired
    lateinit var  hoRepository: HoRepository

    @Autowired
    lateinit var  occCarRelRepository : OccCarRelRepository

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

    val searchSite = "https://apt.dozn.co.kr"

    val searchSite2 = "https://www.mois.go.kr/frt/bbs/type001/commonSelectBoardList.do?bbsId=BBSMSTR_000000000052"


     var driver: WebDriver? = null
     var element: WebElement? = null
     var url: String? = null

    // 1. 드라이버 설치 경로
    var WEB_DRIVER_ID = "webdriver.chrome.driver"
    var WEB_DRIVER_PATH = "C:/Users/mrsbok/Downloads/chromedriver.exe"

    @PostMapping("/start")
    fun NaverLogin() {
        // WebDriver 경로 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH)

        // 2. WebDriver 옵션 설정
        val options = ChromeOptions()

        System.setProperty("webdriver.chrome.driver", "C:/Users/mrsbok/Downloads/chromedriver.exe")


        Runtime.getRuntime()
            .exec("C:/Program Files/Google/Chrome/Application/chrome.exe --remote-debugging-port=9222 --user-data-dir=\"C:/selenum/AutomationProfile\"")

        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222")

        options.addArguments("--start-normal")
        options.addArguments("--disable-popup-blocking")
        driver = ChromeDriver(options)

        driver?.manage()?.window()?.maximize()

        url = "https://apt.dozn.co.kr/"
        //activateBot()
        getCarData()
    }
    fun getCarData(): String {
        driver?.get("https://apt.dozn.co.kr/VINARISA/OCPT/VIN63600.aspx?OCPT060");
        Thread.sleep(2000); // 3. 페이지 로딩 대기 시간

        // 4. 로그인 버튼 클릭
        var js: JavascriptExecutor? = driver as JavascriptExecutor

        Thread.sleep(2000)

        val element2 = driver?.findElement(By.id("btnSearch"))

        Thread.sleep(2000)
         element2?.click()

        Thread.sleep(8000)

       var vv = js?.executeScript(
           "var file_nm2 = '';" +
       "function ActionExcelDownload2() {\n" +
                   "\n" +
                   "    for (var iRow = 0; iRow < GetRowCount(spsList1); iRow++) {\n" +
                   "        var sBLDG = GetCellValue(spsList1, iRow, colList1.BLDG);\n" +
                   "        if (isEmpty(sBLDG)) {\n" +
                   "            MessageShow(\"조회 후 다운로드해주시기 바랍니다.\");\n" +
                   "            return false;\n" +
                   "        }      \n" +
                   "    }\n" +
                   "\n" +
                   "    ShowProgress(true);\n" +
                   "    spsList1.suspendPaint();\n" +
                   "    \n" +
                   "        try {\n" +
                   "            var iRow = GetActiveRowIndex(spsList1);\n" +
                   "            var Argument = GetRowData(spsList1, iRow);\n" +
                   "\n" +
                   "            var excelIo = new GC.Spread.Excel.IO();\n" +
                   "            var file_nm = Argument.CPLX_CD + \"단지차량검색.xlsx\";\n" +
                   "            file_nm2 = Argument.CPLX_CD + \"단지차량검색.xlsx\";\n" +
                   "            var json = spdList1.toJSON();\n" +
                   "\n" +
                   "            // 파일 다운로드\n" +
                   "            excelIo.save(json, function (blob) {\n" +
                   "\n" +
                   "                spsList1.options.isProtected = false; // 시트 잠금 해제\n" +
                   "                saveAs(blob, file_nm);\n" +
                   "                spsList1.options.isProtected = true;\n" +
                   "\n" +
                   "            }, function (e) {\n" +
                   "                console.log(e.message);\n" +
                   "            });\n" +
                   "        }\n" +
                   "        catch (ex) {\n" +
                   "            MessageCatchErrShow(ex.message);\n" +
                   "        }\n" +
                   "        finally {\n" +
                   "            spsList1.resumePaint();\n" +
                   "\n" +
                   "            ShowProgress(false);\n" +
                   "        }\n" +
                   "    \n" +
                   "}\n" +
                   "console.log('sdgsdg');" +
                   "ActionExcelDownload2();" +
                   "console.log(file_nm2);"+
                   "function filename() {" +
                   "return file_nm2;" +
                   "}" +
                   "return file_nm2"
       )
        Thread.sleep(4000)

//        val element3= driver?.findElement(By.id("btnExcelDownload"))
//        element3?.click()

        val oldfile2: Path = Paths.get("C:\\Users\\mrsbok\\Downloads\\${vv}")
        val newfile2: Path = Paths.get("C:\\Users\\mrsbok\\bokbuin_refactoring\\realDealBatch\\file\\${vv}")
        Files.move(oldfile2, newfile2, StandardCopyOption.ATOMIC_MOVE);

        val path = File("C:\\Users\\mrsbok\\bokbuin_refactoring\\realDealBatch\\file\\${vv}")
        val workbook = XSSFWorkbook(path)
        var worksheet = workbook.getSheetAt(0)
        for (rowIndex in 0 until worksheet.physicalNumberOfRows) {
            val row = worksheet.getRow(rowIndex)
            var occ : OccCar?= null
            var sex : OccCar.houseState =  OccCar.houseState.등록

            if(row.getCell(0).stringCellValue != "합계"){
                val dongId = dongRepository.findDongByDongNum(row.getCell(0).stringCellValue);
                val hoId = hoRepository.findHoByDSeqAndHoNum(dongId.seq!!,row.getCell(1).stringCellValue)
                hoIdx = hoId.seq
                val  iix = occRepository.findOccByHoSeq(hoIdx!!).seq
//            if(row.getCell(11).stringCellValue != ""){
//                zz = LocalDate.parse(row.getCell(11).stringCellValue, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//            }
                ofIdx = occFmRepository.findOccFmByOSeqAndName(iix!!,row.getCell(8).stringCellValue)?.seq

                if(ofIdx == null){
                  val carRel =CarRel(null,hoId.seq!!,LocalDate.now(),
                      LocalDate.now(),row.getCell(4).stringCellValue,row.getCell(5).stringCellValue,
                      row.getCell(11).stringCellValue,row.getCell(8).stringCellValue
                      ,row.getCell(9).stringCellValue,""
                  )

                    occCarRelRepository.save(carRel)
                }else{
                    occ = OccCar(null,hoId.seq!!,ofIdx!!,sex,LocalDate.now(),row.getCell(4).stringCellValue,row.getCell(5).stringCellValue
                        ,row.getCell(11).stringCellValue,LocalDate.now(),"","")
                    println(occ)

                    occCarRepository.save(occ)
                }
            }




        }
        File("C:\\Users\\mrsbok\\bokbuin_refactoring\\realDealBatch\\file\\${vv}").delete()
    return ""
    }
    var occId : Long ?= null
    var hoIdx : Long ?= null
    var ofIdx : Long ?= null

    fun activateBot() {
        driver?.get(url);
        Thread.sleep(2000); // 3. 페이지 로딩 대기 시간



        Thread.sleep(1000);

        // ID 입력
        element = driver?.findElement(By.id("txtUser_id"))
        println(element)
        element?.sendKeys("apt4u")

        // 비밀번호 입력
        element = driver?.findElement(By.id("txtUser_pw"))
        println(element)
        element?.sendKeys("green29200")




        // 4. 로그인 버튼 클릭
        element = driver?.findElement(By.id("btnConfirm"))
        element?.click()
        var html = driver?.pageSource
        println(html)

        //자바 예제
        driver?.switchTo()?.frame(driver?.findElement(By.tagName("iframe")))
        element = driver?.findElement(By.id("btnSend"))
        println(element)


        //driver.switch_to.default_content()
//        // 전송
//        element = driver?.findElement(By.className("btn_global"));
//        element?.submit();
//        driver?.close() // 5. 브라우저 종료
        }



}