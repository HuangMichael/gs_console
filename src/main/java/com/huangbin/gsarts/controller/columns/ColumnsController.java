package com.huangbin.gsarts.controller.columns;


import com.huangbin.gsarts.controller.base.BaseController;
import com.huangbin.gsarts.model.columns.Columns;
import com.huangbin.gsarts.model.unit.Unit;
import com.huangbin.gsarts.service.columns.ColumnsService;
import com.huangbin.gsarts.service.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 栏目控制器
 */
@RestController
@RequestMapping(value = "/columns")
public class ColumnsController extends BaseController {

    @Autowired
    ColumnsService columnsService;
    /**
     * @return 查询所有的栏目信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Columns> findAll() {
        return columnsService.findAll();
    }


    /**
     * @return 查询所有的栏目信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Columns findById(@PathVariable Long id) {
        return columnsService.findById(id);
    }


}
