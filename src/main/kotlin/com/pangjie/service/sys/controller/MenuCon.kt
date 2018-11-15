package com.pangjie.service.sys.controller

import com.pangjie.service.firm.repo.UserRepo
import com.pangjie.service.sys.bean.Menu
import com.pangjie.service.sys.repo.MenuRepo
import org.springframework.data.domain.Sort
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/menu")
class MenuCon(val menuRepo: MenuRepo, val userRepo: UserRepo) {

    /**menu
     * 功能描述: 查询菜单(排序)
     * No such property: code for class: Script1
     * @return:
     * @Author: pangjie
     * @Date: 2018/9/21 0021 14:55
     */
    @RequestMapping("findAll")
    fun findAll(): MutableIterable<Menu> {
        return menuRepo.findAll(Sort(Sort.Direction.ASC, "sortNum"))
    }

    /**
     * @description TODO:根据层级,和用户的权限查询菜单
     * @author pangjie___
     * @date 2018/9/25 0025
     * @return
     **/
    @RequestMapping("findMenu")
    fun findByHasSub(level: String, userId: Long): MutableIterable<Menu> {
        var ids = mutableListOf<Long>()
        userRepo.findUserById(userId).role.split(',').forEach {
            ids.add(it.toLong())
        }
        return menuRepo.findByLevelAndIdInOrderBySortNumAsc(level, ids)
    }

    /**
     * @description TODO:
     * @author pangjie___
     * @date 2018/10/17 0017
     * @return
     **/
    @RequestMapping("findByLevel")
    fun findByLevel(level: String) = menuRepo.findByLevelOrderBySortNumAsc(level)

//    @Scheduled(cron = "1/10 * * * * ?")
//    fun test() {
//        var calendar = Calendar.getInstance()
//        val year = calendar.get(Calendar.YEAR)
//        val month = calendar.get(Calendar.MONTH)
//        val day = calendar.get(Calendar.DAY_OF_MONTH)
//        val hour = calendar.get(Calendar.HOUR_OF_DAY)
//        val minute = calendar.get(Calendar.MINUTE)
//        val second = calendar.get(Calendar.SECOND)
//        println("====>$year-$month-$day   $hour: $minute: $second")
//    }

    fun findTest(menu: Menu) {
        if (!menu.subs.isEmpty()) {

        }
    }

    @RequestMapping("findBySubs")
    fun findBySubs(sub: String) = menuRepo.findBySubsOrderBySortNum(sub)
}
