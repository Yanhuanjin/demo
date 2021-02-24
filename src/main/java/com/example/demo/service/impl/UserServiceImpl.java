package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Yanhuanjin
 * @version :
 * @date ：Created in 2021/2/20 10:13
 * @description ：
 * @modified By：
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int addUser(String username, String password, String phone) {
        User user = new User(username, password, phone);
        int count = userMapper.addUser(user);
        return count;
    }

    @Override
    public List<User> queryByUsername(String username) {
        List <User> userList = userMapper.queryByUsername(username);
        return userList;
    }
}
