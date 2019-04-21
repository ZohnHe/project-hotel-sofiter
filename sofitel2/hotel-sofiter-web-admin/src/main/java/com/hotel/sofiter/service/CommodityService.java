package com.hotel.sofiter.service;

import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.domain.commodity.CommodityAddEntity;
import com.hotel.sofiter.domain.commodity.CommodityEntity;
import com.hotel.sofiter.domain.commodity.CommodityUpdateEntity;
import com.hotel.sofiter.pojo.TbCommodity;

public interface CommodityService {
    /* 删除 商品信息 */
    public int deleteById(String[] deleteIds);

    /* 新增商品 */
    public int insertAll(CommodityAddEntity commodityAddEntity);


    public TbCommodity selectById(Integer id);

    /* 修改商品 */
    public int updateById(CommodityUpdateEntity commodityUpdateEntity);

    /* 核实商品名称 */
    public int selectName(String name);

    //分页需要
    public PageInfo<TbCommodity> pageFuzzyselect(CommodityEntity commodityEntity);
}
