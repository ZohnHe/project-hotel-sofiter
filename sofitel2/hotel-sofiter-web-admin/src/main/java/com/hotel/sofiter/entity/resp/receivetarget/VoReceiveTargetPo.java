package com.hotel.sofiter.entity.resp.receivetarget;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 *  返回前端接待对象 实体类
 *  {"data": "id"},
 *  {"data": "targetTypeID"},
 *  {"data": "principal"},
 *  {"data": "teamName"},
 *  {"data": "teamCode"},
 *  {"data": "registerTime"}
 *  {"data": "contactPhoneNUmber"}
 */
public class VoReceiveTargetPo {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ApiModelProperty("ID")
    private Integer id;

    /**
     * 对象类别
     */
    @ApiModelProperty("对象类别")
    private Integer targetTypeID;

    /**
     * 负责人
     */
    @ApiModelProperty("负责人")
    private String principal;

    /**
     * 团队名称
     */
    @ApiModelProperty("团队名称")
    private String teamName;

    /**
     * 团队编号
     */
    @ApiModelProperty("团队编号")
    private String teamCode;

    /**
     * 登记时间
     */
    @ApiModelProperty("登记时间")
    private Timestamp registerTime;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String contactPhoneNUmber;

    //扩展字段
    @ApiModelProperty("类别名称")
    private String targetTypeName;

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public VoReceiveTargetPo(Integer targetTypeID, String principal, String teamName, String teamCode, Timestamp registerTime, String contactPhoneNUmber, String targetTypeName) {
        this.targetTypeID = targetTypeID;
        this.principal = principal;
        this.teamName = teamName;
        this.teamCode = teamCode;
        this.registerTime = registerTime;
        this.contactPhoneNUmber = contactPhoneNUmber;
        this.targetTypeName = targetTypeName;
    }

    public VoReceiveTargetPo() {
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
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

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getContactPhoneNUmber() {
        return contactPhoneNUmber;
    }

    public void setContactPhoneNUmber(String contactPhoneNUmber) {
        this.contactPhoneNUmber = contactPhoneNUmber;
    }
}
