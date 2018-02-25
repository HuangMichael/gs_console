package com.huangbin.gsarts.dao.site;

import com.huangbin.gsarts.model.site.Site;
import com.huangbin.gsarts.model.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 站点信息接口
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

    /**
     * @return 查询所有的站点
     */
    List<Site> findAll();

    /**
     * @param id
     * @return 根据ID查询站点
     */
    Site findById(Long id);
}
