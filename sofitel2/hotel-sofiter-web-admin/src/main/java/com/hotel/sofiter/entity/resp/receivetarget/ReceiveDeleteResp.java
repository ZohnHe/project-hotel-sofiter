package com.hotel.sofiter.entity.resp.receivetarget;

import io.swagger.annotations.ApiModelProperty;

/**
 * 删除接待对象 返回实体
 */
public class ReceiveDeleteResp {

    @ApiModelProperty(value = "成功删除接待对象的返回数")
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
