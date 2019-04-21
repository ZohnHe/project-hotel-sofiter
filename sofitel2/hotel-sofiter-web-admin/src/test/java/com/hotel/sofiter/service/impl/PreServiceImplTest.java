package com.hotel.sofiter.service.impl;

import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.entity.req.PreReqEntity;
import com.hotel.sofiter.pojo.PredeterminePojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springContext.xml")
public class PreServiceImplTest {

    @Resource
    PreServiceImpl preServiceImpl;



    @Test
    public void getList() {
      /*  PreReqEntity preReqEntity = new PreReqEntity();
        preReqEntity.setPageNum(1);
        preReqEntity.setPageSize(10);
        preReqEntity.setSearch("");
        PageInfo<PredeterminePojo> predeterminePojoPageInfo = preServiceImpl.pageFuzzyselect(preReqEntity);
        for (PredeterminePojo predeterminePojo : predeterminePojoPageInfo.getList()) {
            System.out.println(predeterminePojo.getPassengerRemarks());
        }*/
      /*  List<PredeterminePojo> list = preServiceImpl.getList();
        System.out.println(list);*/

        Date date = new Date();
        //设置日期格式
        DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将当前时间转为字符串
        Timestamp timestamp = Timestamp.valueOf(dformat.format(date));

        System.out.println(timestamp.toString());

    }



}