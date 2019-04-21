package com.hotel.sofiter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.dao.TbFinancialMapper;
import com.hotel.sofiter.domain.stayregister.FinancialQueryEntity;
import com.hotel.sofiter.pojo.FinancialPo;
import com.hotel.sofiter.service.FinancialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FinancialServiceImpl implements FinancialService {

    @Resource
    TbFinancialMapper tbFinancialMapper;

    @Override
    public PageInfo<FinancialPo> financialQuery(FinancialQueryEntity financialQueryEntity) {

        PageHelper.startPage(financialQueryEntity.getPageNum(),financialQueryEntity.getPageSize());

        List<FinancialPo> data = tbFinancialMapper.financialQuery();


        return new PageInfo<FinancialPo>(data);
    }

}
