package com.hotel.sofiter.entity.resp.predetermine;

import java.sql.Timestamp;

public class PredetermineResp {

    private Integer id;

    private String passengerName;                   //预定的旅客的姓名

    private String roomNumber;                       //房间的房间号

    private String roomGuestRoomLevelName;             //房间的客房等级名称

    private String receiveTeamName;                //预定对象的接待对象的团队名称

    private String receivePrincipal;               //预定对象的接待对象的负责人

    private Timestamp arriveTime;              //抵达时间

    private double deposit;                    //押金

    private String predetermineDay;           //  预定天数

    private String receiveContactPhoneNUmber;             //预定对象的接待对象的联系电话

    private String predetermineStateName;                 //预订状态名称


    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PredetermineResp{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomGuestRoomLevelName='" + roomGuestRoomLevelName + '\'' +
                ", receiveTeamName='" + receiveTeamName + '\'' +
                ", receivePrincipal='" + receivePrincipal + '\'' +
                ", arriveTime=" + arriveTime +
                ", deposit=" + deposit +
                ", predetermineDay='" + predetermineDay + '\'' +
                ", receiveContactPhoneNUmber='" + receiveContactPhoneNUmber + '\'' +
                ", predetermineStateName='" + predetermineStateName + '\'' +
                '}';
    }

    public PredetermineResp() {
    }

    public PredetermineResp(String roomNumber, String roomGuestRoomLevelName, String receiveTeamName, String receivePrincipal, Timestamp arriveTime, double deposit, String predetermineDay, String receiveContactPhoneNUmber, String predetermineStateName) {
        this.roomNumber = roomNumber;
        this.roomGuestRoomLevelName = roomGuestRoomLevelName;
        this.receiveTeamName = receiveTeamName;
        this.receivePrincipal = receivePrincipal;
        this.arriveTime = arriveTime;
        this.deposit = deposit;
        this.predetermineDay = predetermineDay;
        this.receiveContactPhoneNUmber = receiveContactPhoneNUmber;
        this.predetermineStateName = predetermineStateName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomGuestRoomLevelName() {
        return roomGuestRoomLevelName;
    }

    public void setRoomGuestRoomLevelName(String roomGuestRoomLevelName) {
        this.roomGuestRoomLevelName = roomGuestRoomLevelName;
    }


    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiveTeamName() {
        return receiveTeamName;
    }

    public void setReceiveTeamName(String receiveTeamName) {
        this.receiveTeamName = receiveTeamName;
    }

    public String getReceivePrincipal() {
        return receivePrincipal;
    }

    public void setReceivePrincipal(String receivePrincipal) {
        this.receivePrincipal = receivePrincipal;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getPredetermineDay() {
        return predetermineDay;
    }

    public void setPredetermineDay(String predetermineDay) {
        this.predetermineDay = predetermineDay;
    }

    public String getReceiveContactPhoneNUmber() {
        return receiveContactPhoneNUmber;
    }

    public void setReceiveContactPhoneNUmber(String receiveContactPhoneNUmber) {
        this.receiveContactPhoneNUmber = receiveContactPhoneNUmber;
    }

    public String getPredetermineStateName() {
        return predetermineStateName;
    }

    public void setPredetermineStateName(String predetermineStateName) {
        this.predetermineStateName = predetermineStateName;
    }
}
