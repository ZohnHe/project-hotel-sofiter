package com.hotel.sofiter.domain.stayregister;

import io.swagger.annotations.ApiModelProperty;

public class FinancialQueryEntity {
    /*Integer currentPage,String txtname*/
    @ApiModelProperty("当前页码")
    private int pageNum;
    @ApiModelProperty("分页数")
    private int pageSize;
    @ApiModelProperty("住宿消费记录")
    private int consumptionStayRegisterID;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getConsumptionStayRegisterID() {
        return consumptionStayRegisterID;
    }

    public void setConsumptionStayRegisterID(int consumptionStayRegisterID) {
        this.consumptionStayRegisterID = consumptionStayRegisterID;
    }
}
