package com.pangjie.service.firm.controller

import com.pangjie.service.firm.bean.Member
import com.pangjie.service.firm.repo.MemberRepo
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/MemberCon")
class MemberCon(val memberRepo: MemberRepo) {

    /**
     * 功能描述:分页查询会员
     * No such property: code for class: Script1
     * @return:
     * @Author: pangjie
     * @Date: 2018/9/7 0007 9:44
     */
    @RequestMapping("findAll0")
    fun findAll0(@RequestParam page: Int, @RequestParam size: Int): MutableIterable<Member> {
        return memberRepo.findMemberByIsDelete(0, PageRequest.of(page - 1, size))
    }

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
    fun addMember(member: Member) = memberRepo.save(member)

    /**
     * 功能描述:修改会员
     * No such property: code for class: Script1
     * @return:
     * @Author: pangjie
     * @Date: 2018/9/7 0007 9:43
     */
    @RequestMapping("updateMember")
    fun updateMember(id: Long, name: String, phone: String, integral: Int) {
        memberRepo.run {
            val member = findMemberById(id)
            member.name = name
            member.phone = phone
            if (member.integral != integral) member.integral = member.integral + integral
            save(member)
        }
    }

    /**
     * 功能描述:删除会员
     * No such property: code for class: Script1
     * @return:
     * @Author: pangjie
     * @Date: 2018/9/7 0007 15:58
     */
    @RequestMapping("deleteMember")
    fun deleteMember(id: Long) {
        val m = memberRepo.findMemberById(id)
        m.isDelete = 1
        memberRepo.save(m)
    }

    /**
     * 功能描述:会员查询
     * No such property: code for class: Script1
     * @return:
     * @Author: pangjie
     * @Date: 2018/9/7 0007 16:26
     */
    @RequestMapping("memberFind")
    fun memberFind(select_cate: String, select_word: String): MutableIterable<Member> {
        val v = when (select_cate) {
            "name" -> memberRepo.findMemberByName(select_word)
            "phone" -> memberRepo.findMemberByPhone(select_word)
            "integral" -> memberRepo.findMemberByIntegral(select_word.toInt())
            else -> null
        }
        return v!!
    }

    /**
     * 功能描述:查询有多少会员
     * No such property: code for class: Script1
     * @return:
     * @Author: pangjie
     * @Date: 2018/9/11 0011 11:33
     */
    @RequestMapping("total")
    fun findMemberTotal() = memberRepo.findMemberByIsDelete(0).count()
}