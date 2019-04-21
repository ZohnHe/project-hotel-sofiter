package com.hotel.sofiter.entity.resp.room;

import io.swagger.annotations.ApiModelProperty;

public class RoomModifyResp {
    @ApiModelProperty("成功修改的房间记录数")
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
