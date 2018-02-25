package com.huangbin.gsarts.dao.unit;

import com.huangbin.gsarts.model.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 单位信息接口
 */
@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    /**
     * @return 查询所有的单位
     */
    List<Unit> findAll();

    /**
     * @param id
     * @return 根据ID查询单位
     */
    Unit findById(Long id);
}
