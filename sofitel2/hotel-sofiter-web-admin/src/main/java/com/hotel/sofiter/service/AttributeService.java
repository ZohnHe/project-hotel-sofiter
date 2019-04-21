package com.hotel.sofiter.service;

import com.hotel.sofiter.pojo.AttributePojo;

import java.util.List;

public interface AttributeService {



    //客房等级
    public List<AttributePojo> selectGuestRoomLevel( );

    //房间状态
    public List<AttributePojo> selectRoomState( );

    //商品类别
    public List<AttributePojo> selectCommodityType( );

    //计量单位
    public List<AttributePojo> selectUOM( );

    //查看对象类别
    public List<AttributePojo> selectTargetType( );

    //查看性别
    public List<AttributePojo> selectGender( );

    //查看民族
    public List<AttributePojo> selectNation( );

    //查看旅客级别
    public List<AttributePojo> selectPassengerLevel( );

    //查看文化程度
    public List<AttributePojo> selectEducationDegree( );

    //查看证件类型
    public List<AttributePojo> selectPapers( );

    //查看事由
    public List<AttributePojo> selectThingReason( );

    //旅客类别
    public List<AttributePojo> selectPassengerType( );

    //结账单位
    public List<AttributePojo> selectBillUnit( );

    //结账方式
    public List<AttributePojo> selectPayWay( );

    //出租方式
    public List<AttributePojo> selectRentOutType( );

    //结账否
    public List<AttributePojo> selectIsPay( );

    //预订状态
    public List<AttributePojo> selectPredetermineState( );







    // 新增商品类别 
    public int insertAll(int newid,String newname);

    // 删除商品类别 
    public int deleteById(Integer id);

}
