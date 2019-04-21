package com.hotel.sofiter.entity.resp.room;

import io.swagger.annotations.ApiModelProperty;

public class RoomAddResp {

    @ApiModelProperty("成功添加的房间记录数")
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
