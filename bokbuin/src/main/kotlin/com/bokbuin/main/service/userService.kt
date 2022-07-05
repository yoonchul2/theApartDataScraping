package com.bokbuin.main.service

import com.bokbuin.main.model.UserForm
import org.springframework.stereotype.Service

@Service
interface userService {

    fun userSave(userForm: UserForm)
}