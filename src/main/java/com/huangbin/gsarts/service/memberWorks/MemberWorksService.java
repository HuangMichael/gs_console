package com.huangbin.gsarts.service.memberWorks;

import com.huangbin.gsarts.dao.memberWorks.MemberWorksRepository;
import com.huangbin.gsarts.model.memberWorks.MemberWorks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员作品信息接口
 */
@Service
public class MemberWorksService {
    @Autowired
    MemberWorksRepository memberWorksRepository;

    /**
     * @return 查询所有的会员作品
     */
    public List<MemberWorks> findAll() {
        return memberWorksRepository.findAll();
    }

    /**
     * @param id
     * @return 根据ID查询会员作品
     */
    public MemberWorks findById(Long id) {
        return memberWorksRepository.findById(id);
    }
}
