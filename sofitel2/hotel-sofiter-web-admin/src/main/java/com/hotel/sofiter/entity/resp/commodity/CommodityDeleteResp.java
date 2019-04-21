package com.hotel.sofiter.entity.resp.commodity;

import io.swagger.annotations.ApiModelProperty;

public class CommodityDeleteResp {

    @ApiModelProperty("成功删除的商品记录数")
    private int result;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
