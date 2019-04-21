package com.hotel.sofiter.common.serivce.impl;


import com.hotel.sofiter.common.serivce.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    Mapper<T> mapper;

    public List<T> getAll(){
        return mapper.selectAll();
    }
}
