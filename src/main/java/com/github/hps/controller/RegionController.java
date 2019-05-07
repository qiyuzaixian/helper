package com.github.hps.controller;

import com.github.hps.bean.Region;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Controller
@RequestMapping("/region")
public class RegionController {
    RegionService regionService;
    @ResponseBody
    @RequestMapping("/getProvinceList")
    public Result<Map<String, Object>> getProvinceList() {
        try{
            List<Region> mapList = regionService.getProvinceList();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("item",mapList);
            return Result.success(map);
        }catch(Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @ResponseBody
    @RequestMapping("/getCityList")
    public Result<Map<String, Object>>  getCityList(@RequestParam("regionCode") Integer regionCode) {
        try{
            Map<String,Object> map=new HashMap<String,Object>();
            if (regionCode != null) {
                String temp = regionCode.toString();
                regionCode = Integer.valueOf(temp.substring(0, 2));
                List<Region> mapList = regionService.getCityList(regionCode);
                map.put("item",mapList);
            }
            return Result.success(map);
        }catch(Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @ResponseBody
    @RequestMapping("/getAreaList")
    public Result<Map<String, Object>>  getOrgTree(@RequestParam("regionCode") Integer regionCode) {
        try{
            Map<String,Object> map=new HashMap<String,Object>();
            if (regionCode != null) {
                String temp = regionCode.toString();
                Integer province = Integer.valueOf(temp.substring(0, 2));
                regionCode = Integer.valueOf(temp.substring(2, 4));
                regionCode = province*100+regionCode;
                List<Region> mapList = regionService.getAreaList(regionCode);
                map.put("item",mapList);
            }
            return Result.success(map);
        }catch(Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
