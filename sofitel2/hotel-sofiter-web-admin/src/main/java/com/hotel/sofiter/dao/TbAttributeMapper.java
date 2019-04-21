package com.hotel.sofiter.dao;

import com.hotel.sofiter.pojo.AttributePojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAttributeMapper {

    // 新增商品类别
    public int insertAll(@Param("newid") int newid, @Param("newname") String newname);

    // 删除商品类别
    public int deleteById(Integer id);

    //商品类别
    public List<AttributePojo> selectCommodityType();

    //计量单位
    public List<AttributePojo> selectUOM();
}