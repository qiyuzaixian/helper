package com.github.hps.util;

import java.util.UUID;
/**
 * <p>
 * 唯一id生成类
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
