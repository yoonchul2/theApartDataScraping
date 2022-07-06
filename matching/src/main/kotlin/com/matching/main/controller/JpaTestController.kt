package com.bokbuin.main.controller


import com.matching.main.model.UserForm
import com.matching.main.service.userService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("test")
class JpaTestController {

    @Autowired
    lateinit var userService : userService

    @Value("\${etc.data.file}")
    lateinit var file: String


    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate


    @PostMapping("/userSave")
    fun test(@RequestBody userForm: UserForm){
        userService.userSave(userForm)
    }


}
