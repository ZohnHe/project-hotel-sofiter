package com.hotel.sofiter.entity.resp.receivetarget;

import io.swagger.annotations.ApiModelProperty;

/**
 * 修改接待对象
 */
public class ReceiveUpdateResp {
    @ApiModelProperty(value = "成功修改商品的返回数")
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
