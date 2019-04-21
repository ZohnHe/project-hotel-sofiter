package com.hotel.sofiter.entity.resp.predetermine;

public class RoomGetListResp {

    private Integer id;

    private String roomNumber;

    private String guestRoomLevelName;

    private String roomAmount;

    private double standardPriceDay;

    @Override
    public String toString() {
        return "RoomGetListResp{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", guestRoomLevelName='" + guestRoomLevelName + '\'' +
                ", roomAmount='" + roomAmount + '\'' +
                ", standardPriceDay=" + standardPriceDay +
                '}';
    }

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
}
