package com.github.hps.controller;

import com.github.hps.bean.BannerManage;
import com.github.hps.bean.Photo;
import com.github.hps.bean.User;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.service.BannerManageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

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
     *
     * @param model
     * @return java.lang.String
     * @author ZhangChao
     * @date 2019/5/10
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String, Object> selectAll(Model model) throws Exception {
        Result result = null;
        Map<String, Object> resultMap = new HashMap<>(16);

        List<BannerManage> bannerManages = bannerManageService.selectBannerManageInfoList();
        InputStream in = BannerManageController.class.getResourceAsStream("/application-dev.properties");
        Properties properties = new Properties();
        properties.load(in);
        String path = properties.getProperty("uploadify.ip");
        path += properties.getProperty("uploadify.parentNewFile");

        Map<String, Object> photoMap = new HashMap<>(16);
        Map<String, Object> dataMap = new HashMap<>(16);

        for (BannerManage bannerManage : bannerManages) {
            String photo = bannerManage.getPhoto();
            String newPhoto = path + "/" + photo.substring(photo.lastIndexOf("\\") + 1);
            photoMap.put("photo",newPhoto);
        }

        result = Result.error(CodeMsg.IDCARD_NOT_EXIST);
        in.close();
        dataMap.put("item",photoMap);
        resultMap.put("msg",result.getMsg());
        resultMap.put("code",result.getCode());
        resultMap.put("data",dataMap);
        return resultMap;
    }

}
