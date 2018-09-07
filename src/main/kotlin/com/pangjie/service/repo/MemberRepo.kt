package com.pangjie.service.repo

import com.pangjie.service.dean.Member
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service


@Service
interface MemberRepo : CrudRepository<Member, Long> {
    fun findMemberByIsDelete(isDelete: Int, pageable: Pageable): Slice<Member>
    fun findMemberByIsDeleteAndName(isDelete: Int, name: String): MutableIterable<Member>
    fun findMemberByName(name: String): MutableIterable<Member>
    fun findMemberByPhone(phone: String): MutableIterable<Member>
    fun findMemberByIntegral(integral: Int): MutableIterable<Member>
    fun findMemberById(id:Long):Member
}