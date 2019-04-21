package com.hotel.sofiter.entity.resp.passenger;

import io.swagger.annotations.ApiModelProperty;

public class PassengerDeleteResp {
    /*删除1.5 接口输出实体 删除点击事件*/
    /**
     * 页面大小
     * */
    @ApiModelProperty("成功房客记录的记录数")
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
