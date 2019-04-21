package com.hotel.sofiter.domain.commodity;

import io.swagger.annotations.ApiModelProperty;

/**
 *  商品列表请求输入参数
 *
 */
public class CommodityCheckNameEntity {
    @ApiModelProperty("核实商品名称存在否")
    //@Size(min=1,message="商品名称不能为空!")
    private String commodityName;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
}
