package com.pangjie.service.firm.bean

import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val userName: String,
        val passWord: String,
        val role:String
)