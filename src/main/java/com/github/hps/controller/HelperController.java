package com.github.hps.controller;


import com.github.hps.bean.HelperInfo;
import com.github.hps.redis.RedisService;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.service.HelperService;
import com.github.hps.result.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/helper")
public class HelperController {

    RedisService redisService;
    HelperService helperService;

    @RequestMapping("/getHelperList")//历史版本
    @ResponseBody
    public Result<Map<String,Object>> getHelperList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("id")Long id ,@RequestParam("typeId")Integer typeId,@RequestParam ("token") String token) {
        try {
            return helperService.getHelperList(pageNum,pageSize,id,typeId,1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @RequestMapping("/getNewHelperList")//新接口，
    @ResponseBody
    public Result<Map<String,Object>> getNewHelperList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("id")Long id ,@RequestParam("typeId")Integer typeId,@RequestParam ("token") String token) {
        try {
            return helperService.getHelperList(pageNum,pageSize,id,typeId,2);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }




    @RequestMapping("/searchHelperList")//搜索产品
    @ResponseBody
    public Result<Map<String,Object>> searchHelperList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam ("search") String search) {
        try {
            return helperService.getSearchHelperList(pageNum,pageSize,search);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


    @RequestMapping("/getHelperInfo")
    @ResponseBody
    public Result<HelperInfo> getHelperInfo(@RequestParam("id")Long id , @RequestParam ("token") String token) {
        try {
            return helperService.getHelperInfo(id,token);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/recordRead")//播放记录次数
    @ResponseBody
    public Result<Boolean> recordRead(@RequestParam("id")Long id) {
        try {
             helperService.recordRead(id);
             return Result.success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/recordPraise")//点赞
    @ResponseBody
    public Result<Message> recordPraise(@RequestParam("id")Long id, @RequestParam ("token") String token) {
        try {
            Message msg=new Message();
            msg.setMessage(helperService.recordPraise(id,token));
            return Result.success(msg);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/getVideoList")//资讯接口
    @ResponseBody
    public Result<Map<String,Object>> getVideoList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize) {
        try {
            return helperService.getHelperVoidList(pageNum,pageSize,4L,4);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/getCourseList")//线上课程
    @ResponseBody
    public Result<Map<String,Object>> getCourseList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize) {
        try {
            return helperService.getHelperClassificationList(pageNum,pageSize,1L,1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @RequestMapping("/getLearningList")//学习路径
    @ResponseBody
    public Result<Map<String,Object>> getLearningList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize) {
        try {
            return helperService.getHelperClassificationList(pageNum,pageSize,3L,3);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @RequestMapping("/getCasesList")//病例分析
    @ResponseBody
    public Result<Map<String,Object>> getCasesList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize) {
        try {
            return helperService.getHelperClassificationList(pageNum,pageSize,2L,2);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


}
