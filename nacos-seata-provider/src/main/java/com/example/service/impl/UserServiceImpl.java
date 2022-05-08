package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA2021.3
 * @Author: Tenghw
 * @Date: 2022/05/01  14:19
 * @Description:
 */
@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    //分布式事务注解
    @GlobalTransactional(name = "default",rollbackFor = Exception.class)
    @Override
//    @Transactional
    public User getOneUserById(int id) {

        System.out.println(1/0);
        return userMapper.getOne(id);
    }
}
