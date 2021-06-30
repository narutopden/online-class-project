package com.onlineclass.tibet_online_class.service.impl;

import com.onlineclass.tibet_online_class.exception.OCException;
import com.onlineclass.tibet_online_class.mapper.*;
import com.onlineclass.tibet_online_class.model.entity.Episode;
import com.onlineclass.tibet_online_class.model.entity.PlayRecord;
import com.onlineclass.tibet_online_class.model.entity.Video;
import com.onlineclass.tibet_online_class.model.entity.VideoOrder;
import com.onlineclass.tibet_online_class.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private EpisodeMapper episodeMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private PlayRecordMapper playRecordMapper;


    /**
     * order process
     * but in future version will add coupons , user category, we
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional // to make sure rollback if there is no episode for the chapter video
    public int save(Integer userId, Integer videoId) {
        /**
         * state = 1/0
         * 1= payed
         * 0= yet to pay
         */
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        // if the video user didn't bought the video before then its means
        // videoOrder == null and if not null its already bought
        if (videoOrder != null){
            return 0;
        }
        Video video = videoMapper.findById(videoId);
        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString()); // Order unique identification
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int row = videoOrderMapper.saveOrder(newVideoOrder);

        if (row == 1){ //if video order is success
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if (episode == null){
                throw new OCException(-1,"order failed, there is no episode in this video class");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setEpisodeId(episode.getId());
            playRecord.setVideoId(videoId);
            playRecordMapper.saveRecord(playRecord);
        }
        return row;
    }

    @Override
    public List<VideoOrder> orderList(Integer userId) {
        List<VideoOrder> videoOrder = videoOrderMapper.orderList(userId);
        return videoOrder;
    }
}
