package com.huangbin.gsarts.controller.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public abstract class BaseController {

    /**
     * @return 查询所有的信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public abstract List findAll();
}
