package com.huangbin.gsarts.controller.unit;


import com.huangbin.gsarts.controller.base.BaseController;
import com.huangbin.gsarts.model.unit.Unit;
import com.huangbin.gsarts.service.unit.UnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单位控制器
 */
@RestController
@RequestMapping(value = "/api/unit")
@Slf4j
public class UnitController extends BaseController {

    @Autowired
    UnitService unitService;

    /**
     * @return 查询所有的单位信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Unit> findAll() {
        return unitService.findAll();
    }


    /**
     * @return 查询所有的单位信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Unit findById(@PathVariable Long id) {
        return unitService.findById(id);
    }


    /**
     * @return 保存的单位信息
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Unit save(@RequestBody Unit unit) {
        log.info("unit----------------" + unit.toString());
        return unitService.save(unit);
    }


}
