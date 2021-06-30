package com.onlineclass.tibet_online_class.config;

/**
 * cache key manager
 */
public class CacheKeyManager {

    /**
     * cache key for banner poster on the front side
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";

    /**
     * cache key from video list
     */
    public static final String INDEX_VIDEO_LIST = "index:video:list";

    /**
     * cache key for video details through id %s
     * since its need id to check the details we are using this " %s "
     */
    public static final String VIDEO_DETAILS = "video:details:%s";

}