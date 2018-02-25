package com.huangbin.gsarts.dao.member;

import com.huangbin.gsarts.model.member.Member;
import com.huangbin.gsarts.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员信息接口
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * @return 查询所有的会员
     */
    List<Member> findAll();

    /**
     * @param id
     * @return 根据ID查询会员
     */
    Member findById(Long id);
}
