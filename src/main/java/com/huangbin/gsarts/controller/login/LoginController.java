package com.huangbin.gsarts.controller.login;


import com.huangbin.gsarts.controller.base.BaseController;
import com.huangbin.gsarts.model.common.ReturnObject;
import com.huangbin.gsarts.model.user.User;
import com.huangbin.gsarts.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * @return 查询所有的用户信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public List<User> login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        return userService.findByUserNameAndPassword(userName, password);
    }


    @RequestMapping("/")
    public String logout() {
        return "index";

    }


}
