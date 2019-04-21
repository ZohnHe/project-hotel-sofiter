package com.hotel.sofiter.entity.resp.commodity;

import io.swagger.annotations.ApiModelProperty;

public class CommodityAddResp {

    @ApiModelProperty("1大于表示存在")
    private int result;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
