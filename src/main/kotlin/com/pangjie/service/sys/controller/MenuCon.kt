package com.pangjie.service.sys.controller

import com.pangjie.service.sys.bean.Menu
import com.pangjie.service.sys.repo.MenuRepo
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menu")
class MenuCon(val menuRepo: MenuRepo){

    /**
     * 功能描述: 查询菜单(排序)
     * No such property: code for class: Script1
     * @return:
     * @Author: pangjie
     * @Date: 2018/9/21 0021 14:55
     */
    @RequestMapping("findAll")
    fun findAll():MutableIterable<Menu> {
        return menuRepo.findAll(Sort(Sort.Direction.ASC, "sortNum"))
    }
}
