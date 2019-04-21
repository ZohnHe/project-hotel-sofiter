package com.hotel.sofiter.domain.receivetarget;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;

public class ReceiveAddEntity {
//    @NotEmpty(message = "接待对象类别不能为空")
    @ApiModelProperty(value = "接待对象类别")
    private Integer targetTypeID;

//    @NotEmpty(message = "接待对象的负责人不能为空")
    @ApiModelProperty(value = "接待对象负责人")
    private String principal;

//    @NotEmpty(message = "他的名称不能为空")
    @ApiModelProperty(value = "团队名称")
    private String teamName;

//    @NotEmpty(message = "团队编号不能为空")
    @ApiModelProperty(value = "团队编号")
    private String teamCode;

//    @NotEmpty(message = "登记时间不能为空")
    @ApiModelProperty(value = "登记时间")
    private Timestamp registerTime;

//    @NotEmpty(message = "练习电话不能为空")
    @ApiModelProperty(value = "练习电话")
    private String contactPhoneNUmber;

    public ReceiveAddEntity(Integer targetTypeID, String principal, String teamName, String teamCode, String contactPhoneNUmber) {
        this.targetTypeID = targetTypeID;
        this.principal = principal;
        this.teamName = teamName;
        this.teamCode = teamCode;
        this.contactPhoneNUmber = contactPhoneNUmber;
    }

    public ReceiveAddEntity() {
    }

    public ReceiveAddEntity(Integer targetTypeID, String principal, String teamName, String teamCode, Timestamp registerTime, String contactPhoneNUmber) {
        this.targetTypeID = targetTypeID;
        this.principal = principal;
        this.teamName = teamName;
        this.teamCode = teamCode;
        this.registerTime = registerTime;
        this.contactPhoneNUmber = contactPhoneNUmber;
    }

    public Integer getTargetTypeID() {
        return targetTypeID;
    }

    public void setTargetTypeID(Integer targetTypeID) {
        this.targetTypeID = targetTypeID;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    /*public Timestamp getRegisterTime() {
//        return registerTime;
        return null;
    }*/

    /*public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }*/

    public String getContactPhoneNUmber() {
        return contactPhoneNUmber;
    }

    public void setContactPhoneNUmber(String contactPhoneNUmber) {
        this.contactPhoneNUmber = contactPhoneNUmber;
    }

    @Override
    public String toString() {
        return "ReceiveAddEntity{" +
                "targetTypeID=" + targetTypeID +
                ", principal='" + principal + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", registerTime=" + registerTime +
                ", contactPhoneNUmber='" + contactPhoneNUmber + '\'' +
                '}';
    }
}
