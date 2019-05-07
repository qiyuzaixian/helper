package com.github.hps.vo;


import javax.validation.constraints.NotNull;

public class LoginNewVo {

    @NotNull
    private String username;//身份证

    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginNewVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
