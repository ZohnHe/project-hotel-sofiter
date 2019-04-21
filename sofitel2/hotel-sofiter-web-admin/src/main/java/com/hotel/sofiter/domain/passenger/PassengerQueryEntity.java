package com.hotel.sofiter.domain.passenger;

import io.swagger.annotations.ApiModelProperty;

public class PassengerQueryEntity {
    /*Integer currentPage,String txtname*/
    @ApiModelProperty("当前页码")
    private int pageNum;
    @ApiModelProperty("分页数")
    private int pageSize;
    @ApiModelProperty("排序字段")
    private String order;
    @ApiModelProperty("排序方式")
    private String dir;

    @ApiModelProperty("搜索关键词")
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
}
