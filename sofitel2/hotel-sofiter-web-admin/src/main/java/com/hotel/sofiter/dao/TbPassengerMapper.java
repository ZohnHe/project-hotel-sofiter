package com.hotel.sofiter.dao;

import com.hotel.sofiter.entity.resp.passenger.PassengerInfo;
import com.hotel.sofiter.pojo.PassengerPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPassengerMapper {

    //分页查询
//    public List<PassengerPo> pageFuzzyselect(@Param("start") int start, @Param("pageSize") int pageSize);
    public List<PassengerPo> pageFuzzyselect(@Param("orderStr") String orderStr, @Param("search") String passengerName);
    public int insertAll(PassengerInfo passengerInfo);
//    passengerDelete
    //删除1.8 删除dao接口
    public int passengerDelete(@Param("passengerIds") String[] passengerIds);

    public int passengerModify(PassengerInfo passengerInfo);

    //查询所有旅客数据
    List<PassengerPo> selectAllPassenger();
}