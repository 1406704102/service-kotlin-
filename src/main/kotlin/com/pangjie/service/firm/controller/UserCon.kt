package com.pangjie.service.firm.controller

import com.pangjie.service.firm.bean.User
import com.pangjie.service.firm.repo.UserRepo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/UserCon")
class UserCon(val userRepo: UserRepo) {
    @RequestMapping("findAll")
    fun findAll(): MutableIterable<User> = userRepo.findAll()

    @RequestMapping("findById")
    fun findById(id: Long) = userRepo.findUserById(id)

    @RequestMapping("findByName")
    fun findByName(userName: String): Long {
        return userRepo.findUserByUserName(userName).id
    }

    @RequestMapping("addUser")
    @ResponseBody
    fun addUser(@RequestBody user: User) = userRepo.save(user)

}