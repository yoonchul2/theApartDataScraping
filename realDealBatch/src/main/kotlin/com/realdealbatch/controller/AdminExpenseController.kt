package com.realdealbatch.controller

//import org.springframework.batch.core.Job
//import org.springframework.batch.core.JobParametersBuilder
import com.realdealbatch.service.DataService
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping( "admin")
class AdminExpenseController(
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


     var driver: WebDriver? = null
     var element: WebElement? = null
     var url: String? = null

    // 1. 드라이버 설치 경로
    var WEB_DRIVER_ID = "webdriver.chrome.driver"
    var WEB_DRIVER_PATH = "C:/Users/mrsbok/Downloads/chromedriver.exe"

    @PostMapping("/start1")
    fun NaverLogin() {
        // WebDriver 경로 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH)

        // 2. WebDriver 옵션 설정
        val options = ChromeOptions()

        System.setProperty("webdriver.chrome.driver", "C:/Users/mrsbok/Downloads/chromedriver.exe")

        var caps = DesiredCapabilities.chrome()



        Runtime.getRuntime()
            .exec("C:/Program Files/Google/Chrome/Application/chrome.exe --remote-debugging-port=9222 --user-data-dir=\"C:/selenum/AutomationProfile\"")

        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222")

        options.addArguments("--start-normal")
        options.addArguments("--disable-popup-blocking")
        driver = ChromeDriver(options)

        driver?.manage()?.window()?.maximize()

        url = "https://apt.dozn.co.kr/"
        //activateBot()
        activateBot2()
    }
    fun activateBot2(): String {
        driver?.get("https://apt.dozn.co.kr/VINARISA/IMPS/VIN23700.aspx?IMPS030");
        Thread.sleep(2000); // 3. 페이지 로딩 대기 시간


        // 4. 로그인 버튼 클릭
        var dd: JavascriptExecutor? = driver as JavascriptExecutor

        Thread.sleep(2000)
        element = driver?.findElement(By.id("spdList1vp_vp"))
        driver?.findElement(By.tagName("canvas"))
        var btnzz =  driver?.findElement(By.id("btnMovePvmn"))

        btnzz?.click()
//        dd?.executeScript("window.testSpread = new GcSpread.Sheets.Spread(arguments[0]);", element)

        Thread.sleep(2000)


        Thread.sleep(2000)
        dd?.executeScript(" var canvas = document.getElementById('spdList1vp_vp');" +
                "function spdList1_CellClick(e, args) {\n" +
                "    var spsList = args.sheet;\n" +
                "    var iRow = args.row;\n" +
                "    var iCol = args.col;\n" +
                "    console.log(args.sheetArea);\n" +
                "    console.log(ns.SheetArea.colHeader);\n" +
                "\n" +
                "        var bChecked = !GetHeaderValue(spsList, 0, colList1.CHECK);\n" +
                "        console.log(bChecked);\n" +
                "        SetSpreadCheck(spsList, colList1.CHECK, true);\n" +
                "    \n" +
                "\n" +
                "    if (args.sheetArea == ns.SheetArea.viewport) {\n" +
                "        SetStartEdit(spsList, iRow, iCol);\n" +
                "    }\n" +
                "\n" +
                "    if (oldIndex != iRow) {\n" +
                "        ActionSearchDetail(GetCellValue(spsList1, iRow, colList1.BLDG), GetCellValue(spsList1, iRow, colList1.ROOM), GetCellValue(spsList1, iRow, colList1.IS_TT));\n" +
                "        oldIndex = iRow;\n" +
                "    }\n" +
                "    \n" +
                "}\n" +
                "\n" +
                "SetEventHandler(spsList1, ns.Events.CellClick       , spdList1_CellClick       );"

        )

        //동,호 전체선택
        var element4 = driver?.findElement(By.xpath("//*[@id=\"spdList1\"]"))

//        var dfsd =  element5?.findElements(By.tagName("checkbox"))
//        println(dfsd)
//        println(element4)
        element4?.click()
//        // "var ctx = canvas.getContext('2d');"
//         var ss = dd?.executeScript("spread.getSheet(0);")





        dd?.executeScript(
            "function SetFileList(jParams) {\n" +
                    "\n" +
                    "    var csv = \"\";\n" +
                    "\n" +
                    "    if (extMutlDown == \"N\") {\n" +
                    "\n" +
                    "     \n" +
                    "        csv = csv + \"<mangoji>\" + \"\\r\\n\";\n" +
                    "        for (var iRow = 0; iRow < extFileArray09.length; iRow++) {\n" +
                    "            var jDataRow = extFileArray09[iRow];\n" +
                    "            csv = csv + jDataRow.FILE_INFO + \"\\r\\n\";\n" +
                    "        }\n" +
                    "\n" +
                    "      \n" +
                    "    } \n" +
                    "\n" +
                    "\n" +
                    "    var fileName = \"A\" + (\"0000\" + String(UserCplx.CPLX_CD)).substring((\"0000\" + String(UserCplx.CPLX_CD)).length - 5, (\"0000\" + String(UserCplx.CPLX_CD)).length) + \"_\" + txtMonth.value.replace(/-/gi, \"\") + \"_Man2070.txt\";\n" +
                    "\n" +
                    "    //\"CPLX_CD\": jDataRow[\"CPLX_CD\"], \"BILL_DVSN\": jDataRow[\"BILL_DVSN\"], \"IMPS_YMPR\": jDataRow[\"IMPS_YMPR\"].replace(/-/gi, \"\"), \"USERID\": UserCplx.USER_ID\n" +
                    "\n" +
                    "    var csvFile = new Blob([csv], { type: \"text/csv;charset=utf-8;\" });\n" +
                    "\n" +
                    "    if (navigator.msSaveOrOpenBlob) {\n" +
                    "        navigator.msSaveOrOpenBlob(csvFile, fileName);\n" +
                    "    } else {\n" +
                    "\n" +
                    "        var downloadLink = document.createElement(\"a\");\n" +
                    "        downloadLink.download = fileName;\n" +
                    "        downloadLink.href = window.URL.createObjectURL(csvFile);\n" +
                    "        downloadLink.style.display = \"none\";\n" +
                    "        document.body.appendChild(downloadLink);\n" +
                    "        downloadLink.click();\n" +
                    "        document.body.removeChild(downloadLink);\n" +
                    "    }\n" +
                    "\n" +
                    "    SetLog(jParams);\n" +
                    "}"+
                "function ActionFileDownLoad() {\n" +
                "    var jParams, jResult;\n" +
                "    extRowIndex = 0;\n" +
                "    extMutlDown = \"N\";\n" +
                "    exDownTime = \"\";\n" +
                "    var Arguments = new Array();\n" +
                "    for (var iRow = 0; iRow < GetRowCount(spsList1); iRow++) {\n" +
                "        if (GetCellValue(spsList1, iRow, colList1.CHECK) == true) {\n" +
                "            var Argument = GetRowData(spsList1, iRow);\n" +
                "            Argument[\"CPLXCD\"] = UserCplx.CPLX_CD;\n" +
                "            Argument[\"USERID\"] = UserCplx.USER_ID;\n" +
                "            Argument[\"OCPN_DVSN\"] = cobOcptDvsn.value;\n" +
                "\n" +
                "            Arguments.push(Argument);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    if (Arguments.length == 0) {\n" +
                "        MessageShow(\"선택된 동호가 없습니다.\");\n" +
                "        return false;\n" +
                "    }\n" +
                "\n" +
                "    try {\n" +
                "        jParams = {\n" +
                "            \"CPLX_CD\": UserCplx.CPLX_CD, \"BILL_DVSN\": cobBillDvsn.value, \"IMPS_YMPR\": txtMonth.value.replace(/-/gi, \"\"), \"USERID\": UserCplx.USER_ID\n" +
                "        };\n" +
                "\n" +
                "        jResult = AspxMethod(\"ActionFileDownChk\", jParams);\n" +
                "        jResult = GetJsonResult(jResult);\n" +
                "        if (jResult.ErrorCode == \"Error\") {\n" +
                "            MessageShow(jResult.ErrorText);\n" +
                "            return false;\n" +
                "        } else {\n" +
                "            if (jResult.ErrorText == \"Y\") {\n" +
                "                extMutlDown = \"Y\";\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        var MSG = \"선택된 동호의 고지 정보 파일을 다운로드 하시겠습니까?\";\n" +
                "\n" +
                "\n" +
                "        MessageYesNo(MSG, function (result) {\n" +
                "            if (result != true) {\n" +
                "                return false;\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "            jParams = {\n" +
                "                \"CPLX_CD\": UserCplx.CPLX_CD, \"USERID\": UserCplx.USER_ID, \"ParamList\": GetJsonObject(Arguments)\n" +
                "            };\n" +
                "\n" +
                "            ShowProgress(true);\n" +
                "\n" +
                "            AspxMethod(\"SetDownList\", jParams, null, null, function (jResult) {\n" +
                "                try {\n" +
                "                    jResult = GetJsonResult(jResult);\n" +
                "                    if (jResult.ErrorCode == \"Error\") {\n" +
                "                        MessageShow(jResult.ErrorText);\n" +
                "                        return false;\n" +
                "                    } else {\n" +
                "                        exDownTime = jResult.ErrorText;\n" +
                "\n" +
                "                        jParams = {\n" +
                "                            \"CPLX_CD\": UserCplx.CPLX_CD, \"BILL_DVSN\": cobBillDvsn.value, \"IMPS_YMPR\": txtMonth.value.replace(/-/gi, \"\"), \"DOWN_TIME\": exDownTime,  \"USERID\": UserCplx.USER_ID\n" +
                "                        };\n" +
                "\n" +
                "                        ActionFileDownLoad_01(jParams);\n" +
                "                    }\n" +
                "                } catch (ex) {\n" +
                "                    MessageCatchErrShow(ex.message);\n" +
                "                } finally {\n" +
                "                    ShowProgress(false);\n" +
                "                }\n" +
                "            });\n" +
                "        });\n" +
                "\n" +
                "    } catch (ex) {\n" +
                "        MessageCatchErrShow(ex.message);\n" +
                "    } finally {\n" +
                "        ShowProgress(false);\n" +
                "    }\n" +
                "}" +

                        " ActionFileDownLoad();"

        )


        //다운로드 버튼 클릭
//        var element5 = driver?.findElement(By.id("btnDown"))
//        element5?.click()
        //다운로드 버튼 예
        var element6 = driver?.findElement(By.id("btnMessageYes"))
        element6?.click()
//        //Set Cell Value
//        //Set Cell Value
//        dd?.executeScript("window.testSpread.getActiveSheet().setValue(0,0,'1');")
//        //Get cell value
//        //Get cell value
//        val value  = dd?.executeScript("return window.spread.getActiveSheet().getValue(0,0);")
//
//        dd?.executeScript("arguments[0].click();", element)
        var html = driver?.pageSource
//        element?.sendKeys(Keys.ENTER)
        Thread.sleep(1000)
        println(element)
    return ""
    }
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