package com.github.hps.vo;


import javax.validation.constraints.NotNull;

public class LoginVo {

    @NotNull
    private String mobile;//手机号

    @NotNull
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
