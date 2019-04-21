package com.hotel.sofiter.service.impl;

import com.hotel.sofiter.dao.AttributeMapper;
import com.hotel.sofiter.dao.TbAttributeMapper;
import com.hotel.sofiter.pojo.AttributePojo;
import com.hotel.sofiter.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    AttributeMapper attributeMapper;

    @Resource
    TbAttributeMapper tbAttributeMapper;

    @Override
    public List<AttributePojo> selectPredetermineState() {

        //TODO 查询房间预定状态的有多少人 是否被安排了 预定controller用的

        return attributeMapper.selectPredetermineState();
    }


    @Override
    public List<AttributePojo> selectGuestRoomLevel() {
        return null;
    }

    @Override
    public List<AttributePojo> selectRoomState() {
        return null;
    }

    @Override
    public List<AttributePojo> selectCommodityType() {
        //TODO 肖鸿达的需要用到的dao
        List<AttributePojo> pbAttributes = tbAttributeMapper.selectCommodityType();
        return pbAttributes;
    }

    @Override
    public List<AttributePojo> selectUOM() {
        return null;
    }

    @Override
    public List<AttributePojo> selectTargetType() {
        return null;
    }

    @Override
    public List<AttributePojo> selectGender() {
        return null;
    }

    @Override
    public List<AttributePojo> selectNation() {
        return null;
    }

    @Override
    public List<AttributePojo> selectPassengerLevel() {
        return null;
    }

    @Override
    public List<AttributePojo> selectEducationDegree() {
        return null;
    }

    @Override
    public List<AttributePojo> selectPapers() {
        return null;
    }

    @Override
    public List<AttributePojo> selectThingReason() {
        return null;
    }

    @Override
    public List<AttributePojo> selectPassengerType() {
        return null;
    }

    @Override
    public List<AttributePojo> selectBillUnit() {
        return null;
    }

    @Override
    public List<AttributePojo> selectPayWay() {
        return attributeMapper.selectPayWay();
    }

    @Override
    public List<AttributePojo> selectRentOutType() {
        return null;
    }

    @Override
    public List<AttributePojo> selectIsPay() {
        return null;
    }



    @Override
    public int insertAll(int newid, String newname) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}
