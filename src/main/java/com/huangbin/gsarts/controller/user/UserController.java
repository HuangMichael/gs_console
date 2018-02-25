package com.huangbin.gsarts.controller.user;


import com.huangbin.gsarts.controller.base.BaseController;
import com.huangbin.gsarts.model.user.User;
import com.huangbin.gsarts.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * @return 查询所有的用户信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }


    /**
     * @return 查询所有的用户信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }


}
