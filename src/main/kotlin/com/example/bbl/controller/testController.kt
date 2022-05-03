package com.example.bbl.controller

import com.example.bbl.model.UserForm
import com.example.bbl.service.userService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("test")
class testController() {

    @Autowired
    lateinit var userService : userService


    @PostMapping("/ss")
    fun test(@RequestBody userForm: UserForm){
        println("userForm:")
        println("userForm:${userForm}")
        userService.userSave(userForm)
    }

}
