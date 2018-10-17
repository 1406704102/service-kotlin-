package com.pangjie.service.sys.repo

import com.pangjie.service.sys.bean.Menu
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface MenuRepo : CrudRepository<Menu, Long> {
    fun findAll(sort: Sort): MutableIterable<Menu>
    fun findByLevelAndIdInOrderBySortNumAsc(level: String, ids: MutableList<Long>): MutableIterable<Menu>
    fun findByLevelOrderBySortNumAsc(level: String):MutableIterable<Menu>
}