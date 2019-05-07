package com.github.hps.service;


import com.github.hps.mapper.OrgMapper;
import com.github.hps.mapper.RoleMapper;
import com.github.hps.vo.RoleVo;
import groovy.util.logging.Log4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
@Service
@AllArgsConstructor
public class RoleService {
    RoleMapper roleMapper;
    OrgMapper orgMapper;


    public List<RoleVo> getRole(Integer type,Long orgId){
        Map<String,Integer> map=new HashMap<String,Integer>();
        if(type==3){
            Integer value =orgMapper.selectDict(orgId);
            map.put("orgRole",value);
        }
        map.put("type",type);
        return roleMapper.getRole(map);
    }

}
