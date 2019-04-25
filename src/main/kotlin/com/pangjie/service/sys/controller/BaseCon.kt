package com.pangjie.service.sys.controller

import com.pangjie.service.firm.bean.User
import com.pangjie.service.firm.repo.UserRepo
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession

@RestController
open class BaseCon(val session: HttpSession,val userRepo: UserRepo) {
    fun getUser():User{
        val id = session.getAttribute("id")
       return userRepo.findUserById(id as Long)
    }
}