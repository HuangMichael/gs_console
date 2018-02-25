package com.huangbin.gsarts.service.user;


import com.huangbin.gsarts.dao.user.UserRepository;
import com.huangbin.gsarts.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息服务
 */
@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    /**
     * @return
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }



    /**
     * @return
     */
    public List<User> findByUserNameAndPassword(String userName,String password) {
        return userRepository.findAll();
    }


    /**
     * @param id 用户ID
     * @return 根据用户id查询
     */
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
