package com.pangjie.service.controller

import com.pangjie.service.dean.Member
import com.pangjie.service.repo.MemberRepo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/MemberCon")
class MemberCon(val memberRepo: MemberRepo) {

    @RequestMapping("findAll")
    fun findAll(): MutableIterable<Member> = memberRepo.findAll()

    @RequestMapping("name")
    fun findByName(string: String): MutableIterable<Member> = memberRepo.findMemberByName(string)

    @RequestMapping("phone")
    fun findByPhone(string: String): MutableIterable<Member> = memberRepo.findMemberByPhone(string)

    @RequestMapping("integral")
    fun findByIntegral(int: Int): MutableIterable<Member> = memberRepo.findMemberByIntegral(int)
    @PostMapping("add")
    fun addMember(member: Member){
        println(member)
        memberRepo.save(member)
    }

}