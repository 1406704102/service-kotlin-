package com.pangjie.service.info.bean

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val name: String,
        val img: String,
        val selfCode: String,
        val description: String?,
        //分
        val price: Int?,
        val addTime: Date?
)