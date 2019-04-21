package com.hotel.sofiter.dao;


import com.hotel.sofiter.pojo.FinancialPo;

import java.util.List;

public interface TbFinancialMapper {

    //分页查询
//    public List<PassengerPo> pageFuzzyselect(@Param("start") int start, @Param("pageSize") int pageSize);
        public List<FinancialPo> financialQuery();

/*    public List<StayRegisterPo> pageConsumption(@Param("consumptionStayRegisterID")int consumptionStayRegisterID,
                                                @Param("start")int start,@Param("pageSize")int pageSize);*/
}