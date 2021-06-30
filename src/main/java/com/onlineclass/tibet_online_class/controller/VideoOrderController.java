package com.onlineclass.tibet_online_class.controller;

import com.onlineclass.tibet_online_class.model.entity.VideoOrder;
import com.onlineclass.tibet_online_class.model.request.VideoOrderRequest;
import com.onlineclass.tibet_online_class.service.VideoOrderService;
import com.onlineclass.tibet_online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * saving order endpoint
     * @return
     */
    @PostMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("id");
        int row = videoOrderService.save(userId, videoOrderRequest.getVideoId());

        return row == 1 ? JsonData.buildSuccess("order successful") : JsonData.buildError("order failed");
    }

    @GetMapping("list")
    public JsonData orderList(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("id");
        List<VideoOrder> videoOrder= videoOrderService.orderList(userId);
        return videoOrder != null ? JsonData.buildSuccess(videoOrder) : JsonData.buildError("no order");
    }
}
