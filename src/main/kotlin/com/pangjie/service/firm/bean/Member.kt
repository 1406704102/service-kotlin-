package com.pangjie.service.firm.bean

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Member(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        var name: String,
        var phone: String,
        var integral: Int,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val createTime: Date = Date(),
        var isDelete: Int = 0
)