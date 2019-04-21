package com.hotel.sofiter.entity.resp.stayregister;

import java.sql.Timestamp;
import java.util.Date;

public class StayRegisterInfo {

    private Integer id;
    //房间号  roomNumber
    private String roomNumber;
    //客房等级  roomGuestRoomLevelName
    private String roomGuestRoomLevelName;
    //床位数 roomAmount
    private String roomAmount;
    //接待对象
    private String predetermineReceiveTargeTypeName;
    //旅客姓名
    private String passengerName;
    //旅客类别
    private String passengerTypeName;
    //换房次数
    private String changingRoomNumber;         //换房次数
    //换房费
    private double changRoomMoney;             //换房费
    //换房时间
    private Timestamp changRoomTime;
    //登记时间
    private Date registertime;
    //总费用
    private double sumConst;
    //结账否
    private Integer isBillID;


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

    public String getRoomGuestRoomLevelName() {
        return roomGuestRoomLevelName;
    }

    public void setRoomGuestRoomLevelName(String roomGuestRoomLevelName) {
        this.roomGuestRoomLevelName = roomGuestRoomLevelName;
    }

    public String getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(String roomAmount) {
        this.roomAmount = roomAmount;
    }

    public String getPredetermineReceiveTargeTypeName() {
        return predetermineReceiveTargeTypeName;
    }

    public void setPredetermineReceiveTargeTypeName(String predetermineReceiveTargeTypeName) {
        this.predetermineReceiveTargeTypeName = predetermineReceiveTargeTypeName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerTypeName() {
        return passengerTypeName;
    }

    public void setPassengerTypeName(String passengerTypeName) {
        this.passengerTypeName = passengerTypeName;
    }

    public String getChangingRoomNumber() {
        return changingRoomNumber;
    }

    public void setChangingRoomNumber(String changingRoomNumber) {
        this.changingRoomNumber = changingRoomNumber;
    }

    public double getChangRoomMoney() {
        return changRoomMoney;
    }

    public void setChangRoomMoney(double changRoomMoney) {
        this.changRoomMoney = changRoomMoney;
    }

    public Timestamp getChangRoomTime() {
        return changRoomTime;
    }

    public void setChangRoomTime(Timestamp changRoomTime) {
        this.changRoomTime = changRoomTime;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public double getSumConst() {
        return sumConst;
    }

    public void setSumConst(double sumConst) {
        this.sumConst = sumConst;
    }

    public Integer getIsBillID() {
        return isBillID;
    }

    public void setIsBillID(Integer isBillID) {
        this.isBillID = isBillID;
    }
}
