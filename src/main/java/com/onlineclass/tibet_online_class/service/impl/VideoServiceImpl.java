package com.onlineclass.tibet_online_class.service.impl;

import com.onlineclass.tibet_online_class.config.CacheKeyManager;
import com.onlineclass.tibet_online_class.model.entity.Video;
import com.onlineclass.tibet_online_class.model.entity.VideoBanner;
import com.onlineclass.tibet_online_class.mapper.VideoMapper;
import com.onlineclass.tibet_online_class.service.VideoService;
import com.onlineclass.tibet_online_class.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {

        Object cacheObject = null;
        try {
            cacheObject = baseCache.getTenMinCache().get(CacheKeyManager.INDEX_VIDEO_LIST, () -> {
                List<Video> videoList = videoMapper.listVideo();
                return videoList;
            });

            if (cacheObject instanceof List){
                List<Video> videoList = (List<Video>) cacheObject;
                return videoList;
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {

        try {
            Object cacheObject = baseCache.getTenMinCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> videoBanners = videoMapper.listVideoBanner();
                return videoBanners;
                });

            if (cacheObject instanceof List){
                List<VideoBanner> videoBanners = (List<VideoBanner>) cacheObject;
                return videoBanners;
            }
        }catch ( Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {
        // combining the videoId and cacheId into single String
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAILS,videoId);

        try {
                Object cacheObject = baseCache.getOneHourCache().get(videoCacheKey, () -> {
                    Video video = videoMapper.findDetailById(videoId);
                    return video;
                });
                if (cacheObject instanceof Video) {
                    Video video = (Video) cacheObject;
                    return video;
                }
            }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
