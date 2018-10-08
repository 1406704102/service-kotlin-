package com.pangjie.service.sys.controller

import com.pangjie.service.sys.bean.Menu
import com.pangjie.service.sys.repo.MenuRepo
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menu")
class MenuCon(val menuRepo: MenuRepo) {

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
     * @description TODO:根据层级查询菜单
     * @author pangjie___
     * @date 2018/9/25 0025
     * @return
     **/
    @RequestMapping("findMenu")
    fun findByHasSub(level: String): MutableIterable<Menu> {
        return menuRepo.findByLevelOrderBySortNumAsc(level)
    }

    @RequestMapping("findMenuById")
    fun findByHasSub(level: String, subs: String): MutableIterable<Menu> {
        return menuRepo.findByLevelAndSubsOrderBySortNumAsc(level, subs)
    }
}
