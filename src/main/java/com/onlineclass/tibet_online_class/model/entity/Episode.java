package com.onlineclass.tibet_online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class Episode {
    private Integer id;

    private String title;

    private Integer num;

    private Integer ordered;

    @JsonProperty("play_url")
    private String playUrl;

    @JsonProperty("chapter_id")
    private Integer chapterId;

    private Integer free;

    @JsonProperty("video_id")
    private Integer videoId;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8" )
    private Date createTime;
}
