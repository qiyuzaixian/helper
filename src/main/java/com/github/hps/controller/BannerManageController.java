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
    public Map selectAll(Model model) throws Exception {
        List<BannerManage> bannerManages = bannerManageService.selectBannerManageInfoList();
        InputStream in = BannerManageController.class.getResourceAsStream("/application-dev.properties");
        Properties properties = new Properties();
        properties.load(in);
        String path = properties.getProperty("uploadify.ip");
        path += properties.getProperty("uploadify.parentNewFile");

        HashMap map = new HashMap();
        map.put("code", "0");
        map.put("msg", "请求成功");

        HashMap map2 = new HashMap();
        List list = new ArrayList();
        for (BannerManage bannerManage : bannerManages) {
            String photo = bannerManage.getPhoto();
            String newPhoto = path + "/" + photo.substring(photo.lastIndexOf("\\") + 1);

            if (photo != null) {
                list.add(newPhoto);
            }
        }
        map2.put("item", list);
        map.put("data", map2);
        in.close();
        System.out.println(map);
        return map;
    }

}
