package com.github.hps.service;

import com.alibaba.druid.util.StringUtils;
import com.github.hps.bean.OrgCheck;
import com.github.hps.bean.User;
import com.github.hps.exception.GlobalException;
import com.github.hps.mapper.UserMapper;
import com.github.hps.redis.RedisService;
import com.github.hps.redis.UserKey;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.util.*;
import com.github.hps.vo.LoginNewVo;
import com.github.hps.vo.LoginVo;
import com.github.hps.vo.UserVo;
import groovy.util.logging.Log4j;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
@Service
@AllArgsConstructor
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    UserMapper userMapper;
    RedisService redisService;
    HpsCreditsService hpsCreditsService;

    @Autowired
    FileChangeUrl fileChangeUrl;
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    public static final String COOKIE_NAME_TOKEN = "token";


    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
    }

    /**
     * 验证密码
     *
     * @param plainPassword 明文密码
     * @param password      密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        byte[] salt = Encodes.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
    }


    public Result<User> login(HttpServletResponse response, LoginVo loginVo) {//手机号登录
        try {
            if (loginVo == null) {
                return Result.error(CodeMsg.BIND_ERROR);
            }
            String mobile = loginVo.getMobile();
            String formPass = loginVo.getPassword();
            User user = null;
            //取数据库
            List<User> list = userMapper.getById(loginVo.getMobile());
            if (list != null && list.size() == 1) {
                user = list.get(0);
            } else if (list.size() != 0) {
                Long orgId = userMapper.selectExamOrg();
                if (orgId != null) {
                    for (User user1 : list) {
                        OrgCheck orgCheck = userMapper.selectUserByEmployee(user1.getEmployeeId());
                        if (checkOgrId(orgId, orgCheck.getOrgId1()) || checkOgrId(orgId, orgCheck.getOrgId2()) || checkOgrId(orgId, orgCheck.getOrgId3()) || checkOgrId(orgId, orgCheck.getOrgId4())) {
                            user = user1;
                        }
                        List<OrgCheck> result = userMapper.selectUserUsercoordorgs(user1.getId());
                        if (result != null) {
                            for (OrgCheck orgCheck1 : result) {
                                if (checkOgrId(orgId, orgCheck1.getOrgId1()) || checkOgrId(orgId, orgCheck1.getOrgId2()) || checkOgrId(orgId, orgCheck1.getOrgId3()) || checkOgrId(orgId, orgCheck1.getOrgId4())) {
                                    user = user1;
                                }
                            }
                        }
                    }
                }
                if (user == null) {
                    return Result.error(CodeMsg.IDCARD_REPEAT);
                }

            } else {
                return Result.error(CodeMsg.MOBILE_NOT_EXIST);
            }
            //再存入缓存
            if (user != null) {
                //获得头像路径
                String phonePath = user.getPhonePath();
                phonePath = fileChangeUrl.changeFileUrl(phonePath);
                user.setPhonePath(phonePath);

            }
            if (user == null) {
                return Result.error(CodeMsg.MOBILE_NOT_EXIST);
            }
            //验证密码
            String dbPass = user.getPassword();
            boolean calcPass = this.validatePassword(formPass, dbPass);
            if (!calcPass) {
                return Result.error(CodeMsg.MOBILE_NOT_EXIST);
            }
            redisService.set(UserKey.getById, "" + mobile, user);
            hpsCreditsService.setHpsCredits(2, user.getUserId(), null);//记录积分
            //生成唯一id作为token
            String token = UUIDUtil.uuid();
            // 将token作为用户属性 add by kongqq | 2019/1/22
            user.setToken(token);
            addCookie(response, token, user);
            return Result.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    public boolean checkOgrId(Long userOrgId, Long checkOrgId) {
        if (userOrgId.longValue() == checkOrgId.longValue())
            return true;
        else
            return false;
    }

    public Result<User> newLogin(HttpServletResponse response, LoginNewVo loginNewVo) {//身份证登录
        try {
            if (loginNewVo == null) {
                return Result.error(CodeMsg.BIND_ERROR);
            }
            String username = loginNewVo.getUsername();
            String formPass = loginNewVo.getPassword();
            User user = null;
            //取数据库
            List<User> list = userMapper.getByIdCard(username);
            if (list != null && list.size() == 1) {
                user = list.get(0);
            } else if (list.size() != 0) {
                Long orgId = userMapper.selectExamOrg();
                if (orgId != null) {
                    for (User user1 : list) {
                        OrgCheck orgCheck = userMapper.selectUserByEmployee(user1.getEmployeeId());
                        if (checkOgrId(orgId, orgCheck.getOrgId1()) || checkOgrId(orgId, orgCheck.getOrgId2()) || checkOgrId(orgId, orgCheck.getOrgId3()) || checkOgrId(orgId, orgCheck.getOrgId4())) {
                            user = user1;
                        }
                        List<OrgCheck> result = userMapper.selectUserUsercoordorgs(user1.getId());
                        if (result != null) {
                            for (OrgCheck orgCheck1 : result) {
                                if (checkOgrId(orgId, orgCheck1.getOrgId1()) || checkOgrId(orgId, orgCheck1.getOrgId2()) || checkOgrId(orgId, orgCheck1.getOrgId3()) || checkOgrId(orgId, orgCheck1.getOrgId4())) {
                                    user = user1;
                                }
                            }
                        }
                    }
                }
                if (user == null) {
                    return Result.error(CodeMsg.IDCARD_REPEAT);
                }
            } else {
                return Result.error(CodeMsg.IDCARD_NOT);
            }
            //再存入缓存
            if (user != null) {
                //获得头像路径
                String phonePath = user.getPhonePath();
                phonePath = fileChangeUrl.changeFileUrl(phonePath);
                user.setPhonePath(phonePath);

            }
            if (user == null) {
                return Result.error(CodeMsg.IDCARD_NOT_EXIST);
            }
            //验证密码
            String dbPass = user.getPassword();
            boolean calcPass = this.validatePassword(formPass, dbPass);
            if (!calcPass) {
                return Result.error(CodeMsg.IDCARD_NOT_EXIST);
            }

            redisService.set(UserKey.getById, "" + username, user);
            hpsCreditsService.setHpsCredits(2, user.getUserId(), null);//记录积分
            //生成唯一id作为token
            String token = UUIDUtil.uuid();
            // 将token作为用户属性 add by kongqq | 2019/1/22
            user.setToken(token);
            addCookie(response, token, user);
            return Result.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    public Result<Map<String,Object>> authentication(HttpServletResponse response, LoginNewVo loginNewVo){
        try {
            if (loginNewVo == null) {
                return Result.error(CodeMsg.BIND_ERROR);
            }
            String username = loginNewVo.getUsername();
            String formPass = loginNewVo.getPassword();
            //取数据库
            List<User> list = userMapper.getByIdCard(username);
            if (list.size() !=0) {
                List<User> userList=new ArrayList<User>();
                for (User user1 : list) {
                    //验证密码
                    String dbPass = user1.getPassword();
                    boolean calcPass = this.validatePassword(formPass, dbPass);
                    if (calcPass) {
                        String phonePath = user1.getPhonePath();
                        phonePath = fileChangeUrl.changeFileUrl(phonePath);
                        user1.setPhonePath(phonePath);
                        redisService.set(UserKey.getById, "" + username, user1);
                        hpsCreditsService.setHpsCredits(2, user1.getUserId(), null);//记录积分
                        //生成唯一id作为token
                        String token = UUIDUtil.uuid();
                        // 将token作为用户属性 add by kongqq | 2019/1/22
                        user1.setToken(token);
                        addCookie(response, token, user1);
                        userList.add(user1);
                    }

                }
                if(userList.size()==0){
                    return Result.error(CodeMsg.PASSWORD_ERROW);
                }
                list=userList;
            } else {
                return Result.error(CodeMsg.IDCARD_NOT);
            }
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("item", list);
            return Result.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    /**
     * 将token做为key，用户信息做为value 存入redis模拟session
     * 同时将token存入cookie，保存登录状态
     */
    public void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }

    /**
     * 根据token获取用户信息
     */
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisService.get(UserKey.token, token, User.class);
        //延长有效期，有效期等于最后一次操作+有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

    /**
     * 用户下线/注销/强退
     *
     * @param token
     */
    public void removeToken(HttpServletRequest request, HttpServletResponse response, String token) {

        try {
            redisService.delete(UserKey.getById, "" + redisService.get(UserKey.token, token, User.class).getId());
            redisService.delete(UserKey.token, token);

            // 迭代查找并清除Cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(COOKIE_NAME_TOKEN)) {
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(CodeMsg.SESSION_ERROR);
        }


    }


    public User getUserByEmployeeId(String token) {
        Long employeeId = redisService.get(UserKey.token, token, User.class).getEmployeeId();
        User user;
        user = redisService.get(UserKey.employeeId, employeeId.toString(), User.class);
        if (user == null) {
            user = userMapper.getUserByEmployeeId(employeeId);
            if (user.getPhonePath() != null) {
                String phonePath = user.getPhonePath();
                phonePath = fileChangeUrl.changeFileUrl(phonePath);
                user.setPhonePath(phonePath);
            }
            redisService.set(UserKey.employeeId, employeeId.toString(), user);
        }
        return user;
    }

    public UserVo getUserById(Long employeeId) {
        return userMapper.getUserById(employeeId);
    }


    /**
     * 典型缓存同步场景：更新密码
     */
    @Transactional
    public Result updatePassword(String token, String oldPassWord, String newPassWord) {
        try {
            User user = redisService.get(UserKey.token, token, User.class);
            boolean calcPass = this.validatePassword(oldPassWord, user.getPassword());
            if (!calcPass) {
                return Result.error(CodeMsg.PASSWORD_ERROW);
            }
            //更新数据库
            user.setPassword(entryptPassword(newPassWord));
            userMapper.update(user);
            //更新缓存：先删除再插入
            redisService.delete(UserKey.getById, "" + user.getId());
            redisService.delete(UserKey.token, token);
            redisService.set(UserKey.token, token, user);
            redisService.set(UserKey.getById, "" + user.getId(), user);
            return Result.success("");
        } catch (Exception e) {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
