package com.hotel.sofiter.entity.resp.passenger;

import io.swagger.annotations.ApiModelProperty;

public class PassengerModifyResp {

    /**
     * 页面大小
     * */
    @ApiModelProperty("成功修改的商品记录数")
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
