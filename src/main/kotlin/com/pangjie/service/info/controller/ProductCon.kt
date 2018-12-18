package com.pangjie.service.info.controller

import com.pangjie.service.info.bean.Product
import com.pangjie.service.info.repo.ProductRepo
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ProductCon")
class ProductCon(val productRepo: ProductRepo) {

    @RequestMapping("getAll")
    fun getAllWithPage(page: Int, size: Int) = productRepo.findAll(PageRequest.of(page-1, size))


    @PostMapping("add")
    fun addProduct(product: Product) = productRepo.save(product)

    @RequestMapping("find")
    fun findProductByName(name: String) = productRepo.findAllByNameLike("%$name%")

}