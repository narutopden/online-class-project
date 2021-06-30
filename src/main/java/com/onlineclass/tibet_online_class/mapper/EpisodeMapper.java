package com.onlineclass.tibet_online_class.mapper;

import com.onlineclass.tibet_online_class.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {

    Episode findFirstEpisodeByVideoId (@Param("video_id") Integer videoId);
}
