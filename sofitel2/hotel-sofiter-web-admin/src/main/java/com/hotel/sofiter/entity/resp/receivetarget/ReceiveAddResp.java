package com.hotel.sofiter.entity.resp.receivetarget;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加接待对象 返回实体
 */
public class ReceiveAddResp {
    @ApiModelProperty(value = "成功添加接待对象的返回数")
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
