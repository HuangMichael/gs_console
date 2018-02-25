package com.huangbin.gsarts.service.unit;

import com.huangbin.gsarts.dao.unit.UnitRepository;
import com.huangbin.gsarts.model.unit.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单位信息接口
 */
@Service
public class UnitService {
    @Autowired
    UnitRepository unitRepository;

    /**
     * @return 查询所有的单位
     */
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    /**
     * @param id
     * @return 根据ID查询单位
     */
    public Unit findById(Long id) {
        return unitRepository.findById(id);
    }


    /**
     * @param save
     * @return 保存单位
     */
    public Unit save(Unit save) {
        return unitRepository.save(save);
    }
}
