package com.github.hps.redis;

public class UserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*24 *2;//默认两天
    public static final int TOKEN_ID = 3600*12;//默认两天
    public static final int TOKEN_USER = 3600*24 *2;//默认两天

    /**
     * 防止被外面实例化
     */
    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static UserKey token = new UserKey(TOKEN_EXPIRE,"token");
    public static UserKey getById = new UserKey(TOKEN_ID, "id");

    public static UserKey employeeId = new UserKey(TOKEN_USER,"emoloyeeId");

}
