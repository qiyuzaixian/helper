package com.github.hps.controller;

import com.github.hps.bean.BannerManage;
import com.github.hps.service.BannerManageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ZhangChao
 * @description banner管理
 * @date 2019/5/8
 */
@Controller
@AllArgsConstructor
@RequestMapping(value = "/bannerManage")
public class BannerManageController {

    @Autowired
    public BannerManageService bannerManageService;

    /**
     * 查询所有数据
     * @param model
     * @return java.lang.String
     * @author ZhangChao
     * @date 2019/5/10
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<BannerManage> selectAll(Model model) {
        List<BannerManage> bannerManages = bannerManageService.selectBannerManageInfoList();
        System.out.println(bannerManages);
        return bannerManages;
    }

}
