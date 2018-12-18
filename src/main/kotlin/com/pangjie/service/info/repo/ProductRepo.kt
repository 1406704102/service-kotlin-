package com.pangjie.service.info.repo

import com.pangjie.service.info.bean.Product
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Service
import java.awt.print.Pageable

@Service
interface ProductRepo : PagingAndSortingRepository<Product, Long> {
    fun findAllByNameLike(name:String):MutableList<Product>
}