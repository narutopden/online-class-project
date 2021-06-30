package com.onlineclass.tibet_online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class VideoBanner {
    private int id;
    private String url;
    private String img;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8" )
    private Date createTime;

    private int weight;
}
