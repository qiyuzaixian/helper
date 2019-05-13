package com.github.hps.service;

import com.github.hps.bean.BannerManage;
import com.github.hps.mapper.BannerManageMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhangChao
 * @description
 * @date 2019/5/9
 */

@Service
@AllArgsConstructor
public class BannerManageService {

    public BannerManageMapper bannerManageMapper;

    /**
     * 查询所有数据
     *
     * @param
     * @author ZhangChao
     * @date 2019/5/11
     */
    @Transactional
    public List<BannerManage> selectBannerManageInfoList() {
        List<BannerManage> bannerManages = bannerManageMapper.selectBannerManageInfoList();
        return bannerManages;
    }
}
