package com.onlineclass.tibet_online_class.service;

import com.onlineclass.tibet_online_class.model.entity.User;

import java.util.Map;

public interface UserService {

    int  saveUser(Map<String, String> userInfo);

    String findByPhoneAndPwd(String phone, String pwd);

    User findUserById(Integer userId);
}
