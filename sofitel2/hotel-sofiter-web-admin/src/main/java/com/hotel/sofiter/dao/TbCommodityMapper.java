package com.hotel.sofiter.dao;

import com.hotel.sofiter.pojo.TbCommodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCommodityMapper {
    /* 删除商品信息 */
    public Integer deleteById(@Param("deleteIds") String[] deleteIds);

    /* 新增商品 */
    public int insertAll(@Param("commodityTypeID") Integer commodityTypeID, @Param("uOMID") Integer uOMID,
                         @Param("commodityName") String commodityName, @Param("salePrice") Integer salePrice);


    public TbCommodity selectById(Integer id);

    /* 商品修改 */
    public int updateById(@Param("commodityTypeID") Integer commodityTypeID, @Param("uOMID") Integer uOMID,
                          @Param("commodityName") String commodityName, @Param("salePrice") Double salePrice);


    //分页模糊查询
    public List<TbCommodity> pageFuzzyselect(@Param("commodityName") String commodityName,
                                             @Param("commodityTypeID") int commodityTypeID);

    //分页模糊查询总条数
    public int countFuzzyselect(@Param("commodityName") String commodityName, @Param("commodityTypeID") int commodityTypeID);

    //ajax 验证是否存在 此商品
    public int selectYZ(@Param("commodityName") String commodityName);


    //无分页的模糊查询  非本派所用
    public List<TbCommodity> fuzzySelect(@Param("commodityName") String commodityName,
                                         @Param("commodityTypeID") int commodityTypeID);
}