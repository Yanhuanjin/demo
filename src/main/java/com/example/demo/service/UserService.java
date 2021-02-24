package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @author ：Yanhuanjin
 * @version :
 * @date ：Created in 2021/2/20 10:12
 * @description ：
 * @modified By：
 */
public interface UserService {
    int addUser(String username, String password, String phone);
    List<User> queryByUsername(String username);
}
