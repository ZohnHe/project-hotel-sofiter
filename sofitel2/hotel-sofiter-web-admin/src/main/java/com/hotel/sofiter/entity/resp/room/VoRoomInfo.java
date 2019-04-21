package com.hotel.sofiter.entity.resp.room;

import io.swagger.annotations.ApiModelProperty;


public class VoRoomInfo {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("房间号")
    private String roomNumber;
    @ApiModelProperty("客房等级名称")
    private String guestRoomLevelName;
    @ApiModelProperty("房态")
    private String roomName;
    @ApiModelProperty("床位数")
    private String roomAmount;
    @ApiModelProperty("标准客房/天")
    private double standardPriceDay;
    @ApiModelProperty("标准房价/小时")
    private double standardPrice;
    @ApiModelProperty("时长限制")
    private String maxDuration;
    @ApiModelProperty("首段时长")
    private String firstDuration;
    @ApiModelProperty("首段价格")
    private double firstPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuestRoomLevelName() {
        return guestRoomLevelName;
    }

    public void setGuestRoomLevelName(String guestRoomLevelName) {
        this.guestRoomLevelName = guestRoomLevelName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(String roomAmount) {
        this.roomAmount = roomAmount;
    }

    public double getStandardPriceDay() {
        return standardPriceDay;
    }

    public void setStandardPriceDay(double standardPriceDay) {
        this.standardPriceDay = standardPriceDay;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public String getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(String maxDuration) {
        this.maxDuration = maxDuration;
    }

    public String getFirstDuration() {
        return firstDuration;
    }

    public void setFirstDuration(String firstDuration) {
        this.firstDuration = firstDuration;
    }

    public double getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(double firstPrice) {
        this.firstPrice = firstPrice;
    }
}
