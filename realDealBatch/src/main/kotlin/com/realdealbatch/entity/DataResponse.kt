package com.realdealbatch.entity

import com.matching.main.entity.RealDeal
import com.realdealbatch.model.RealDealForm
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "response", strict = false)
data class DataResponse(
    @field:Element(name = "header")
    var header: Header? = null,
    @field:Element(name = "body")
    var body: Body? = null
)
@Root(strict = false)
data class Header (
    @field:Element(name = "resultCode")
    var resultCode: Int = 0,
    @field:Element(name = "resultMsg")
    var resultMsg: String = ""
)

@Root(strict = false)
data class Body(
    @field:ElementList(name = "items", entry = "item", required = false)
    var items: List<RealDealForm> = mutableListOf(),
    @field:Element(name = "numOfRows")
    var numOfRows: Int = 0,
    @field:Element(name = "pageNo")
    var pageNo: Int = 0,
    @field:Element(name = "totalCount")
    var totalCount: Int = 0
)