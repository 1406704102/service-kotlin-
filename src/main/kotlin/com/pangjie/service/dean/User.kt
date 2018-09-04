package com.pangjie.service.dean

import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val userName: String,
        val passWord: String

)