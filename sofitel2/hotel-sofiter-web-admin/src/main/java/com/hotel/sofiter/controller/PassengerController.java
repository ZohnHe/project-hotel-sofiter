package com.hotel.sofiter.controller;

import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.common.utils.ValidatorCheck;
import com.hotel.sofiter.domain.passenger.PassengerAddEntity;
import com.hotel.sofiter.domain.passenger.PassengerDeleteEntity;
import com.hotel.sofiter.domain.passenger.PassengerModifyEntity;
import com.hotel.sofiter.domain.passenger.PassengerQueryEntity;
import com.hotel.sofiter.entity.resp.passenger.*;
import com.hotel.sofiter.pojo.PassengerPo;
import com.hotel.sofiter.service.PassengerService;
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

//4.2 接口

@Controller
@Api(tags="旅客信息")  //swagger分类标题注解
@RequestMapping(value = "/passenger")
public class PassengerController {

//4.3.3 注入service

    @Resource
    private PassengerService passengerService;
    //4.4swagger上后端测试

    @ApiOperation(value = "旅客信息展示", notes = "分页模糊查询")
    @RequestMapping(value = "/tolist",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestB  ody解包，自定义协议、二进制字符串
    //4.2 输入输出实体

    public PassengerQueryResp<PassengerInfo> getPassengerList(HttpServletRequest request, @Valid @RequestBody PassengerQueryEntity passengerEntity, BindingResult errors) {

        ValidatorCheck.checkParameter(errors);
        //service返回的数据集
        PageInfo<PassengerPo> list = passengerService.pageFuzzyselect(passengerEntity);
        //属性拷贝，返回为给前端的回应

        List<PassengerInfo> data = new ArrayList<PassengerInfo>();
        if (list.getList() != null) {
        //4.7.6改为PbGoodsInfo记得对应的mybatis那边对应路径也要改变

            for (PassengerPo pbPassenger : list.getList()) {
                PassengerInfo bean = new PassengerInfo();
        //4.7.6 记得抛异常，4.7.7看Ext.xml

                try {
                    BeanUtils.copyProperties(pbPassenger, bean);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }
         //4.2 接口返回参数，数据库返回属性的类型，data为返回参数实体中的泛型那个

        PassengerQueryResp<PassengerInfo> responseEntity = new PassengerQueryResp(data);

        //4.3 完善responseEntity其他参数

        responseEntity.setPageNum(passengerEntity.getPageNum());//当前页
        responseEntity.setPageSize(passengerEntity.getPageSize());//分页数
        responseEntity.setTotalRecord(list.getTotal());  //总页数，返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        //(总记录数+分页数-1)/分页数

        long totalPage = (responseEntity.getTotalRecord()+passengerEntity.getPageSize()-1)/passengerEntity.getPageSize();
        responseEntity.setTotalPage(totalPage);
        return responseEntity;
    }

    /*5.4后台接口*/
    @ApiOperation(value = "添加住户信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    /*5.4.1后台接口  输入输出 创建GoodsAddResp，返回数据封包*/
    public PassengerAddResp goodsAdd(HttpServletRequest request, @Valid @RequestBody PassengerAddEntity passengerAddEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        //请求参数错误处理 SpringMVC整合Hibernate Validator服务端验证, @NotEmpty(message = "用户名不能为空!")那个
        ValidatorCheck.checkParameter(errors);
      /*  RequestAssets.assetsError(errors);

        GoodsAddResp goodsAddResp = new GoodsAddResp();
        *//*5.4.2写service，把前端传过来的数据解包成goodsAddEntity实体发过去给业务层*//*
        goodsAddResp.setResult(goodsService.goodsAdd(goodsAddEntity));*/

        PassengerAddResp passengerAddResp = new PassengerAddResp();

        passengerAddResp.setResule(passengerService.passengerAdd(passengerAddEntity));

        return passengerAddResp;
    }

    /*删除1.3 接口 删除点击事件*/
    @ApiOperation(value = "删除指定房客")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public PassengerDeleteResp goodsDelete(HttpServletRequest request, @Valid @RequestBody PassengerDeleteEntity passengerDeleteEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        ValidatorCheck.checkParameter(errors);

        PassengerDeleteResp passengerDeleteResp = new PassengerDeleteResp();
        passengerDeleteResp.setResult(passengerService.passengerDelete(passengerDeleteEntity.getPassengerIds()));
        return passengerDeleteResp;
    }

    @ApiOperation(value = "修改房客信息")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public PassengerModifyResp goodsModify(HttpServletRequest request, @Valid @RequestBody PassengerModifyEntity passengerModifyEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        ValidatorCheck.checkParameter(errors);

        PassengerModifyResp modifyResp = new PassengerModifyResp();
        modifyResp.setResult(passengerService.passengerModify(passengerModifyEntity));

        return modifyResp;
    }


}
