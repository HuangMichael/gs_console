package com.huangbin.gsarts.controller.resource;


import com.huangbin.gsarts.controller.base.BaseController;
import com.huangbin.gsarts.model.memberWorks.MemberWorks;
import com.huangbin.gsarts.model.resource.Resource;
import com.huangbin.gsarts.service.memberWorks.MemberWorksService;
import com.huangbin.gsarts.service.resource.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 资源信息控制器
 */
@RestController
@RequestMapping(value = "/resource")
public class ResourceController extends BaseController {

    @Autowired
    ResourceService resourceService;
    /**
     * @return 查询所有的资源信息信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Resource> findAll() {
        return resourceService.findAll();
    }
    /**
     * @return 查询所有的资源信息信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Resource findById(@PathVariable Long id) {
        return resourceService.findById(id);
    }


}
