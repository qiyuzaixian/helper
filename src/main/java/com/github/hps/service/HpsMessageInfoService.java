package com.github.hps.service;

import com.github.hps.mapper.HpsMessageInfoMapper;
import com.github.hps.result.Result;
import com.github.hps.vo.HpsMessageInfoVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class HpsMessageInfoService {

    private HpsMessageInfoMapper hpsMessageInfoMapper;

    public Result<Map<String,Object>> getHpsMessageInfoList(Integer pageNum, Integer pageSize, Integer msgMode){
        Map<String, Object> map = new HashMap<String, Object>();
        if (pageNum == 1) {
            map.put("start", 0);
        } else if (pageNum > 1) {
            map.put("start", pageNum * pageSize - pageSize);
        }
        map.put("limit", pageSize);
        map.put("msgMode", msgMode);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<HpsMessageInfoVo> list= hpsMessageInfoMapper.getHpsMessageInfoList(map);
        for(HpsMessageInfoVo hpsMessageInfoVo:list){
            hpsMessageInfoVo.setShortMessage(hpsMessageInfoVo.getShortMessage().replaceAll("<[.[^>]]*>","").trim());
        }
        resultMap.put("dataSize", list);
        resultMap.put("data", hpsMessageInfoMapper.getHpsMessageInfoCount(map));
        return Result.success(resultMap);
    }

    public Result<HpsMessageInfoVo> getHpsMessageInfoById(Long id){
        return Result.success(hpsMessageInfoMapper.getHpsMessageInfoById(id));
    }

    public Result<HpsMessageInfoVo> getHpsMessageInfoByModeFirst(Integer msgMode){
        return Result.success(hpsMessageInfoMapper.getHpsMessageInfoByModeFirst(msgMode));
    }

}
