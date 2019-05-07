package com.github.hps.rabbitmq;

import com.github.hps.bean.User;
import lombok.Data;

/**
 * 消息体
 */
@Data
public class SeckillMessage {
    private User user;
    private long goodsId;

}
