package com.github.hps.util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileChangeUrl {

    @Value("${uploadify.parentFile}")
    private String  parentFile;
    @Value("${uploadify.parentNewFile}")
    private String  parentNewFile;
    @Value("${uploadify.ip}")
    private String ip;
    @Value("${uploadify.parentNewFile2}")
    private String  parentNewFile2;
    @Value("${uploadify.parentFileHelper}")
    private String  parentFileHelper;

    public  String changeUrl(String phonePath){//主要用于老平台的数据转换
         if(com.github.hps.util.StringUtils.isNotBlank(phonePath)){//判断路径是否为空
                if(phonePath.indexOf(parentFile)!=-1||phonePath.indexOf(parentNewFile)!=-1){
                    phonePath = "";
                }else{
                    phonePath =  phonePath.replace(parentFile,ip+""+parentNewFile2);
                    phonePath =  phonePath.replace(parentNewFile,ip+""+parentNewFile2);
                    phonePath = phonePath.replace(File.separator,"/");
                }
        }else{
            phonePath = "";
        }
        return phonePath;
    }

    public  String changeFileUrl(String phonePath){//代表助手后台数据转换
        if(com.github.hps.util.StringUtils.isNotBlank(phonePath)){//判断路径是否为空
            phonePath =  phonePath.replace(parentFileHelper,ip+""+parentNewFile2);
            phonePath = phonePath.replace(File.separator,"/");
        }else{
            phonePath = "";
        }
        return phonePath;
    }
}
