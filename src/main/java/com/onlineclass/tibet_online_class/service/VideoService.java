package com.onlineclass.tibet_online_class.service;

import com.onlineclass.tibet_online_class.model.entity.Video;
import com.onlineclass.tibet_online_class.model.entity.VideoBanner;


import java.util.List;
public interface VideoService {
    /**
     *
     * @return
     */
    List<Video> listVideo();

    /**
     * main page video banner
     * @return
     */
    List<VideoBanner> listBanner();

    /**
     * getting the details video base on given videoId
     * @param videoId
     * @return
     */
    Video findDetailById(int videoId);
}
