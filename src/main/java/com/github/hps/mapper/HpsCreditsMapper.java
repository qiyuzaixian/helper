package com.github.hps.mapper;


import com.github.hps.bean.*;
import com.github.hps.vo.HpsCreditsRecordVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface HpsCreditsMapper {

    @Select("SELECT * FROM (SELECT t.*, ROWNUM RN\n" +
            "          FROM ( \n" +
            "        SELECT to_char(create_Dt,'yyyy-mm-dd') as createDt,credits_Content,credits_Value FROM HPS_CREDITS_RECORD WHERE USER_ID=#{userId}   AND DEL_FLAG=1 ORDER BY CREATE_DT DESC\n" +
            "        ) T) WHERE RN BETWEEN #{start} AND #{limit}")
    List<HpsCreditsRecordVo> getHpsCreditsPage(Map<String,Object> map);

    @Select("SELECT COUNT(*) FROM HPS_CREDITS_RECORD WHERE USER_ID=#{userId}   AND DEL_FLAG=1 ORDER BY CREATE_DT DESC")
    Integer getHpsCreditsCount(@Param("userId")Long userId);

    @Select("SELECT SUM(CREDITS_VALUE) FROM HPS_CREDITS_RECORD WHERE  USER_ID=#{userId}  AND DEL_FLAG=1")
    Integer getHpsCreditsSum(@Param("userId")Long userId);

    @Select("SELECT * FROM HPS_CREDITS_TYPE WHERE CREDITS_TYPE_ID=#{type} AND DEL_FLAG=1")
    HpsCreditsType getHpsCreditsType(@Param("type")Integer type);

    @Select("SELECT * FROM HPS_CREDITS_RULE WHERE CREDITS_TYPE_ID=#{type} AND DEL_FLAG=1")
    List<HpsCreditsRule> getHpsCreditsRule(@Param("type")Integer type);

    @Insert("INSERT INTO HPS_CREDITS_RECORD VALUES(#{id},#{creditsRecordId},#{creditsBehaviorId},#{userId},#{creditsState},#{creditsDt},#{creditsType},#{creditsContent},#{creditsRuleId},#{creditsValue},#{createDt},#{createOper},#{updateDt},#{updateOper},#{status},#{delFlag},#{remarks})")
    void saveHpsCreditsRecord(HpsCreditsRecord hpsCreditsRecord);

    @Select(" SELECT COUNT(*) FROM HPS_CREDITS_RECORD WHERE TO_DATE(TO_CHAR(CREATE_DT,'yyyy-mm-dd'),'yyyy-mm-dd') =TO_DATE(TO_CHAR(#{nowDate},'yyyy-mm-dd'),'yyyy-mm-dd') AND CREDITS_TYPE=#{type} AND DEL_FLAG=1 AND USER_ID=#{userId}")
    Integer getLoginRecord(Map<String,Object> map);
}
