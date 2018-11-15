package com.pangjie.service.firm.repo

import com.pangjie.service.firm.bean.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface UserRepo : CrudRepository<User, Long>{
    fun findUserById(id: Long): User
    fun findUserByUserName(name: String): User
}