package com.matching.main.service

import com.matching.main.model.UserForm
import org.springframework.stereotype.Service

@Service
interface userService {

    fun userSave(userForm: UserForm)
}