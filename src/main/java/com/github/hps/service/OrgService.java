package com.github.hps.service;


import com.github.hps.bean.Org;
import com.github.hps.mapper.OrgMapper;
import com.github.hps.redis.OrgTreeKey;
import com.github.hps.redis.RedisService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import groovy.util.logging.Log4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Log4j
@Service
@AllArgsConstructor
public class OrgService {
    OrgMapper orgMapper;
    RedisService redisService;


    public List<Map<String,Object>> orgService(Integer type){
        //type  1机关，2针剂，3口服，4民康
        List<Map<String, Object>> mapList;
        mapList=redisService.get(OrgTreeKey.ORG_TREE_List,"ORG_TREE_"+type,List.class);
        Long orgId=orgMapper.selectRegisterOrgId(type);
        if(mapList==null){
            List<Org> list=orgMapper.selectOrgByParentOrgId(orgId);
            mapList=new ArrayList<Map<String, Object>>();
            for(Org o:list){
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", o.getOrgId());
                map.put("pId",o.getParentOrgId()!= null?o.getParentOrgId(): 0);
                map.put("name",o.getOrgNm());
                map.put("checked","true");
                mapList.add(map);
            }
            redisService.set(OrgTreeKey.ORG_TREE_List,"ORG_TREE_"+type, mapList);//数据存入redisListCount
        }
        return mapList;
    }

}
