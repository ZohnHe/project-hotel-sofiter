package com.hotel.sofiter.entity.req;

import java.sql.Timestamp;

public class PreAddRespEntity {
    private Integer lvkeorteamId;
    private Integer teamId;
    private Integer pangduan;
    private String commodityName;    //预定的旅客或者旅行团
    private String predetermineDay; //预定天数
    private double deposit;         //总金额
    private String payWayID;       //支付方式
    //   private
    private Timestamp arriveTime;  //预定的时间

    private String time;  //预定时间 字符串版


    private String roomIdShuZu;//房间ID数组？

    public String getRoomIdShuZu() {
        return roomIdShuZu;
    }

    public void setRoomIdShuZu(String roomIdShuZu) {
        this.roomIdShuZu = roomIdShuZu;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PreAddRespEntity{" +
                "lvkeorteamId='" + lvkeorteamId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", pangduan='" + pangduan + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", predetermineDay='" + predetermineDay + '\'' +
                ", deposit=" + deposit +
                ", payWayID='" + payWayID + '\'' +
                ", arriveTime=" + arriveTime +
                '}';
    }

    public Integer getLvkeorteamId() {
        return lvkeorteamId;
    }

    public void setLvkeorteamId(Integer lvkeorteamId) {
        this.lvkeorteamId = lvkeorteamId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer  getPangduan() {
        return pangduan;
    }

    public void setPangduan(Integer pangduan) {
        this.pangduan = pangduan;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPredetermineDay() {
        return predetermineDay;
    }

    public void setPredetermineDay(String predetermineDay) {
        this.predetermineDay = predetermineDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getPayWayID() {
        return payWayID;
    }

    public void setPayWayID(String payWayID) {
        this.payWayID = payWayID;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }
}
