package com.github.hps.controller;

import com.github.hps.rabbitmq.MQSender;
import com.github.hps.redis.RedisService;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.service.VersionService;
import com.github.hps.vo.VersionVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller


@AllArgsConstructor
@RequestMapping("/version")
public class VersionController {

    RedisService redisService;
    MQSender sender;
    VersionService versionService;
    @ResponseBody
    @RequestMapping("/getVersion")
    public Result<VersionVo> getVersion() {
        try {
            return Result.success(versionService.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
