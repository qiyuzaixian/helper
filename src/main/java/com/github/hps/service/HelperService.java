package com.github.hps.service;

import com.github.hps.bean.*;
import com.github.hps.mapper.HelperMapper;
import com.github.hps.redis.RedisService;
import com.github.hps.redis.UserKey;
import com.github.hps.result.Result;
import com.github.hps.util.FileChangeUrl;
import com.github.hps.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class HelperService {
    @Autowired
    FileChangeUrl fileChangeUrl;
    HelperMapper helperMapper;
    RedisService redisService;

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param id
     * @param typeId
     * @param type
     * @return
     */
    public Result<Map<String, Object>> getHelperList(Integer pageNum, Integer pageSize, Long id, Integer typeId,Integer type) {
        HelperInfo helperInfo = new HelperInfo();
        helperInfo.setId(id);
        helperInfo.setTypeId(typeId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (pageNum == 1) {
            map.put("start", 0);
        } else if (pageNum > 1) {
            map.put("start", pageNum * pageSize - pageSize);
        }
        map.put("limit", pageSize);
        map.put("helperInfo", helperInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(type==1){//历史接口
            List<HelperInfoVoVersion1> list = helperMapper.getHelperList(map);
            for (HelperInfoVoVersion1 helperInfoVoVersion1 : list) {
                helperInfoVoVersion1.setFileUrl(fileChangeUrl.changeFileUrl(helperInfoVoVersion1.getFileUrl()));
            }
            resultMap.put("data", list);
        }else{//现有接口
            List<HelperInfoVoVersion2> list = helperMapper.getNewHelperList(map);
            for (HelperInfoVoVersion2 helperInfoVoVersion2 : list) {
                helperInfoVoVersion2.setFileUrl(fileChangeUrl.changeFileUrl(helperInfoVoVersion2.getFileUrl()));
            }
            resultMap.put("data", list);
        }
        resultMap.put("dataSize", helperMapper.getHelperCount(map));
        return Result.success(resultMap);
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Result<Map<String, Object>> getSearchHelperList(Integer pageNum, Integer pageSize,String search) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (pageNum == 1) {
            map.put("start", 0);
        } else if (pageNum > 1) {
            map.put("start", pageNum * pageSize - pageSize);
        }
        if(search!=null&&!"".equals(search))
            map.put("search",search);
        map.put("limit", pageSize);
        Map<String, Object> resultMap = new HashMap<String, Object>();
            List<HelperInfoVoVersionNew> list = helperMapper.getSearchHelperList(map);
            for (HelperInfoVoVersionNew helperInfoVoVersionNew : list) {
                helperInfoVoVersionNew.setFileUrl(fileChangeUrl.changeFileUrl(helperInfoVoVersionNew.getFileUrl()));
            }
            resultMap.put("data", list);
        resultMap.put("dataSize", helperMapper.getSearchHelperCount(map));

        return Result.success(resultMap);
    }


    public Result<Map<String, Object>> getHelperVoidList(Integer pageNum, Integer pageSize, Long id, Integer typeId) {
        HelperInfo helperInfo = new HelperInfo();
        helperInfo.setId(id);
        helperInfo.setTypeId(typeId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (pageNum == 1) {
            map.put("start", 0);
        } else if (pageNum > 1) {
            map.put("start", pageNum * pageSize - pageSize);
        }
        map.put("limit", pageSize);
        map.put("helperInfo", helperInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<HelperInfoVoidVo> list = helperMapper.getHelperVoidList(map);
        for (HelperInfoVoidVo helperInfoVoidVo : list) {
            helperInfoVoidVo.setImageUrl(fileChangeUrl.changeFileUrl(helperInfoVoidVo.getImageUrl()));
            helperInfoVoidVo.setFileUrl(fileChangeUrl.changeFileUrl(helperInfoVoidVo.getFileUrl()));
        }
        resultMap.put("dataSize", helperMapper.getHelperCount(map));
        resultMap.put("data", list);
        return Result.success(resultMap);
    }

    public Result<Map<String, Object>> getHelperClassificationList(Integer pageNum, Integer pageSize, Long id, Integer typeId) {
        HelperInfo helperInfo = new HelperInfo();
        helperInfo.setId(id);
        helperInfo.setTypeId(typeId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (pageNum == 1) {
            map.put("start", 0);
        } else if (pageNum > 1) {
            map.put("start", pageNum * pageSize - pageSize);
        }
        map.put("limit", pageSize);
        map.put("helperInfo", helperInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<HelperInfoClassificationVo> list = helperMapper.getHelperClassificationList(map);
        resultMap.put("dataSize", helperMapper.getHelperCount(map));
        resultMap.put("data", list);
        return Result.success(resultMap);
    }


    public Result<HelperInfo> getHelperInfo(Long id, String token) {
        HelperInfo helperInfo = helperMapper.getHelperInfo(id);
        return Result.success(helperInfo);
    }

    @Transactional
    public void recordRead(Long id) {
        helperMapper.recordRead(id);
    }
    @Transactional
    public String recordPraise(Long id,String token) {
        User user=redisService.get(UserKey.token, token, User.class);
        HpsPraise hpsPraise=new HpsPraise();
        hpsPraise.setId(id);
        hpsPraise.setEmployeeId(user.getEmployeeId());
        hpsPraise.setUserId(user.getUserId());
        if(helperMapper.selectPraiseIsExist(hpsPraise)>0){
            return "已经点过赞了！";
        }else{
            helperMapper.insertPraise(hpsPraise);
            helperMapper.recordPraise(id);
            return "点赞成功！";
        }
    }
    @Transactional
    public String saveStartTime(Long id,String token) {
        User user=redisService.get(UserKey.token, token, User.class);
        HelperTimes helperTimes=new HelperTimes();
        helperTimes.setHelperId(id);
        helperTimes.setOrgId(user.getOrgId());
        helperTimes.setUserId(user.getUserId());
        helperMapper.saveStartTime(helperTimes);
        return "保存成功！";
    }
    @Transactional
    public String saveEndTime(Long id,String token) {
        User user=redisService.get(UserKey.token, token, User.class);
        HelperTimes helperTimes=new HelperTimes();
        helperTimes.setHelperId(id);
        helperTimes.setOrgId(user.getOrgId());
        helperTimes.setUserId(user.getUserId());
        helperMapper.saveEndTime(helperTimes);
        return "保存成功！";
    }


}
