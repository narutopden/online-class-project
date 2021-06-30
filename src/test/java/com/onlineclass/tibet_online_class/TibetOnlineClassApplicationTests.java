package com.onlineclass.tibet_online_class;

import com.onlineclass.tibet_online_class.model.entity.User;
import com.onlineclass.tibet_online_class.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TibetOnlineClassApplicationTests {

    @Test
    public void testJWT(){
        User user = new User();
        user.setId(44);
        user.setName("lobsang");
        user.setHeadImg("kkk");
        String token = JWTUtils.generateJsonToken(user);
        System.out.println(token);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Claims claims = JWTUtils.checkJWT(token);
        System.out.println(claims.get("name"));
    }

}
