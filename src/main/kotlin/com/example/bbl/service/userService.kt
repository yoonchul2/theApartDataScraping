package com.example.bbl.service

import com.example.bbl.model.UserForm
import org.springframework.stereotype.Service

@Service
interface userService {

    fun userSave(userForm: UserForm)
}