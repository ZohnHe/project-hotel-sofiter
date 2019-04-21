package com.hotel.sofiter.dao;

import com.hotel.sofiter.pojo.AttributePojo;

import java.util.List;

public interface AttributeMapper  {

    List<AttributePojo> selectPredetermineState();

    List<AttributePojo> selectPayWay();

}
