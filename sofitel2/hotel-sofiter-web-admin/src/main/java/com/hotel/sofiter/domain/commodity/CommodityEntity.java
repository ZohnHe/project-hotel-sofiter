package com.hotel.sofiter.domain.commodity;

import com.hotel.sofiter.pojo.AttributePojo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CommodityEntity {
    @ApiModelProperty(value = "当前页数")
    private int PageNum;
    @ApiModelProperty(value = "页面条数")
    private int PageSize;
    @ApiModelProperty(value = "商品类型编号")
    private int commodityTypeID;
    @ApiModelProperty(value = "商品类型")
    private List<AttributePojo> list;
/*    @ApiModelProperty(value = "商品名称/搜索关键字")
    private String commodityName;
    @ApiModelProperty(value = "分页插件")
    private PageInfo<TbCommodity> page;*/

    public List<AttributePojo> getList() {
        return list;
    }

    public void setList(List<AttributePojo> list) {
        this.list = list;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int PageNum) {
        this.PageNum = PageNum;
    }

    public int getCommodityTypeID() {
        return commodityTypeID;
    }

    public void setCommodityTypeID(int commodityTypeID) {
        this.commodityTypeID = commodityTypeID;
    }
}
