package com.onlineclass.tibet_online_class.interception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineclass.tibet_online_class.utils.JWTUtils;
import com.onlineclass.tibet_online_class.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * method to check the token before getting to controller
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null){
                accessToken = request.getParameter("token");
            }
            if (StringUtils.isNotBlank(accessToken)){
                Claims claims = JWTUtils.checkJWT(accessToken);
                if (claims == null){
                    // we need to inform login again
                    sendJsonMessage(response, JsonData.buildError("login expired, login again"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");

                request.setAttribute("id",id);
                request.setAttribute("name",name);

                return true;
            }
        }catch (Exception e){}

        sendJsonMessage(response, JsonData.buildError("login expired, login again"));
        return false;
    }

    /**
     * returning the data to the frontend to
     * @param response
     * @param object
     */
    public static void sendJsonMessage(HttpServletResponse response, Object object){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println(objectMapper.writeValueAsString(object));
            writer.close();
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
