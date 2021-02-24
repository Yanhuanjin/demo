package com.example.demo.controller;

import com.example.demo.entity.Response;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：Yanhuanjin
 * @version :
 * @date ：Created in 2021/2/20 10:14
 * @description ：
 * @modified By：
 */
@RestController
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response register(@RequestBody Map<String, String> person){
        String username = person.get("username");
        String password = person.get("password");
        String phone = person.get("phone");
        // 1 判断用户名、密码、手机号是否为空
        if (username != null && password != null && phone != null){
            List<User> users = service.queryByUsername(username);
            // 2 判断是否有重复用户名
            if (users!=null && users.size()>0){
                return new Response("注册失败,用户名重复,请更换", -1, true);
            }else {
                int count = service.addUser(username, password, phone);
                if (count>0){
                    // 3 没有重复用户名，注册成功
                    return new Response("注册成功", 1, true);
                }else{
                    return new Response("注册失败", -1, false);
                }
            }
        }else{
            return new Response("注册失败,请检查用户名、密码、手机号是否为空", -1, false);
        }
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Response login(@RequestBody Map<String, String> person){
        String username = person.get("username");
        String password = person.get("password");
        // 1 判断用户名、密码是否为空
        if (username != null && password != null){
            List<User> users = service.queryByUsername(username);
            // 2 判断用户名是否存在
            if (users!=null && users.size()>0){
                User user = users.get(0);
                // 3 判断密码是否正确
                if (password.equals(user.getPassword())){
                    return new Response("登录成功", 1, true);
                }else{
                    return new Response("登录失败，密码错误", -1, false);
                }
            }else{
                return new Response("登录失败,用户名不存在", -1, false);
            }
        }else{
            return new Response("登录失败，请检查用户名密码是否为空", -1, false);
        }
    }
}
