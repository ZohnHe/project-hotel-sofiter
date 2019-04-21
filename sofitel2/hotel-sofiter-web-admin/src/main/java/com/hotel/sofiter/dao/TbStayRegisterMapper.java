package com.hotel.sofiter.dao;


import com.hotel.sofiter.pojo.TbStayRegisterPro;

import java.util.List;

public interface TbStayRegisterMapper {

    // 没结账数据
    List<TbStayRegisterPro> selectByNotBill();
    // 已结账数据
    List<TbStayRegisterPro> selectByBill();

    //团队查询
    List<TbStayRegisterPro> selectByTeam();

}