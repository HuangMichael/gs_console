package com.huangbin.gsarts.service.resource;

import com.huangbin.gsarts.dao.resource.ResourceRepository;
import com.huangbin.gsarts.dao.role.RoleRepository;
import com.huangbin.gsarts.model.resource.Resource;
import com.huangbin.gsarts.model.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源信息接口
 */
@Service
public class ResourceService {
    @Autowired
    ResourceRepository resourceRepository;

    /**
     * @return 查询所有的资源
     */
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    /**
     * @param id
     * @return 根据ID查询资源
     */
    public Resource findById(Long id) {

        return resourceRepository.findById(id);
    }
}
