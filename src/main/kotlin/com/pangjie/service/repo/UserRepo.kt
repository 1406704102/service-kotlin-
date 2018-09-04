package com.pangjie.service.repo

import com.pangjie.service.dean.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface UserRepo : CrudRepository<User, Long> {
    fun findUserById(id: Long): User
    fun findUserByUserName(name: String): User
}