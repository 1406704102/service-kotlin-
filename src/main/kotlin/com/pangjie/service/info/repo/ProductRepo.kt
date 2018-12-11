package com.pangjie.service.info.repo

import com.pangjie.service.info.bean.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface ProductRepo : CrudRepository<Product, Long> {
    fun findAllByNameLike(name:String):MutableList<Product>
}