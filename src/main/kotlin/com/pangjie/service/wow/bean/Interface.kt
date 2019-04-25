package com.pangjie.service.wow.bean

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * @description TODO:wow插件实体类
 * @author pangjie___
 * @date 2019/4/24 0024
 * @return
 **/
@Entity
data class Interface(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        var userId: Long?,
        //所属人姓名
        var useName: String?,
        //最后上传时间
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var lastUpTime: Date?,
        //存储地址
        var storageAddress: String?
)