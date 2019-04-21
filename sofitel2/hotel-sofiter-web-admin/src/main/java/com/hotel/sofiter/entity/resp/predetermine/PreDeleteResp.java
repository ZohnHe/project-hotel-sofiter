package com.hotel.sofiter.entity.resp.predetermine;

public class PreDeleteResp {

    private Integer success;

    private String msg;

    public PreDeleteResp() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PreDeleteResp(Integer success) {
        this.success = success;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }
}
