package com.hotel.sofiter.domain.commodity; ////

import io.swagger.annotations.ApiModelProperty;

/**
 *  商品列表请求输入参数
 *
 */
public class CommodityUpdateEntity {
    //@Size(min=1,message="商品名称不能为空!")
    @ApiModelProperty("商品名称")
    private String commodityName; // "仙帝烧排骨"
    @ApiModelProperty("商品类型Id")
    private int commodityTypeID; // "15"
    @ApiModelProperty("价格")
    private double salePrice; // "599.00"
    @ApiModelProperty("计量单位")
    private int uOMID;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getCommodityTypeID() {
        return commodityTypeID;
    }

    public void setCommodityTypeID(int commodityTypeID) {
        this.commodityTypeID = commodityTypeID;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getuOMID() {
        return uOMID;
    }

    public void setuOMID(int uOMID) {
        this.uOMID = uOMID;
    }
}
