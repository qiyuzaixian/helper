package com.github.hps.service;

import com.github.hps.bean.HpsCreditsRecord;
import com.github.hps.bean.HpsCreditsRule;
import com.github.hps.bean.HpsCreditsType;
import com.github.hps.bean.User;
import com.github.hps.mapper.HpsCreditsMapper;
import com.github.hps.redis.HpsCreditsKey;
import com.github.hps.redis.RedisService;
import com.github.hps.redis.UserKey;
import com.github.hps.util.SnowFlakeIdGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class HpsCreditsService {
    HpsCreditsMapper hpsCreditsMapper;
    RedisService redisService;

    public Map<String,Object> getHpsCreditsPage(Integer pageNum,Integer pageSize,String token){
        User user=redisService.get(UserKey.token, token, User.class);
        Map<String,Object> data= redisService.get(HpsCreditsKey.List, token+pageNum, Map.class);//获取redis缓存数据
        if(data!=null){
            return data;
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", user.getUserId());
            if (pageNum == 1) {
                map.put("start", 0);
            } else if (pageNum > 1) {
                map.put("start", pageNum * pageSize - pageSize);
            }
            map.put("limit", pageSize);
            Map<String,Object> resultMap=new HashMap<String, Object>();
            resultMap.put("dataSize",hpsCreditsMapper.getHpsCreditsCount(user.getUserId()));
            resultMap.put("data",hpsCreditsMapper.getHpsCreditsPage(map));
            resultMap.put("myCredits",getMyHpsCredits(user.getUserId()));
            redisService.set(HpsCreditsKey.List,token+pageNum,resultMap);
            return resultMap;
        }
    }

    @Transactional
    public Boolean setHpsCredits(Integer type,Long userId,Double score){
       try{
           HpsCreditsType hpsCreditsType=hpsCreditsMapper.getHpsCreditsType(type);
           List<HpsCreditsRule> list=hpsCreditsMapper.getHpsCreditsRule(type);
           SnowFlakeIdGenerator snowFlakeIdGenerator=new SnowFlakeIdGenerator(0);
           Long id=snowFlakeIdGenerator.generateId();
           if(type==1){//考试积分
               for(HpsCreditsRule hpsCreditsRule:list){
                   if(hpsCreditsRule.getMaxValue()>=score&&hpsCreditsRule.getMinValue()<=score){
                       hpsCreditsMapper.saveHpsCreditsRecord(getHpsCreditsRecord(id,type,userId,hpsCreditsType.getCreditsTypeName(),hpsCreditsRule.getCreditsValue()));
                   }
               }
           }else if(type==2){//登录积分
               Map<String,Object> map=new HashMap<String, Object>();
               map.put("userId",userId);
               map.put("nowDate",new Date());
               map.put("type",type);
               if(hpsCreditsMapper.getLoginRecord(map)==0){
                   hpsCreditsMapper.saveHpsCreditsRecord(getHpsCreditsRecord(id,type,userId,hpsCreditsType.getCreditsTypeName(),list.get(0).getCreditsValue()));
               }
           }
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }

    public HpsCreditsRecord getHpsCreditsRecord(Long id,Integer type,Long userId,String typeName,Long credits){
        HpsCreditsRecord hpsCreditsRecord=new HpsCreditsRecord();
        Date date=new Date();
        hpsCreditsRecord.setId(id);
        hpsCreditsRecord.setUserId(userId);
        hpsCreditsRecord.setCreateOper(1L);
        hpsCreditsRecord.setCreditsRecordId(1L);
        hpsCreditsRecord.setCreditsBehaviorId(1L);
        hpsCreditsRecord.setCreditsType(type);
        hpsCreditsRecord.setCreditsRuleId(1L);
        hpsCreditsRecord.setDelFlag(1);
        hpsCreditsRecord.setCreditsState(1);
        hpsCreditsRecord.setCreditsContent(typeName);
        hpsCreditsRecord.setCreateDt(date);
        hpsCreditsRecord.setCreditsValue(credits);
        hpsCreditsRecord.setCreditsDt(date);
        hpsCreditsRecord.setUpdateDt(date);
        hpsCreditsRecord.setRemarks("");
        hpsCreditsRecord.setUpdateOper(1L);
        hpsCreditsRecord.setStatus(1);
        return hpsCreditsRecord;
    }
    public Map<String,Object> getMyHpsCredits(Long userId){
        Integer HpsCredits=redisService.get(HpsCreditsKey.HpsCred, userId.toString(), Integer.class);
        if(HpsCredits==null){
            HpsCredits=hpsCreditsMapper.getHpsCreditsSum(userId);
        }
        Map map=new HashMap<String, Object>();
        map.put("hpsCredits",HpsCredits);
        return map;
    }
}