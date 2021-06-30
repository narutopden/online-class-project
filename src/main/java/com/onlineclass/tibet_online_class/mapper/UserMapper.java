package com.onlineclass.tibet_online_class.mapper;

import com.onlineclass.tibet_online_class.model.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int  saveUser(User user);

    User findByPhone(@Param("phone") String phone);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd")String pwd);

    User findUserById(@Param("id") Integer userId);
}
