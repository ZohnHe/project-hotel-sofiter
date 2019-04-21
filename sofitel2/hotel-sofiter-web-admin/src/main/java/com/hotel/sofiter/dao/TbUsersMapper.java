package com.hotel.sofiter.dao;


import com.hotel.sofiter.pojo.UserPo;

public interface TbUsersMapper {
    public UserPo selectLogin(UserPo user);
}