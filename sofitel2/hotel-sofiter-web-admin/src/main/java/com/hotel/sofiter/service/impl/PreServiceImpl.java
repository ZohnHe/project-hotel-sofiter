package com.hotel.sofiter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.dao.PredetermineMapper;
import com.hotel.sofiter.entity.req.PreReqEntity;
import com.hotel.sofiter.page.Page;
import com.hotel.sofiter.pojo.PredeterminePojo;
import com.hotel.sofiter.service.PreService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PreServiceImpl implements PreService {


    @Resource
    PredetermineMapper tbPredetermineMapperExt;

    @Override
    public PageInfo<PredeterminePojo> pageFuzzyselect(PreReqEntity preReqEntity) {
        PageHelper.startPage(preReqEntity.getPageNum(),preReqEntity.getPageSize());


        List<PredeterminePojo> predeterminePojos = tbPredetermineMapperExt.pageSelect(preReqEntity.getSearch(), preReqEntity.getSearch(), 66);



        return new PageInfo<PredeterminePojo>(predeterminePojos);
    }

    public List<PredeterminePojo> getList() {
//        PageHelper.startPage(preReqEntity.getPageNum(),preReqEntity.getPageSize());

//        List<TbPredetermineExt> tbPredetermineExts = tbPredetermineMapperExt.selectAll();


//        List<TbPredetermineExt> tbPredetermineExts = tbPredetermineMapperExt.selectAll();


        return tbPredetermineMapperExt.selectAll();
    }


    @Override
    public int updateRemind(Integer id) {
        return tbPredetermineMapperExt.updateRemind(id);
    }




    @Override
    public int insertAll(PredeterminePojo predeterminePojo) {
        return tbPredetermineMapperExt.insertAll(predeterminePojo);
    }

    @Override
    public Page<PredeterminePojo> pageFuzzyselect(String receiveTeamName, String passengerName, int predetermineStateID, Page<PredeterminePojo> vo) {
        return null;
    }

    @Override
    public PredeterminePojo findById(Integer id) {
        return tbPredetermineMapperExt.findById(id);
    }

    @Override
    public List<PredeterminePojo> findLvKeId(Integer id) {
        return tbPredetermineMapperExt.findLvKeId(id);
    }

    @Override
    public List<PredeterminePojo> findTeamId(Integer id) {
        return tbPredetermineMapperExt.findTeamId(id);
    }

    @Override
    public int deleteById(Integer id) {

        return tbPredetermineMapperExt.deleteById(id);
    }

    @Override
    public List<PredeterminePojo> selectAll() {
        return null;
    }



    @Override
    public int updatePredetermineStateID(Integer id) {
        return 0;
    }



}
