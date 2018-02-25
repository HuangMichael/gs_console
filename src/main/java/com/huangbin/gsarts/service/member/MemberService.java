package com.huangbin.gsarts.service.member;

import com.huangbin.gsarts.dao.member.MemberRepository;
import com.huangbin.gsarts.dao.role.RoleRepository;
import com.huangbin.gsarts.model.member.Member;
import com.huangbin.gsarts.model.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员信息接口
 */
@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    /**
     * @return 查询所有的会员
     */
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /**
     * @param id
     * @return 根据ID查询会员
     */
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }
}
