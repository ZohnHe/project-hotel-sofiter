package com.hotel.sofiter.entity.resp.predetermine;

public enum  ResponseCode {
    // TODO 枚举 相当于 赋值后的类

    OK("200","正常"),
    FAIL("500","网络异常");


    private String code;
    private String desc;


    ResponseCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
