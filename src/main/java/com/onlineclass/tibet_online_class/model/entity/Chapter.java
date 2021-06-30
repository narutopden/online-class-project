package com.onlineclass.tibet_online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Chapter {
    private Integer id;
    @JsonProperty("video_id")
    private Integer videoId;
    private String title;
    private Integer ordered;
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8" )
    private Date createTime;
    @JsonProperty("episode_list")
    private List<Episode> episodeList;
}
