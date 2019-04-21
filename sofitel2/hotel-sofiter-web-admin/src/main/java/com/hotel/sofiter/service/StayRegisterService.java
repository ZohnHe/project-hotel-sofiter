package com.hotel.sofiter.service;

import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.domain.stayregister.StayRegisterEntity;
import com.hotel.sofiter.pojo.TbStayRegisterPro;

public interface StayRegisterService {

    /**
     * 未结账分页查询
     * @param stayRegisterEntity
     * @return
     */
    PageInfo<TbStayRegisterPro> selectByNotBill(StayRegisterEntity stayRegisterEntity);

    /**
     * 结账分页查询
     * @param stayRegisterEntity
     * @return
     */
    PageInfo<TbStayRegisterPro> selectByBill(StayRegisterEntity stayRegisterEntity);

    /**
     * 团队查询
     * @param stayRegisterEntity
     * @return
     */
    PageInfo<TbStayRegisterPro> selectByTeam(StayRegisterEntity stayRegisterEntity);



}
