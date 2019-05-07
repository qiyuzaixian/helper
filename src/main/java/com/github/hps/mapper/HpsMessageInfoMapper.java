package com.github.hps.mapper;

import com.github.hps.vo.HpsMessageInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HpsMessageInfoMapper {

    List<HpsMessageInfoVo> getHpsMessageInfoList(Map<String,Object> map);

    Integer getHpsMessageInfoCount(Map<String,Object> map);

    HpsMessageInfoVo getHpsMessageInfoById(@Param("id")Long id);

    HpsMessageInfoVo getHpsMessageInfoByModeFirst(@Param("msgMode")Integer msgMode);
}
