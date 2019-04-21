package com.hotel.sofiter.domain.passenger;

import io.swagger.annotations.ApiModelProperty;

/*删除1.4 接口输入实体 删除点击事件*/
public class PassengerDeleteEntity {
    @ApiModelProperty("需要删除的passengerID列表")
    private String[] passengerIds;

    public String[] getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(String[] passengerIds) {
        this.passengerIds = passengerIds;
    }
}
