package com.onlineclass.tibet_online_class.mapper;

import com.onlineclass.tibet_online_class.model.entity.Video;
import com.onlineclass.tibet_online_class.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface VideoMapper {

    /**
     * to fatch all the videos
     * @return
     */
    List<Video> listVideo();

    /**
     * fetching the video banner
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * getting the details video base on given videoId
     * @param videoId
     * @return
     */
    Video findDetailById(@Param( value = "video_id") int videoId);

    /**
     * find video by id
     * @param videoId
     * @return
     */
    Video findById(@Param( value = "video_id") Integer videoId);
}
