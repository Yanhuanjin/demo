package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：Yanhuanjin
 * @version :
 * @date ：Created in 2021/2/20 10:44
 * @description ：
 * @modified By：
 */
@Repository
@Mapper
public interface UserMapper {
    int addUser(User user);
    List<User> queryByUsername(String username);
}
