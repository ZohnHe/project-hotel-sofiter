package com.hotel.sofiter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.hotel.sofiter.dao.TbPassengerMapper;
import com.hotel.sofiter.domain.passenger.PassengerAddEntity;
import com.hotel.sofiter.domain.passenger.PassengerModifyEntity;
import com.hotel.sofiter.domain.passenger.PassengerQueryEntity;
import com.hotel.sofiter.entity.resp.passenger.PassengerInfo;
import com.hotel.sofiter.pojo.PassengerPo;
import com.hotel.sofiter.service.PassengerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Resource
    TbPassengerMapper tbPassengerMapper;
    @Override
    public PageInfo<PassengerPo> pageFuzzyselect(PassengerQueryEntity passengerEntity) {

        PageHelper.startPage(passengerEntity.getPageNum(),passengerEntity.getPageSize());

        /*用mybatis分页插件来实现自动分页*/
        int start = passengerEntity.getPageNum();
        int pageSize = passengerEntity.getPageSize();
        PageHelper.startPage(start,pageSize);

        /*4.7.5添加orderStr,排序*/
        String orderStr = getOrderStr(passengerEntity);

        String searchName = passengerEntity.getSearch();
        List<PassengerPo> data = tbPassengerMapper.pageFuzzyselect(orderStr,searchName);

        return new PageInfo<PassengerPo>(data);
    }

    @Override
    public int passengerAdd(PassengerAddEntity passengerAddEntity) {

        PassengerInfo passengerInfo = new PassengerInfo();

        BeanUtils.copyProperties(passengerAddEntity,passengerInfo);

        return tbPassengerMapper.insertAll(passengerInfo);
    }
    /*1删除.7 删除service实现类*/
    @Override
    public int passengerDelete(String[] passengerIds) {
        return tbPassengerMapper.passengerDelete(passengerIds);
    }

    @Override
    public int passengerModify(PassengerModifyEntity passengerModifyEntity) {
        PassengerInfo passengerInfo = new PassengerInfo();

        BeanUtils.copyProperties(passengerModifyEntity,passengerInfo);
        return  tbPassengerMapper.passengerModify(passengerInfo);
    }

    @Override
    public List<PassengerPo> selectAllPassenger() {
        return tbPassengerMapper.selectAllPassenger();
    }

    /*4.7.5添加orderStr,排序*/
    private String getOrderStr(PassengerQueryEntity goodsQueryEntity){
        /*4.7多用StringBuffer少用string有内存泄漏*/
        StringBuffer stringBuffer = new StringBuffer();
        /*从前端复制返回数据类型来改，可以用switch来做（78天视频有），前端传回的参数为1234分别对应id,goodsType...*/
       /* 从data.html查columns: [
                  { "data": "id" },
                  { "data": "name" },
                  { "data": "genderName" },
                  { "data": "birthDate" },
                  { "data": "nationName" },
                  { "data": "passengerLevelName" },
                  { "data": "papersName" },
                  { "data": "papersNumber" },
                  { "data": "contactPhoneNumber" }
      ]*/
        /*4.7.5记得加是否为空的判断，不然可能就被卡在那了，用!StringUtil.isEmpty做字符串为空判断*/
        if(!StringUtil.isEmpty(goodsQueryEntity.getOrder())) {
            String strs[] = {"id","name","goods_price","genderName","birthDate","nationName","passengerLevelName","papersName","papersNumber","contactPhoneNumber"};
            stringBuffer.append(" order by "+strs[Integer.parseInt(goodsQueryEntity.getOrder())]+" " + goodsQueryEntity.getDir());
        }
        return stringBuffer.toString();
    }


}
