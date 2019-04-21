package com.hotel.sofiter.service;


import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.domain.stayregister.FinancialQueryEntity;
import com.hotel.sofiter.pojo.FinancialPo;

public interface FinancialService {
    //列表展示查询，引进mybatis分页插件pagehelper，PageInfo为mybatis分页器pagehelper封装的
    public PageInfo<FinancialPo> financialQuery(FinancialQueryEntity financialQueryEntity);

   /* //列表增加查询，引进mybatis分页插件pagehelper，PageInfo为mybatis分页器pagehelper封装的
    public int passengerAdd(PassengerAddEntity passengerAddEntity);
    //删除1.6 业务层接口
    public int passengerDelete(String[] passengerIds);
    //    修改接口
    public int passengerModify(PassengerModifyEntity passengerModifyEntity);*/

}
