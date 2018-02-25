package com.huangbin.gsarts.dao.columns;

import com.huangbin.gsarts.model.columns.Columns;
import com.huangbin.gsarts.model.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 栏目信息接口
 */
@Repository
public interface ColumnsRepository extends JpaRepository<Columns, Long> {

    /**
     * @return 查询所有的栏目
     */
    List<Columns> findAll();

    /**
     * @param id
     * @return 根据ID查询栏目
     */
    Columns findById(Long id);


    /**
     * @return 保存栏目
     */
    Columns save(Columns columns);
}
