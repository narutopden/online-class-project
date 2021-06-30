package com.onlineclass.tibet_online_class.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VideoOrderRequest {
    @JsonProperty("video_id")
    private Integer videoId;
}
