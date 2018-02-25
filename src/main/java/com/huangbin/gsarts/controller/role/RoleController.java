package com.huangbin.gsarts.controller.role;


import com.huangbin.gsarts.controller.base.BaseController;

import com.huangbin.gsarts.model.common.ReturnObject;
import com.huangbin.gsarts.model.role.Role;
import com.huangbin.gsarts.service.common.CommonDataService;
import com.huangbin.gsarts.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制器
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Autowired
    RoleService roleService;

    @Autowired
    CommonDataService commonDataService;


    /**
     * @return 查询所有的角色信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Role> findAll() {
        return roleService.findAll();
    }


    /**
     * @return 根据角色id查询角色信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role findById(@PathVariable Long id) {
        return roleService.findById(id);
    }


    /**
     * @return 给角色添加用户
     */
    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public ReturnObject addUsers(@RequestParam String userIds) {
        return roleService.addUsers(userIds);
    }



    /**
     * @return 给角色添加用户
     */
    @RequestMapping(value = "/addResources", method = RequestMethod.POST)
    public ReturnObject addResources(@RequestParam String userIds) {
        return roleService.addResources(userIds);
    }



}
