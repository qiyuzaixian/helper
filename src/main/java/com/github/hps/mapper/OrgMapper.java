package com.github.hps.mapper;


import com.github.hps.bean.Org;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrgMapper {
    List<Org> selectOrgByParentOrgId(@Param("orgId")Long orgId);

    @Select("select to_number(label) from sys_datadict where dictcd='REGISTER' and isenabled=1 and value=#{type}")
    Long selectRegisterOrgId(@Param("type")Integer type);


    @Select("SELECT value　from sys_datadict where label like '%'||(select orgNm from sys_org where orgId=#{orgId}  and isenabled=1)||'%' and dictcd='ORGROLE'")
    Integer selectDict(@Param("orgId")Long orgId);
}
