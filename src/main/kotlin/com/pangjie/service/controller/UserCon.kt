package com.pangjie.service.controller

import com.pangjie.service.dean.User
import com.pangjie.service.repo.UserRepo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/UserCon")
class UserCon(val userRepo: UserRepo) {
    @RequestMapping("findAll")
    fun findAll(): MutableIterable<User> = userRepo.findAll()

    @RequestMapping("findById")
    fun findById(id: Long) = userRepo.findUserById(id)

    @RequestMapping("findByName")
    fun findByName(userName: String) = userRepo.findUserByUserName(userName).passWord

    @RequestMapping("addUser")
    @ResponseBody
    fun addUser(@RequestBody user: User) = userRepo.save(user)

}