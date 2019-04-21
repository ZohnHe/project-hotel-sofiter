package com.hotel.sofiter.dao;

import com.hotel.sofiter.pojo.PredeterminePojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PredetermineMapper {

    List<PredeterminePojo> selectAll();

    int updateRemind(Integer id);


//    List<PredeterminePojo> pageFuzzyselect(@Param("receiveTeamName")String receiveTeamName,
//                                         @Param("passengerName")String passengerName, @Param("predetermineStateID")int predetermineStateID,
//                                         @Param("start")int start,@Param("pageSize")int pageSize);



    List<PredeterminePojo> pageSelect(@Param("receiveTeamName")String receiveTeamName,
                                           @Param("passengerName")String passengerName,
                                           @Param("predetermineStateID")int predetermineStateID);

    int deleteById(Integer id);

    //根据 团队id 来查询
    List<PredeterminePojo> findTeamId(Integer id);

    //根据 旅客id 来查询
    public List<PredeterminePojo> findLvKeId(Integer id);

    //根据ID 查询一个预定的实体类
    PredeterminePojo findById(Integer id);


    int insertAll(PredeterminePojo predeterminePojo);
}
