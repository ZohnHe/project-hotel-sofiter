package com.hotel.sofiter.common.utils;

import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.entity.resp.stayregister.StayRegisterInfo;
import com.hotel.sofiter.pojo.TbStayRegisterPro;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

public class CopyParam {

    // 复制参数
    public static void copyParam(PageInfo<TbStayRegisterPro> list, ArrayList<StayRegisterInfo> data) {
        if (list != null){

            for (TbStayRegisterPro tbStayRegisterPro : list.getList() ) {

                StayRegisterInfo stayRegisterInfo = new StayRegisterInfo();

                BeanUtils.copyProperties(tbStayRegisterPro,stayRegisterInfo);

                data.add(stayRegisterInfo);
            }
        }
    }
}
