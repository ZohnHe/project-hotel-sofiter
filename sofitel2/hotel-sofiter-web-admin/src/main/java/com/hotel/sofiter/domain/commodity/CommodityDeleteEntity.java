package com.hotel.sofiter.domain.commodity;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 *  商品列表请求输入参数
 *
 */
public class CommodityDeleteEntity {
    @ApiModelProperty("需要删除的商品ID列表")
    @Size(min=1,message="商品ID不能为空!")
    private String[] deleteIds;

    public String[] getdeleteIds() {
        return deleteIds;
    }
    public void setdeleteIds(String[] deleteIds) {
        this.deleteIds = deleteIds;
    }
}
