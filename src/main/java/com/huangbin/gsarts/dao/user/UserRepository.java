package com.huangbin.gsarts.dao.user;

import com.huangbin.gsarts.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息接口
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @return 查询所有的用户
     */
    List<User> findAll();

    /**
     * @param id
     * @return 根据ID查询用户
     */
    User findById(Long id);


    /**
     * @param userName
     * @param password
     * @return
     */
    List<User> findByUserNameAndPassword(String userName,String password);
}
