package com.huangbin.gsarts.dao.memberWorks;

import com.huangbin.gsarts.model.memberWorks.MemberWorks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员作品信息接口
 */
@Repository
public interface MemberWorksRepository extends JpaRepository<MemberWorks, Long> {

    /**
     * @return 查询所有的会员作品
     */
    List<MemberWorks> findAll();

    /**
     * @param id
     * @return 根据ID查询会员作品
     */
    MemberWorks findById(Long id);
}
