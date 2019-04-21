package com.hotel.sofiter.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "receivetarget")
public class TbReceiveTarget {
    /**
     * 接待对象ID
     */
    @Id
    private Integer id;

    /**
     * 对象类别ID
     */
    @Column(name = "targetTypeID")
    private Integer targettypeid;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 团队名称
     */
    @Column(name = "teamName")
    private String teamname;

    /**
     * 团队编号
     */
    @Column(name = "teamCode")
    private String teamcode;

    /**
     * 登记时间
     */
    @Column(name = "registerTime")
    private Date registertime;

    /**
     * 联系电话
     */
    @Column(name = "contactPhoneNUmber")
    private String contactphonenumber;

    //扩展字段
    private String targetTypeName;

    public TbReceiveTarget() {
    }

    public TbReceiveTarget(Integer targettypeid, String principal, String teamname, String teamcode, Date registertime, String contactphonenumber) {
        this.targettypeid = targettypeid;
        this.principal = principal;
        this.teamname = teamname;
        this.teamcode = teamcode;
        this.registertime = registertime;
        this.contactphonenumber = contactphonenumber;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }

    /**
     * 获取接待对象ID
     *
     * @return id - 接待对象ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置接待对象ID
     *
     * @param id 接待对象ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取对象类别ID
     *
     * @return targetTypeID - 对象类别ID
     */
    public Integer getTargettypeid() {
        return targettypeid;
    }

    /**
     * 设置对象类别ID
     *
     * @param targettypeid 对象类别ID
     */
    public void setTargettypeid(Integer targettypeid) {
        this.targettypeid = targettypeid;
    }

    /**
     * 获取负责人
     *
     * @return principal - 负责人
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * 设置负责人
     *
     * @param principal 负责人
     */
    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    /**
     * 获取团队名称
     *
     * @return teamName - 团队名称
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * 设置团队名称
     *
     * @param teamname 团队名称
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
    }

    /**
     * 获取团队编号
     *
     * @return teamCode - 团队编号
     */
    public String getTeamcode() {
        return teamcode;
    }

    /**
     * 设置团队编号
     *
     * @param teamcode 团队编号
     */
    public void setTeamcode(String teamcode) {
        this.teamcode = teamcode == null ? null : teamcode.trim();
    }

    /**
     * 获取登记时间
     *
     * @return registerTime - 登记时间
     */
    public Date getRegistertime() {
        return registertime;
    }

    /**
     * 设置登记时间
     *
     * @param registertime 登记时间
     */
    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    /**
     * 获取联系电话
     *
     * @return contactPhoneNUmber - 联系电话
     */
    public String getContactphonenumber() {
        return contactphonenumber;
    }

    /**
     * 设置联系电话
     *
     * @param contactphonenumber 联系电话
     */
    public void setContactphonenumber(String contactphonenumber) {
        this.contactphonenumber = contactphonenumber == null ? null : contactphonenumber.trim();
    }
}