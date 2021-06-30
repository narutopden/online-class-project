package com.onlineclass.tibet_online_class.mapper;

import com.onlineclass.tibet_online_class.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoOrderMapper {

    /**
     * check whether the user has purchases this product or not
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id")Integer userId,
                                              @Param("video_id") Integer videoId,
                                              @Param("state") Integer state);

    /**
     * ordering video
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * fetches the order list of given user id
     * @param userId  given user id
     * @return
     */
    List<VideoOrder> orderList(@Param("user_id") Integer userId);
}
