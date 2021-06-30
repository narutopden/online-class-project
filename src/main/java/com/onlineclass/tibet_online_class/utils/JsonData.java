package com.onlineclass.tibet_online_class.utils;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {

    // 0 means success,-1 means failure, 1 mean processing
    private Integer code;

    // business data
    private Object data;

    //message
    private String msg;

//    public JsonData(Integer code, Object data, String msg){
//        this.code = code;
//        this.data = data;
//        this.msg = msg;
//    }
    /**
     * Sucessful
     * @return
     */
    public  static  JsonData buildSuccess(){
        return new JsonData(0,null,null);
    }

    /**
     * Sucessful
     * @param data
     * @return data
     */
    public  static JsonData buildSuccess(Object data){
        return new JsonData(0,data,null);
    }

    /**
     * build Failure
     *
     * @param msg
     * @return  error message
     */
    public static JsonData buildError(String msg){
        return new JsonData(-1,null,msg);
    }

    /**
     * build Failure
     * @param code
     * @param msg
     * @return  error code and message
     */
    public static JsonData buildError(Integer code ,String msg){
        return new JsonData(code,null,msg);
    }


}
