package com.example.bbl.controller

import com.example.bbl.entity.Martdjy06
import com.example.bbl.entity.user.Users
import com.example.bbl.model.MartDjy06Form
import com.example.bbl.model.UserForm
import com.example.bbl.service.userService
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
import java.util.*


@RestController
@RequestMapping("test")
class JpaTestController {

    @Autowired
    lateinit var userService : userService

    @Value("\${etc.data.file}")
    lateinit var file: String


    @Autowired
    lateinit var  jdbcTemplate: JdbcTemplate


    @PostMapping("/userSave")
    fun test(@RequestBody userForm: UserForm){
        userService.userSave(userForm)
    }


}
