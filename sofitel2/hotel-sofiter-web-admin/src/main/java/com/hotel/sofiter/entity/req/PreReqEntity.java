package com.hotel.sofiter.entity.req;

import io.swagger.annotations.ApiModelProperty;

public class PreReqEntity {
    @ApiModelProperty("展示数据量")
    private int pageSize;

    @ApiModelProperty("当前页数")
    private int pageNum;

    @ApiModelProperty("按下排序的哪一项")
    private String order;

    @ApiModelProperty("排序的顺序")
    private String dir;
    @ApiModelProperty("搜索的关键字")
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
