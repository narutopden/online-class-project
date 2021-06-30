package com.onlineclass.tibet_online_class.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OCException extends RuntimeException{

    private Integer code;
    private String msg;

}

