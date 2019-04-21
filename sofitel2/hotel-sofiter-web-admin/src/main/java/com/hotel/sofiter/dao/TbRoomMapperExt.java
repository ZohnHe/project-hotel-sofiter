package com.hotel.sofiter.dao;

import com.hotel.sofiter.pojo.RoomSetPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TbRoomMapperExt {

    //查询全部
    public List<RoomSetPo> selectAll();

    //删除
    public Integer roomsDelete(@Param("roomIds") String[] roomIds);
    //public int deleteById(Integer id);

    //添加
    public int insertAll(RoomSetPo roomSetPo);

    //修改
    public int updateById(RoomSetPo roomSetPo);
    //查询修改对象
    public RoomSetPo selectById(Integer id);

}