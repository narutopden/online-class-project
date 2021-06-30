package com.onlineclass.tibet_online_class.service;

import com.onlineclass.tibet_online_class.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {
    int save(Integer userId, Integer videoId);

    List<VideoOrder> orderList(Integer userId);
}
