package com.onlineclass.tibet_online_class.controller;

import com.onlineclass.tibet_online_class.model.entity.Video;
import com.onlineclass.tibet_online_class.model.entity.VideoBanner;
import com.onlineclass.tibet_online_class.service.VideoService;
import com.onlineclass.tibet_online_class.utils.BaseCache;
import com.onlineclass.tibet_online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;



    /**
     * video banner img
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner(){
        List<VideoBanner> bannerList = videoService.listBanner();
        return JsonData.buildSuccess(bannerList);
    }

    /**
     * sgetting the list of video
     * @return
     */
    @RequestMapping("list")
    public JsonData listVideo(){

        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);
    }

    /**
     * getting the details of video through there id
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public  JsonData findDetailById(@RequestParam( value = "video_id" , required = true) int videoId){
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }
}
