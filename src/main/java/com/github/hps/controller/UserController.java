package com.github.hps.controller;

import com.github.hps.bean.User;
import com.github.hps.config.DmtCommon;
import com.github.hps.redis.RedisService;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Message;
import com.github.hps.result.Result;
import com.github.hps.service.OrgService;
import com.github.hps.service.RoleService;
import com.github.hps.service.UserService;
import com.github.hps.util.mapper.JsonMapper;
import com.github.hps.vo.RoleVo;
import com.github.hps.vo.UserVo;
import lombok.AllArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    UserService userService;
    RedisService redisService;
    OrgService orgService;
    RoleService roleService;

    @Autowired
    private DmtCommon dmtCommon;

    @RequestMapping("/info")
    @ResponseBody
    public Result<User> info(Model model, User user) {
        return Result.success(user);
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public Result<User> getUserByEmployeeId(@RequestParam("token") String token) {
        return Result.success(userService.getUserByEmployeeId(token));
    }

    @ResponseBody
    @RequestMapping("/updatePassword")
    public Result updatePassword(@RequestParam("token") String token,@RequestParam("oldPassWord") String oldPassWord,@RequestParam("newPassWord") String newPassWord) {
        return userService.updatePassword(token,oldPassWord,newPassWord);
    }

    @ResponseBody
    @RequestMapping("/getOrgTree")
    public Result<Map<String, Object>>  getOrgTree(@RequestParam("type") Integer type) {
        try{
            List<Map<String, Object>> mapList = orgService.orgService(type);
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("item",mapList);
            return Result.success(map);
        }catch(Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/getRole")
    public Result<Map<String,Object>>  getRole(@RequestParam("type") Integer type,@RequestParam("orgId") Long orgId) {
        try{
            List<RoleVo> list = roleService.getRole(type,orgId);
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("item",list);
            return Result.success(map);
        }catch(Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/getCurrentUser")
    public String  getCurrentUser() {
        JsonMapper jsonMapper = new JsonMapper();
        String result;
        try{
            UserVo user = userService.getUserById(1L);
            result = jsonMapper.toJson(user);
        }catch(Exception e){
            e.printStackTrace();
            result=null;
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "saveEmployee")
    public Result<Message> saveEmployee(@RequestParam("employeeNm") String employeeNm, @RequestParam("idCard") String idCard, @RequestParam("phone") String phone,@RequestParam("registerOrgList")String registerOrgList){
         String requestUrl = dmtCommon.getUrl()+"/zbtAppService/sendPM/bscDtpAccount/saveEmployee?";
        requestUrl += "employeeNm="+employeeNm+"&idCard="+idCard+"&phone="+phone+"&registerOrgList="+URLEncoder.encode(registerOrgList);
        HttpClient client = null;
        try {
            client = new DefaultHttpClient();
            HttpPost httpget = new HttpPost(requestUrl);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String response = client.execute(httpget, responseHandler);
            Message msg=new Message();
            if("true".equals(response)){
                msg.setMessage("注册成功请等待管理员审批!");

            } else if("repeat".equals(response)){
                return Result.error(CodeMsg.REGISTER_REPEAT);
            }else{
                return Result.error(CodeMsg.REGISTER_ERROR);
            }
            return Result.success(msg);

        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
