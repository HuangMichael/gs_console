package com.huangbin.gsarts.controller.member;


import com.huangbin.gsarts.controller.base.BaseController;
import com.huangbin.gsarts.model.member.Member;
import com.huangbin.gsarts.model.role.Role;
import com.huangbin.gsarts.service.member.MemberService;
import com.huangbin.gsarts.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员控制器
 */
@RestController
@RequestMapping(value = "/member")
public class MemberController extends BaseController {

    @Autowired
    MemberService memberService;


    /**
     * @return 查询所有的会员信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Member> findAll() {
        return memberService.findAll();
    }


    /**
     * @return 查询所有的会员信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Member findById(@PathVariable Long id) {
        return memberService.findById(id);
    }


}
