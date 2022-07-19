package com.realdealbatch.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name="item")
data class RealDealForm(

    @field:Element(name = "거래금액")
    var dealAmount : String = "",
    @field:Element(name = "건축년도")
    var buildYear :      String = "",
    @field:Element(name = "년")
    var dealYear :      String = "",
    @field:Element(name = "법정동")
    var dong :      String = "",
    @field:Element(name = "아파트")
    var apartmentName :      String = "",
    @field:Element(name = "월")
    var dealMonth :      String = "",
    @field:Element(name = "일")
    var dealDay :      String = "",
    @field:Element(name = "전용면적")
    var areaForExclusiveUse :     String = "",
    @field:Element(name = "지번")
    var jibun :      String = "",
    @field:Element(name = "지역코드")
    var regionalCode :      String = "",
    @field:Element(name = "층")
    var floor :      String = "",
    @field:Element(name = "해제사유발생일")
    var cancelDealDay :      String = "",
    @field:Element(name = "거래유형")
    var reqGbn :      String = "",
    @field:Element(name = "중개사소재지")
    var rdealerLawdnm :      String = "",
    @field:Element(name = "해제여부")
    var cancelDealType :      String = ""
)
