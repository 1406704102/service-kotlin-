package com.pangjie.service.sys.bean

import javax.persistence.*

/**
 * 功能描述: 菜单
 * No such property: code for class: Script1
 * @return:
 * @Author: pangjie
 * @Date: 2018/9/21 0021 10:29
 */
@Entity
data class Menu(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val icon: String,
        val identification: String,
        val name: String,
        //菜单序号
        val sortNum: Int,
        //上级菜单的id
        val subs: String,
        //是否有下级菜单
        val hasSub: String,
        //菜单等级
        val level: String
)