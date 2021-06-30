package com.onlineclass.tibet_online_class.service.impl;

import com.onlineclass.tibet_online_class.model.entity.User;
import com.onlineclass.tibet_online_class.mapper.UserMapper;
import com.onlineclass.tibet_online_class.service.UserService;
import com.onlineclass.tibet_online_class.utils.CommonUtils;
import com.onlineclass.tibet_online_class.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * saving the user information
     * @param userInfo
     * @return 1 for true and 0 for failure
     */
    @Override
    public int saveUser(Map<String, String> userInfo) {
        User user = parsToUser(userInfo);
        if (user != null){
            return userMapper.saveUser(user);
        }else{
            return -1;
        }
    }

    /**
     * parsing user information from userInfo
     * @param userInfo
     * @return
     */
    private User parsToUser(Map<String, String> userInfo) {
        if(userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")){
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(Avatar());
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            user.setPwd(CommonUtils.MD5(pwd));

            return user;
        }else {
            return null;
        }
    }


    /**
     * random profile picture
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    /**
     * avatar random producer
     * @return
     */
    public String Avatar(){
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }

    /**
     * looking for user
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
       User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
       if (user == null){
           return null;
       }else {
           String token = JWTUtils.generateJsonToken(user);
           return token;
       }
    }

    @Override
    public User findUserById(Integer userId) {
        User user = userMapper.findUserById(userId);
        return user;
    }
}
