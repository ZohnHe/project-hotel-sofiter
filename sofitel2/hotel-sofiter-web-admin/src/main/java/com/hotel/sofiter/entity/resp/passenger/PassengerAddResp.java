package com.hotel.sofiter.entity.resp.passenger;

import io.swagger.annotations.ApiModelProperty;

public class PassengerAddResp {

    /**
     * 页面大小
     * */
    @ApiModelProperty("成功添加的商品记录数")
    private int resule;

    public int getResule() {
        return resule;
    }

    public void setResule(int resule) {
        this.resule = resule;
    }
}
