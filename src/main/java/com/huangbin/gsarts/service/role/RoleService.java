package com.huangbin.gsarts.service.role;

import com.huangbin.gsarts.dao.role.RoleRepository;
import com.huangbin.gsarts.dao.unit.UnitRepository;
import com.huangbin.gsarts.model.common.ReturnObject;
import com.huangbin.gsarts.model.role.Role;
import com.huangbin.gsarts.model.unit.Unit;
import com.huangbin.gsarts.service.common.CommonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色信息接口
 */
@Service
public class RoleService {

    @Autowired
    CommonDataService commonDataService;

    @Autowired
    RoleRepository roleRepository;

    /**
     * @return 查询所有的单位
     */
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    /**
     * @param id
     * @return 根据ID查询单位
     */
    public Role findById(Long id) {
        return roleRepository.findById(id);
    }


    /**
     * @param userIds 用户ID
     * @ 返回用户添加结果
     */
    public ReturnObject addUsers(String userIds) {
        String[] uids = userIds.split(",");


        return commonDataService.getReturnType(true, "", "");
    }


    /**
     * @param resourceIds 资源id
     * @ 返回资源添加结果
     */
    public ReturnObject addResources(String resourceIds) {
        String[] rids = resourceIds.split(",");
        return commonDataService.getReturnType(true, "", "");
    }
}
