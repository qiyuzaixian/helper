package com.github.hps.config;

import com.alibaba.druid.util.StringUtils;
import com.github.hps.bean.User;
import com.github.hps.exception.GlobalException;
import com.github.hps.redis.RedisService;
import com.github.hps.redis.UserKey;
import com.github.hps.result.CodeMsg;
import com.github.hps.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class LoginInterceptor  implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Autowired
    RedisService redisService;
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        logger.info("request uri[{}]",httpServletRequest.getRequestURI());
        String requestUrl = httpServletRequest.getRequestURL().toString();
        requestUrl= requestUrl.substring(requestUrl.lastIndexOf("/"));
        if(requestUrl.contains("/do_login")||requestUrl.contains("/to_login")||requestUrl.contains("/do_idLogin")||requestUrl.contains("/Login")){
            String mobile = httpServletRequest.getParameter("mobile");
            User user;
            if(mobile!=null){
                user = redisService.get(UserKey.getById, "" + mobile, User.class);
            }else{
                String username = httpServletRequest.getParameter("username");
                user = redisService.get(UserKey.getById, "" + username, User.class);
            }
            if (user!=null){
                // 方式一： 不允许再次登录
                // throw new GlobalException(CodeMsg.SESSION_EXIST);
                // 方式二：允许再次登录，但要覆盖之前redis中存储的token信息
                String paramToken = httpServletRequest.getParameter(UserService.COOKIE_NAME_TOKEN);
                String cookieToken = getCookieValue(httpServletRequest, UserService.COOKIE_NAME_TOKEN);

                if(paramToken!=null){
                    logger.info("paramToken is {}",paramToken);
                }
                if (cookieToken!=null){
                    logger.info("重复登录，删除该用户上一次登录token，The previous token is {}",cookieToken);
                    redisService.delete(UserKey.token,cookieToken);
                    // 迭代查找并清除Cookie
                    Cookie[] cookies = httpServletRequest.getCookies();
                    if (cookies != null || cookies.length > 0) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals(userService.COOKIE_NAME_TOKEN)) {
                                cookie.setMaxAge(0);
                                cookie.setPath("/");
                                httpServletResponse.addCookie(cookie);
                            }
                        }
                    }
                }
                return true;
            }else{
                return true;
            }
        }else if(requestUrl.contains("setRedis")||requestUrl.contains("getOrgTree")||requestUrl.contains("getRole")||requestUrl.contains("getCurrentUser")||requestUrl.contains("saveEmployee")){

        }else if(httpServletRequest.getServletPath().contains("region")){

        }else{
            String paramToken = httpServletRequest.getParameter(UserService.COOKIE_NAME_TOKEN);
                // 请求未携带token，需要重新登录
            if ("".equals(paramToken)||paramToken==null){
                throw new GlobalException(CodeMsg.SESSION_ERROR);
            }else{
                User user = redisService.get(UserKey.token, paramToken, User.class);
                // 如果前端token还存在，但redis的用户信息已经过期，需要重新登录
                if (user == null) {
                    throw new GlobalException(CodeMsg.SESSION_ERROR);
                }
            }

        }


       /* *//***
         *  不允许用户多个点登录
         *//*
        logger.info("request uri[{}]",httpServletRequest.getRequestURI());
        String requestUrl = httpServletRequest.getRequestURL().toString();
        requestUrl= requestUrl.substring(requestUrl.lastIndexOf("/"));
        String token = httpServletRequest.getParameter("token");
        if(requestUrl.contains("/do_login")||requestUrl.contains("/to_login")){
            String mobile = httpServletRequest.getParameter("mobile");
            User user = redisService.get(UserKey.getById, "" + mobile, User.class);
            if (user!=null){
                throw new GlobalException(CodeMsg.SESSION_EXIST);
            }else{
                return true;
            }
        } *//*else if (requestUrl.contains("/logout")){
            System.out.println("-==================-----------logout--------------============");
            String paramToken = httpServletRequest.getParameter(UserService.COOKIE_NAME_TOKEN);
            String cookieToken = getCookieValue(httpServletRequest, UserService.COOKIE_NAME_TOKEN);
            if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
                throw new GlobalException(CodeMsg.SESSION_ERROR);
            }
            long mobile = Long.parseLong(httpServletRequest.getParameter("id"));
            String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;

            System.out.println("获取的token:"+token+"\t mobile:"+mobile);
            userService.removeToken(httpServletRequest,httpServletResponse,token,mobile);
            return true;
        }*//*else{
                if(token == null || "".equals(token)){
                    throw new GlobalException(CodeMsg.AUTHENTICATION_FAILED);
                }else{
                    User user = redisService.get(UserKey.token, token, User.class);
                    if(user == null){
                        throw new GlobalException(CodeMsg.SESSION_ERROR);
                    }

                }
           *//* String paramToken = httpServletRequest.getParameter(UserService.COOKIE_NAME_TOKEN);
            String cookieToken = getCookieValue(httpServletRequest, UserService.COOKIE_NAME_TOKEN);
            if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
                throw new GlobalException(CodeMsg.SESSION_ERROR);
            }
            String formToken = httpServletRequest.getParameter("token");
            String cacheToken = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;

            System.out.println("formToken:"+formToken+"\t cacheToken"+cacheToken);

            if (formToken==null){
                throw new GlobalException(CodeMsg.AUTHENTICATION_FAILED);
            }
            if (formToken.equals(cacheToken)){
                throw new GlobalException(CodeMsg.GRANT_AUTH_FAILED);
            }*//*

        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    //遍历所有cookie，找到需要的那个cookie
    private String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
