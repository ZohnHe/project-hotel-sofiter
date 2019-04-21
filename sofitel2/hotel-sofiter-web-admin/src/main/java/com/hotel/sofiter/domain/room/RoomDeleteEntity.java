package com.hotel.sofiter.domain.room;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class RoomDeleteEntity {
    @ApiModelProperty("需要删除的房间ID列表")
    @Size(min=1,message="房间ID不能为空!")
    private String[] roomIds;

    public String[] getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(String[] roomIds) {
        this.roomIds = roomIds;
    }
}
