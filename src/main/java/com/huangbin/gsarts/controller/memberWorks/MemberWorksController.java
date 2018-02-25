package com.huangbin.gsarts.controller.memberWorks;


import com.huangbin.gsarts.controller.base.BaseController;
import com.huangbin.gsarts.model.member.Member;
import com.huangbin.gsarts.model.memberWorks.MemberWorks;
import com.huangbin.gsarts.service.member.MemberService;
import com.huangbin.gsarts.service.memberWorks.MemberWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员作品控制器
 */
@RestController
@RequestMapping(value = "/memberWorks")
public class MemberWorksController extends BaseController {

    @Autowired
    MemberWorksService memberWorksService;
    /**
     * @return 查询所有的会员作品信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<MemberWorks> findAll() {
        return memberWorksService.findAll();
    }
    /**
     * @return 查询所有的会员作品信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MemberWorks findById(@PathVariable Long id) {
        return memberWorksService.findById(id);
    }


}
