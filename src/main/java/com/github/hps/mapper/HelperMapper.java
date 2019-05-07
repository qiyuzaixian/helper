package com.github.hps.mapper;

import com.github.hps.bean.*;
import com.github.hps.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HelperMapper {

    List<HelperInfoVoVersion1> getHelperList(Map<String, Object> map);
    List<HelperInfoVoVersion2> getNewHelperList(Map<String, Object> map);
    Integer getHelperCount(Map<String, Object> map);
    List<HelperInfoVoVersionNew> getSearchHelperList(Map<String, Object> map);
    Integer getSearchHelperCount(Map<String, Object> map);

    List<HelperInfoClassificationVo> getHelperClassificationList(Map<String, Object> map);

    List<HelperInfoVoidVo> getHelperVoidList(Map<String, Object> map);

    HelperInfo getHelperInfo(Long id);
    void recordRead(Long id);
    void recordPraise(Long id);

    //点赞功能
    Long selectPraiseIsExist(HpsPraise hpsPraise);
    void insertPraise(HpsPraise hpsPraise);
}
