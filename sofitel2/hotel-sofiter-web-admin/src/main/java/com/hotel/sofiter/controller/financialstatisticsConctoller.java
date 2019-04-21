package com.hotel.sofiter.controller;


import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.common.utils.ValidatorCheck;
import com.hotel.sofiter.domain.stayregister.FinancialQueryEntity;
import com.hotel.sofiter.entity.resp.stayregister.FinancialInfo;
import com.hotel.sofiter.entity.resp.stayregister.FinancialQueryResp;
import com.hotel.sofiter.pojo.FinancialPo;
import com.hotel.sofiter.service.FinancialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags="财务统计")  //swagger分类标题注解
@RequestMapping(value = "/financial")
public class financialstatisticsConctoller {

    @Resource
    private FinancialService financialService;

    @ApiOperation(value = "旅客信息展示", notes = "分页模糊查询")
    @RequestMapping(value = "/tolist",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    //4.2 输入输出实体

    public FinancialQueryResp<FinancialInfo> getPassengerList(HttpServletRequest request, @Valid @RequestBody FinancialQueryEntity financialQueryEntity, BindingResult errors) {

        ValidatorCheck.checkParameter(errors);
        //service返回的数据集
        PageInfo<FinancialPo> list = financialService.financialQuery(financialQueryEntity);
        //属性拷贝，返回为给前端的回应

        List<FinancialInfo> data = new ArrayList<>();
        if (list.getList() != null) {
            //4.7.6改为PbGoodsInfo记得对应的mybatis那边对应路径也要改变

            for (FinancialPo financialPo : list.getList()) {
                FinancialInfo bean = new FinancialInfo();
                //4.7.6 记得抛异常，4.7.7看Ext.xml

                try {
                    BeanUtils.copyProperties(financialPo, bean);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }
        //4.2 接口返回参数，数据库返回属性的类型，data为返回参数实体中的泛型那个

        FinancialQueryResp<FinancialInfo> responseEntity = new FinancialQueryResp(data);

        //4.3 完善responseEntity其他参数

        responseEntity.setPageNum(financialQueryEntity.getPageNum());//当前页
        responseEntity.setPageSize(financialQueryEntity.getPageSize());//分页数
        responseEntity.setTotalRecord(list.getTotal());  //总页数，返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        //(总记录数+分页数-1)/分页数

        long totalPage = (responseEntity.getTotalRecord()+financialQueryEntity.getPageSize()-1)/financialQueryEntity.getPageSize();
        responseEntity.setTotalPage(totalPage);
        return responseEntity;
    }

}
