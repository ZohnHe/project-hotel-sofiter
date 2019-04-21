package com.hotel.sofiter.entity.resp.room;

import io.swagger.annotations.ApiModelProperty;

public class RoomDeleteResp {
    @ApiModelProperty("成功删除的房间记录数")
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
