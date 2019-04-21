package com.hotel.sofiter.domain.receivetarget;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 * 删除接待对象 输入参数实体
 */
public class ReceiveDeleteEntity {

    @ApiModelProperty("需要删除接待对象的ID")
//    @Size(min = 1,message = "需要删除的接待对象的ID不能为空")
    private String[] receiveId;

    public String[] getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String[] receiveId) {
        this.receiveId = receiveId;
    }
}
