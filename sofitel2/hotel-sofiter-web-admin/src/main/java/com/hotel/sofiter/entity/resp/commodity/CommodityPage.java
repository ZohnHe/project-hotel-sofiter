package com.hotel.sofiter.entity.resp.commodity;

import com.hotel.sofiter.pojo.AttributePojo;
import com.hotel.sofiter.pojo.AttributePojo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/*
*
* 需要前端返回数据,类型
* */
public class CommodityPage<T> {
    @ApiModelProperty("总记录数")
    private long totalRecord;
    @ApiModelProperty("当前页")
    private int pageNum;
    @ApiModelProperty("分页条数")
    private long pageSize;
    @ApiModelProperty("商品列表")
    private T data;
    @ApiModelProperty("总页数")
    private long totalPage;
    @ApiModelProperty("商品类型")
    private List<AttributePojo> tbAttributes;

    public CommodityPage(T data) {
        this.data = data;
    }

    public List<AttributePojo> getTbAttributes() {
        return tbAttributes;
    }

    public void setTbAttributes(List<AttributePojo> tbAttributes) {
        this.tbAttributes = tbAttributes;
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

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }
}
