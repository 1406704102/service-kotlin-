package com.pangjie.service.sys.repo

import com.pangjie.service.sys.bean.Menu
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface MenuRepo : CrudRepository<Menu, Long> {
    fun findAll(sort: Sort): MutableIterable<Menu>
}