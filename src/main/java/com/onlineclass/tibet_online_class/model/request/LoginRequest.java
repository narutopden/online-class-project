package com.onlineclass.tibet_online_class.model.request;

import lombok.Data;


/**
 * used this entity during login process
 */
@Data
public class LoginRequest {
    private String phone;
    private String pwd;
}
