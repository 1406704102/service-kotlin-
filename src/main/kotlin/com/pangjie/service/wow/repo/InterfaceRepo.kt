package com.pangjie.service.wow.repo

import com.pangjie.service.wow.bean.Interface
import org.springframework.data.repository.PagingAndSortingRepository

interface InterfaceRepo : PagingAndSortingRepository<Interface, Long> {
    fun findByUserId(id: Long): Interface
    fun findInterfaceById(id: Long): Interface
    fun findByUserId(userId: String): Interface
}