package com.github.hps.controller;

import com.github.hps.bean.User;
import com.github.hps.redis.RedisService;
import com.github.hps.redis.UserKey;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.service.HpsCreditsService;
import com.github.hps.service.UserService;
import com.github.hps.vo.LoginNewVo;
import com.github.hps.vo.LoginVo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    UserService userService;
    RedisService redisService;
    HpsCreditsService hpsCreditsService;


    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")//手机号登录
    @ResponseBody
    public Result<User> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {//加入JSR303参数校验
        try{
            log.info(loginVo.toString());
            return userService.login(response, loginVo);
        }catch(Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/do_idLogin")//身份证登录
    @ResponseBody
    public Result<User> do_idLogin(HttpServletResponse response, @Valid LoginNewVo loginNewVo) {
        try{
            log.info(loginNewVo.toString());
            return userService.newLogin(response, loginNewVo);
        }catch(Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/Login")//多角色登录身份证登录
    @ResponseBody
    public Result<Map<String,Object>> Login(HttpServletResponse response, @Valid LoginNewVo loginNewVo) {//加入JSR303参数校验
        try{
            return  userService.authentication(response,loginNewVo);
        }catch(Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


    @RequestMapping("/logout")
    @ResponseBody
    public Result logout(HttpServletRequest request, HttpServletResponse response, @RequestParam String token) {
        log.info("logout user token {}",token);
            userService.removeToken(request,response,token);
        return Result.success(null);
    }


    @ResponseBody
    @RequestMapping("/firstOpen")
    public Result<Map<String,Object>> firstOpen(@RequestParam ("token")String token) {
        try{
            User user=redisService.get(UserKey.token, token, User.class);
            hpsCreditsService.setHpsCredits(2,user.getUserId(),null);
            return Result.success(hpsCreditsService.getMyHpsCredits(user.getUserId()));
        }catch(Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
