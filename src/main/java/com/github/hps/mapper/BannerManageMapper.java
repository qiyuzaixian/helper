package com.github.hps.mapper;

import com.github.hps.bean.BannerManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZhangChao
 * @description
 * @date 2019/5/9
 */
@Mapper
public interface BannerManageMapper {
    /**
     * 查询所有
     */
    public List<BannerManage> selectBannerManageInfoList();
}
