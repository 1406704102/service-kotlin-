package com.pangjie.service.wow.repo

import com.pangjie.service.wow.bean.Interface
import org.springframework.data.repository.PagingAndSortingRepository

interface InterfaceRepo : PagingAndSortingRepository<Interface, Long> {
    fun findByUseName(name: String): MutableList<Interface>
    fun findInterfaceById(id:Long):Interface
}