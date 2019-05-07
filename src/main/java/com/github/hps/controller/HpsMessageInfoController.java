package com.github.hps.controller;


import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.service.HpsMessageInfoService;
import com.github.hps.vo.HpsMessageInfoVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/hpsMessageInfo")
public class HpsMessageInfoController {

    HpsMessageInfoService hpsMessageInfoService;

    @ResponseBody
    @RequestMapping("/getHpsMessageInfoList")
    public Result<Map<String,Object>> getHpsMessageInfoList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("msgMode")Integer msgMode) {
        try {
            return hpsMessageInfoService.getHpsMessageInfoList(pageNum,pageSize,msgMode);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/getHpsMessageInfoById")
    public Result<HpsMessageInfoVo> getHpsMessageInfoById(@RequestParam("id")Long id) {
        try {
            return hpsMessageInfoService.getHpsMessageInfoById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/getHpsMessageInfoByModeFirst")
    public Result<HpsMessageInfoVo> getHpsMessageInfoByModeFirst(@RequestParam("msgMode")Integer msgMode) {
        try {
            return hpsMessageInfoService.getHpsMessageInfoByModeFirst(msgMode);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
