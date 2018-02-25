package com.huangbin.gsarts.controller.site;


import com.huangbin.gsarts.controller.base.BaseController;
import com.huangbin.gsarts.model.site.Site;
import com.huangbin.gsarts.model.unit.Unit;
import com.huangbin.gsarts.service.site.SiteService;
import com.huangbin.gsarts.service.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 站点控制器
 */
@RestController
@RequestMapping(value = "/sites")
public class SiteController extends BaseController {

    @Autowired
    SiteService siteService;


    /**
     * @return 保存站点信息
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Site save(@RequestParam("site") Site site) {
        return siteService.save(site);
    }


    /**
     * @return 查询所有的站点信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Site> findAll() {
        return siteService.findAll();
    }

    /**
     * @return 查询所有的站点信息d
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Site findById(@PathVariable Long id) {
        return siteService.findById(id);
    }


    /**
     * @return 查询所有的站点信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        siteService.delete(id);
    }


}
