package com.hotel.sofiter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.dao.TbCommodityMapper;
import com.hotel.sofiter.domain.commodity.CommodityAddEntity;
import com.hotel.sofiter.domain.commodity.CommodityEntity;
import com.hotel.sofiter.domain.commodity.CommodityUpdateEntity;
import com.hotel.sofiter.pojo.TbCommodity;
import com.hotel.sofiter.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    TbCommodityMapper tbCommodityMapper;

    @Override
    public int deleteById(String[] deleteIds) {
        Integer results  = tbCommodityMapper.deleteById(deleteIds);
        return results;
    }

    @Override
    public int insertAll(CommodityAddEntity commodityAddEntity) {
        return tbCommodityMapper.insertAll(commodityAddEntity.getCommodityTypeID(), commodityAddEntity.getuOMID(),
                commodityAddEntity.getCommodityName(), commodityAddEntity.getSalePrice());
    }

    @Override
    public TbCommodity selectById(Integer id) {
        return null;
    }

    @Override
    public int updateById(CommodityUpdateEntity commodityUpdateEntity) {
        return tbCommodityMapper.updateById(commodityUpdateEntity.getCommodityTypeID(), commodityUpdateEntity.getuOMID(),
                commodityUpdateEntity.getCommodityName(), commodityUpdateEntity.getSalePrice());
    }

    @Override
    public int selectName(String name) {
        return tbCommodityMapper.selectYZ(name);
    }

    @Override
    public PageInfo<TbCommodity> pageFuzzyselect(CommodityEntity commodityEntity) {
        /* 分页插件设置值,拼接sql页码,页数 */
        PageHelper.startPage(commodityEntity.getPageNum(), commodityEntity.getPageSize());
        if (commodityEntity.getCommodityTypeID() == 0) {
            commodityEntity.setCommodityTypeID(15);
        }
  /*
        用在搜索
        if (commodityName == "") {
            commodityName = "";
        }
        if (PageNum == 0) {
            PageNum = 1;
        }*/

        List<TbCommodity> data = tbCommodityMapper.pageFuzzyselect("", commodityEntity.getCommodityTypeID());
        /* 查到的数据传入分页插件中 */
        return new PageInfo<TbCommodity>(data);
    }
}
