package com.hotel.sofiter.service.impl;

import com.hotel.sofiter.dao.TbUsersMapper;
import com.hotel.sofiter.pojo.UserPo;
import com.hotel.sofiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUsersMapper tbUsersMapper;



    @Override
    public UserPo selectLogin(UserPo user) {
        return tbUsersMapper.selectLogin(user);
    }
}
