package com.onlineclass.tibet_online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Integer id;

    private String name;

    @JsonIgnore
    private String pwd;

    @JsonProperty("head_img")
    private String headImg;

    private String phone;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8" )
    private Date createTime;

}
