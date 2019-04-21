package com.hotel.sofiter.domain.commodity;

import io.swagger.annotations.ApiModelProperty;

public class CommodityAddEntity {
    @ApiModelProperty(value = "商品名称")
    private String commodityName; //"豆浆"
    @ApiModelProperty(value = "商品类型")
    private int commodityTypeID;//: "16"
    @ApiModelProperty(value = "商品价格")
    private int salePrice;//: "6"
    @ApiModelProperty(value = "计量单位")
    private int uOMID;//: "57"

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

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getuOMID() {
        return uOMID;
    }

    public void setuOMID(int uOMID) {
        this.uOMID = uOMID;
    }
}
