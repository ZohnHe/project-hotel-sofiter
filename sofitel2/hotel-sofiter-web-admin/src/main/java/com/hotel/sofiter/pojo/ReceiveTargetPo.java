package com.hotel.sofiter.pojo;

import java.sql.Timestamp;

public class ReceiveTargetPo {


	@Override
	public String toString() {
		return "ReceiveTargetPo{" +
				"id=" + id +
				", targetTypeID=" + targetTypeID +
				", principal='" + principal + '\'' +
				", teamName='" + teamName + '\'' +
				", teamCode='" + teamCode + '\'' +
				", registerTime=" + registerTime +
				", contactPhoneNUmber='" + contactPhoneNUmber + '\'' +
				", targetTypeName='" + targetTypeName + '\'' +
				'}';
	}

	private Integer id;
	
	private Integer targetTypeID;
	
	private String principal;
	
	private String teamName;

	private String teamCode;
	
	private Timestamp registerTime;
	
	private String contactPhoneNUmber;

	private String time;
	

	//扩展字段
	private String targetTypeName;


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTargetTypeName() {
		return targetTypeName;
	}

	public void setTargetTypeName(String targetTypeName) {
		this.targetTypeName = targetTypeName;
	}
	
	public String getContactPhoneNUmber() {
		return contactPhoneNUmber;
	}
	
	public void setContactPhoneNUmber(String contactPhoneNUmber) {
		this.contactPhoneNUmber = contactPhoneNUmber;
	}
	

}
