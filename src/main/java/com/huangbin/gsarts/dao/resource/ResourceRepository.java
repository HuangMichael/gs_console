package com.huangbin.gsarts.dao.resource;

import com.huangbin.gsarts.model.resource.Resource;
import com.huangbin.gsarts.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源信息接口
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    /**
     * @return 查询所有的资源
     */
    List<Resource> findAll();

    /**
     * @param id
     * @return 根据ID查询资源
     */
    Resource findById(Long id);
}
