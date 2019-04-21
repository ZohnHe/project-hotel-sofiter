package com.hotel.sofiter.service;

import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.entity.req.PreReqEntity;
import com.hotel.sofiter.page.Page;
import com.hotel.sofiter.pojo.PredeterminePojo;

import java.util.List;

public interface PreService {

    PageInfo<PredeterminePojo> pageFuzzyselect(PreReqEntity preReqEntity);


    //新增预订
    public int insertAll(PredeterminePojo PredeterminePojo);

    public Page<PredeterminePojo> pageFuzzyselect(String receiveTeamName, String passengerName,
                                                  int predetermineStateID, Page<PredeterminePojo> vo);

    //id查询
    public PredeterminePojo findById(Integer id);

    //根据 旅客id 来查询
    public List<PredeterminePojo> findLvKeId(Integer id);

    //根据 团队id 来查询 
    public List<PredeterminePojo> findTeamId(Integer id);

    //id删除
    public int deleteById(Integer id);

    //查询全部数据 无分页
    public List<PredeterminePojo> selectAll();

    //修改预订到时提示
    public int updateRemind(Integer id);

    //修改预订状态
    public int updatePredetermineStateID(Integer id);


    List<PredeterminePojo> getList();
}
