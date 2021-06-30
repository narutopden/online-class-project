package com.onlineclass.tibet_online_class.exception;


import com.onlineclass.tibet_online_class.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomException {

    private final static Logger logger = LoggerFactory.getLogger(CustomException.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handler(Exception e){
        logger.error("[ System Error ----------------  ] {"+e+"} ");
        if (e instanceof OCException){
            OCException ocException = (OCException) e;
            return JsonData.buildError(ocException.getCode(), ocException.getMsg());
        }else {
            return  JsonData.buildError("Internal Unknown Error");
        }
    }
}
