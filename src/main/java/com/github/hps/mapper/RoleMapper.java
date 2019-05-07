package com.github.hps.mapper;


import com.github.hps.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {

    List<RoleVo> getRole(Map<String,Integer> map);
}
