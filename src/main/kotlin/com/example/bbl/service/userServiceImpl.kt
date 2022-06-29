package com.example.bbl.service

import com.example.bbl.entity.user.Users
import com.example.bbl.model.UserForm
import com.example.bbl.repository.UserRepository
import lombok.extern.log4j.Log4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.sql.Date
import java.sql.Types
import java.time.Instant
import java.time.LocalDateTime


@Service
@Log4j
class userServiceImpl : userService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var  jdbcTemplate: JdbcTemplate
    override fun userSave(userForm: UserForm) {
        val data = Users(
            id = "test"
        )

        userRepository.save(data)
    }
//    override fun userSave(userForm: UserForm) {
////
//        val list: ArrayList<Users?> = object : ArrayList<Users?>() {
//            init {
//                for (i in 0..10000000) {
//                    add(
//                        Users(
//                            id = userForm.userId
//                        )
//                    )
//                }
//            }
//        }
////        userRepository.saveAll(list)
//
//        jdbcTemplate.batchUpdate(
//            " INSERT INTO users ( " +
//                    "id" +
//                    ") values (" +
//                    "?" +
//                    ")", // bulk insert에 사용할 기본 쿼리
//            list, // insert할 모델
//            1000000 // 1번의 batch로 함께 insert할 batch 사이즈
//        ) { ps, argument ->
//            ps.setString(1,argument.id)
//
//
//
//
//        }
//    }
}