package com.github.hps.redis;

public class HpsCreditsKey extends BasePrefix {

    public static final int HPS_CREDITS_LIST = 60*5;//缓存5分钟
    public static final int HPS_CREDITS_COUNT = 60*5;//缓存5分钟
    /**
     * 防止被外面实例化
     */
    private HpsCreditsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static HpsCreditsKey List = new HpsCreditsKey(HPS_CREDITS_LIST,"hpsCreditsList");
    public static HpsCreditsKey HpsCred = new HpsCreditsKey(HPS_CREDITS_COUNT,"hpsCreditsCount");
}
