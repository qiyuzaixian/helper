package com.github.hps.controller;

import com.github.hps.redis.RedisService;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.service.HpsCreditsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/hpsCredits")
public class HpsCreditsController {

    HpsCreditsService hpsCreditsService;
    RedisService redisService;

    @ResponseBody
    @RequestMapping("/getHpsCreditsPage")
    public Result<Map<String,Object>> getHpsCreditsPage(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, @RequestParam ("token") String token){
        try {
            return Result.success(hpsCreditsService.getHpsCreditsPage(pageNum,pageSize,token));
        }catch(Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
