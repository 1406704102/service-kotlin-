package com.pangjie.service.firm.controller

import com.pangjie.service.firm.bean.User
import com.pangjie.service.firm.repo.UserRepo
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpSession

@RestController
@RequestMapping("/api/UserCon")
class UserCon(val userRepo: UserRepo) {
    @RequestMapping("findAll")
    fun findAll(): MutableIterable<User> = userRepo.findAll()

    @RequestMapping("findById")
    fun findById(id: Long) = userRepo.findUserById(id)

    @RequestMapping("findByName")
    fun findByName(userName: String, session: HttpSession): Boolean {
        return try {
            var userId = userRepo.findUserByUserName(userName).id
            session.setAttribute("id", userId)
            println(session.getAttribute("id"))
            true
        } catch (e: Exception) {
            false
        }
    }

    @RequestMapping("addUser")
    @ResponseBody
    fun addUser(@RequestBody user: User) = userRepo.save(user)

    @RequestMapping("deleteUser")
    fun deleteUser(id: Long) = userRepo.delete(userRepo.findUserById(id))

    @RequestMapping("updateUser")
    fun updateUser(user: User) = userRepo.save(user)

    /**
     * @description TODO:根据id修改用户权限
     * @author pangjie___
     * @date 2018/10/17 0017
     * @return
     **/
    @RequestMapping("updateRole")
    fun updateRole(id: Long, role: String) {
        val user = userRepo.findUserById(id)
        if (role[0] !== ',')
            user.role = role
        else
            user.role = role.substring(1)
        userRepo.save(user)
    }
}