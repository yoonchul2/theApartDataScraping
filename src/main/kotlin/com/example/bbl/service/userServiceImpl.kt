package com.example.bbl.service

import com.example.bbl.entity.User
import com.example.bbl.model.UserForm
import com.example.bbl.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class userServiceImpl : userService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun userSave(userForm: UserForm) {
        val user = User(
                userId = userForm.userId
        )
        userRepository.save(user)
    }

}