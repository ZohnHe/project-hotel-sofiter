package com.hotel.sofiter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.dao.TbStayRegisterMapper;
import com.hotel.sofiter.domain.stayregister.StayRegisterEntity;
import com.hotel.sofiter.pojo.TbStayRegisterPro;
import com.hotel.sofiter.service.StayRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StayRegisterServiceImpl implements StayRegisterService {


    @Resource
    TbStayRegisterMapper tbStayRegisterMapper;

    @Override
    public PageInfo<TbStayRegisterPro> selectByNotBill(StayRegisterEntity stayRegisterEntity) {

        PageHelper.startPage(stayRegisterEntity.getPageNum(),stayRegisterEntity.getPageSize());

        /*用mybatis分页插件来实现自动分页*/
       /* int start = stayRegisterEntity.getPageNum();
        int pageSize = stayRegisterEntity.getPageSize();
        PageHelper.startPage(start,pageSize);
*/
        List<TbStayRegisterPro> data = tbStayRegisterMapper.selectByNotBill();

        return new PageInfo<TbStayRegisterPro>(data);
    }

    @Override
    public PageInfo<TbStayRegisterPro> selectByBill(StayRegisterEntity stayRegisterEntity) {

        PageHelper.startPage(stayRegisterEntity.getPageNum(),stayRegisterEntity.getPageSize());

        List<TbStayRegisterPro> data = tbStayRegisterMapper.selectByBill();

        return new PageInfo<TbStayRegisterPro>(data);
    }

    @Override
    public PageInfo<TbStayRegisterPro> selectByTeam(StayRegisterEntity stayRegisterEntity) {

        PageHelper.startPage(stayRegisterEntity.getPageNum(),stayRegisterEntity.getPageSize());

        List<TbStayRegisterPro> data = tbStayRegisterMapper.selectByTeam();

        return new PageInfo<TbStayRegisterPro>(data);
    }

}
