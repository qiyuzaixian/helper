package com.github.hps.result;

public class CodeMsg {

    private int code;
    private String msg;
    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "请求成功");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问高峰期，请稍等！");
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "登录用户不存在或者已经失效");
//    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
//    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
//    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号或密码有误");
//    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "账号或密码错误");
//    public static CodeMsg PRIMARY_ERROR = new CodeMsg(500216, "主键冲突");
//    public static CodeMsg SESSION_EXIST = new CodeMsg(500217, "发现该账号在其他设备上已登录，拒绝重复登录");
//    public static CodeMsg AUTHENTICATION_FAILED = new CodeMsg(500218, "请求失败,用户未经认证");
//    public static CodeMsg GRANT_AUTH_FAILED = new CodeMsg(500218, "用户信息与认证不匹配");
    public static CodeMsg PASSWORD_ERROW = new CodeMsg(500219, "密码有误");
    public static CodeMsg MOBILE_REPEAT = new CodeMsg(500220, "手机号被多个用户占用，请联系管理员");
    public static CodeMsg IDCARD_NOT_EXIST = new CodeMsg(500221, "身份证号或密码有误");
    public static CodeMsg IDCARD_REPEAT = new CodeMsg(500222, "身份证号被多个用户占用，请联系管理员");
    public static CodeMsg IDCARD_NOT = new CodeMsg(500223, "用户不存在");

    //考试模块 5003XX
    public static CodeMsg EXAM_NOT_PASS = new CodeMsg(500301, "闯关考试上一关未通过");
    public static CodeMsg EXAM_ERROR = new CodeMsg(500302, "考试服务异常，请稍后再试");
    public static CodeMsg EXAM_NOT_EXIST = new CodeMsg(500303, "考试信息不存在，请联系技术部解决");

    //注册模块  5006XX
    public static CodeMsg REGISTER_REPEAT = new CodeMsg(500601, "注册失败,身份证号码已存在！");
    public static CodeMsg REGISTER_ERROR = new CodeMsg(500602, "注册失败,请联系管理员解决!");
    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回带参数的错误码
     * @param args
     * @return
     */
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }


}
