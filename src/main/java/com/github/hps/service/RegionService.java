package com.github.hps.service;


import com.github.hps.bean.Org;
import com.github.hps.bean.Region;
import com.github.hps.mapper.OrgMapper;
import com.github.hps.mapper.RegionMapper;
import com.github.hps.redis.OrgTreeKey;
import com.github.hps.redis.RedisService;
import com.github.hps.redis.RegionKey;
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
public class RegionService {
    RegionMapper regionMapper;
    RedisService redisService;



    public List<Region>  getProvinceList(){
        List<Region> list=redisService.get(RegionKey.REGION_LIST_PROVINCE,"REGION_LIST_PROVINCE",List.class);
        if(list==null||list.size()==0){
            list=regionMapper.getProvinceList();
            redisService.set(RegionKey.REGION_LIST_PROVINCE,"REGION_LIST_PROVINCE",list);
        }
        return list;
    }
    public List<Region>  getCityList(Integer provinceId){
        return regionMapper.getCityList(provinceId);
    }
    public List<Region>  getAreaList(Integer cityId){
        return regionMapper.getAreaList(cityId);
    }
}
