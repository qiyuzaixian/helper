package com.github.hps.mapper;


import com.github.hps.vo.VersionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface VersionMapper {

    @Select("SELECT * FROM SYS_VERSION  WHERE MOBILETYPE=#{type}")
    VersionVo getVersion(@Param("type")Integer type);

}
