package com.realdealbatch.service

import com.realdealbatch.entity.DataResponse
import retrofit2.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ApartInterface {
    @GET("OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade")
    fun getRestDeInfo(
//        @Query("LAWD_CD", encoded = true) LAWD_CD: List<String>,
        @Query("DEAL_YMD", encoded = true) DEAL_YMD: String,
        @Query("serviceKey", encoded = true) serviceKey: String = "i3fNY1FFUUBMV6YzMXxCWgtXMY%2BvYsbjsfUAoXwJtr3HVe%2BcVXLKyPsiUV4IC%2FJc8IN2Th8ec9WNMquGGc%2B9Ew%3D%3D"
    ): Call<DataResponse>
}