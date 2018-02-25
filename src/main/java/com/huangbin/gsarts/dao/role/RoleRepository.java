package com.huangbin.gsarts.dao.role;

import com.huangbin.gsarts.model.role.Role;
import com.huangbin.gsarts.model.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色信息接口
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * @return 查询所有的单位
     */
    List<Role> findAll();

    /**
     * @param id
     * @return 根据ID查询单位
     */
    Role findById(Long id);
}
