package com.github.hps.redis;

public class RegionKey extends BasePrefix {

    public static final int REGION_LIST=3600*24*30;//缓存30天
    /**
     * 防止被外面实例化
     */
    private RegionKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static RegionKey REGION_LIST_PROVINCE = new RegionKey(REGION_LIST,"REGION_LIST");
    public static RegionKey REGION_LIST_CITY = new RegionKey(REGION_LIST,"REGION_LIST");
    public static RegionKey REGION_LIST_AREA = new RegionKey(REGION_LIST,"REGION_LIST");
}
