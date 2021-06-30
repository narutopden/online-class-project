package com.onlineclass.tibet_online_class.controller;

import com.onlineclass.tibet_online_class.model.entity.User;
import com.onlineclass.tibet_online_class.model.request.LoginRequest;
import com.onlineclass.tibet_online_class.service.UserService;
import com.onlineclass.tibet_online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo){
      int success =  userService.saveUser(userInfo);
      return success == 1 ? JsonData.buildSuccess() : JsonData.buildError("fail to register user");

    }

    /**
     * login endpoint
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
       String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());

       return token == null ? JsonData.buildError("Unable to login, ID or password Incorrect") : JsonData.buildSuccess(token);
    }

    /**
     * searching user data though user id
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findByToken(HttpServletRequest request){
        Integer userId = (int) request.getAttribute("id");
        if (userId == null){
            return JsonData.buildError("search fail");
        }
        User user = userService.findUserById(userId);

        return JsonData.buildSuccess(user);
    }
}
