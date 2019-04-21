package com.hotel.sofiter.entity.resp.predetermine;

import io.swagger.annotations.ApiModelProperty;

public class PreUpdateResp<T> {
    private Integer success;

    private String msg;

    private Integer payWayID; //支付方式

    private Integer id; //如果是旅客 就是旅客ID 如果是团队那就是团队ID

    private String name;//团队的名字 或者 旅客的名字

    private Integer type;//记录是团队 还是 旅客的type 2是团队 1是旅客

    private Integer totalMoney;//押金的总数

    private Integer pangduan;//

    private String predetermineDay;           //  预定天数

    private String time;                    //转换后的抵达时间

    public Integer getPayWayID() {
        return payWayID;
    }

    public void setPayWayID(Integer payWayID) {
        this.payWayID = payWayID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPredetermineDay() {
        return predetermineDay;
    }

    public void setPredetermineDay(String predetermineDay) {
        this.predetermineDay = predetermineDay;
    }

    @ApiModelProperty("总记录数")
    private long totalRecord;
    @ApiModelProperty("当前页")
    private int pageNum;
    @ApiModelProperty("分页数")
    private long pageSize;
    @ApiModelProperty("存放房间等级的集合")
    private T data; //存放房间等级的集合
    @ApiModelProperty("总页数")
    private long totalPage;

    public Integer getPangduan() {
        return pangduan;
    }

    public void setPangduan(Integer pangduan) {
        this.pangduan = pangduan;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public PreUpdateResp(T data) {
        this.data = data;
    }
}
