package com.onlineclass.tibet_online_class.utils;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Data
public class BaseCache {
//code speaks for it self
    private Cache<String,Object> tenMinCache = CacheBuilder.newBuilder()
            // setting the capacity of the cache
            .initialCapacity(10)
            .maximumSize(100)
            .concurrencyLevel(5)
            .expireAfterWrite(600, TimeUnit.SECONDS)
            .recordStats()
            .build();

    //cache for one hour
    private Cache<String,Object> oneHourCache = CacheBuilder.newBuilder()
            .initialCapacity(10)
            .maximumSize(100)
            .concurrencyLevel(5)
            .expireAfterWrite(3600,TimeUnit.SECONDS)
            .recordStats()
            .build();
}
