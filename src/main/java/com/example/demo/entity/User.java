package com.example.demo.entity;

import javax.jws.soap.SOAPBinding;

/**
 * @author ：Yanhuanjin
 * @version :     1.0
 * @date ：Created in 2021/2/20 10:09
 * @description ：用户类
 * @modified By：
 */
public class User {
    public String username;
    public String password;
    public String phone;

    public User() {
    }

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
