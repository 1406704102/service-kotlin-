package com.pangjie.service.controller

import com.pangjie.service.dean.Member
import com.pangjie.service.repo.MemberRepo
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/MemberCon")
class MemberCon(val memberRepo: MemberRepo) {

    @RequestMapping("findAll0")
    fun findAll0(isDelete: Int, page: Int,size:Int): MutableIterable<Member> = memberRepo.findMemberByIsDelete(isDelete, PageRequest.of(page, size))

    @RequestMapping("findByIsDeleteAndName")
    fun findMemberByIsDeleteAndName(isDelete: Int, name: String): MutableIterable<Member> = memberRepo.findMemberByIsDeleteAndName(isDelete, name)

    @RequestMapping("findAll")
    fun findAll(): MutableIterable<Member> = memberRepo.findAll()

    @RequestMapping("name")
    fun findByName(string: String): MutableIterable<Member> = memberRepo.findMemberByName(string)

    @RequestMapping("phone")
    fun findByPhone(string: String): MutableIterable<Member> = memberRepo.findMemberByPhone(string)

    @RequestMapping("integral")
    fun findByIntegral(int: Int): MutableIterable<Member> = memberRepo.findMemberByIntegral(int)

    @PostMapping("add")
    fun addMember(member: Member) {
        println(member)
        memberRepo.save(member)
    }

}