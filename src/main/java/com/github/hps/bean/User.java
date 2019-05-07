package com.github.hps.bean;

import lombok.Data;

@Data
public class User {
    private Long id;   //手机号码
    private String nickname; //姓名
    private String password; //密码
    private String salt;   //盐
    private Long userId;   //用户ID
    private Long employeeId;  //员工ID
    private String employeeNm;
    private Long orgId;  //部门ID
    private String orgNm;
    private String roleName;
    private Integer sex;  //性别
    private String phonePath;   //头像
    private String token;

    /**
     * 以下为辅助信息不需要
     */
/*
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
*/

}
