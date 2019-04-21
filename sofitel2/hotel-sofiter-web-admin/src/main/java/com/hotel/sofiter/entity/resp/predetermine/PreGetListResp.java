package com.hotel.sofiter.entity.resp.predetermine;

import io.swagger.annotations.ApiModelProperty;

public class PreGetListResp<T> {
    @ApiModelProperty("总记录数")
    private long totalRecord;
    @ApiModelProperty("当前页")
    private int pageNum;
    @ApiModelProperty("分页数")
    private long pageSize;
    @ApiModelProperty("商品列表数据")
    private T data;
    @ApiModelProperty("总页数")
    private long totalPage;

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public PreGetListResp(T data){
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
