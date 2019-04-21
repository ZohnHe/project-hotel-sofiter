package com.hotel.sofiter.controller;

import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.common.utils.CopyParam;
import com.hotel.sofiter.common.utils.ValidatorCheck;
import com.hotel.sofiter.domain.stayregister.StayRegisterEntity;
import com.hotel.sofiter.entity.resp.stayregister.RoomSetResp;
import com.hotel.sofiter.entity.resp.stayregister.StayRegisterInfo;
import com.hotel.sofiter.entity.resp.stayregister.StayRegisterResp;
import com.hotel.sofiter.pojo.RoomSetPo;
import com.hotel.sofiter.pojo.TbStayRegisterPro;
import com.hotel.sofiter.service.RoomSetService;
import com.hotel.sofiter.service.StayRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/stayregister")
@Api(tags = "住宿登记模块")
public class StayRegisterController {

    @Resource
    StayRegisterService stayRegisterService;

    @Resource
    RoomSetService roomSetService;

    @ApiOperation(value = "未结账旅客分页信息")
    @RequestMapping(value = "/listByNotBill",method = RequestMethod.POST)
    @ResponseBody
    // @ResponseBody封包，@RequestBody 解包
    public StayRegisterResp<StayRegisterInfo> getNotBillList(@Valid @RequestBody StayRegisterEntity stayRegisterEntity, BindingResult errors){

        // 后台校验 - Hibernate Validator插件
        ValidatorCheck.checkParameter(errors);
        // 数据库返回数据
        PageInfo<TbStayRegisterPro> list = stayRegisterService.selectByNotBill(stayRegisterEntity);

        ArrayList<StayRegisterInfo> data = new ArrayList<>();

        CopyParam.copyParam(list, data);

        StayRegisterResp<StayRegisterInfo> stayRegisterResp = new StayRegisterResp(data);

        stayRegisterResp.setPageNum(stayRegisterEntity.getPageNum());//当前页
        stayRegisterResp.setPageSize(stayRegisterEntity.getPageSize());//分页数
        // list 不为空
        if (list != null) {
            stayRegisterResp.setTotalRecord(list.getTotal());
        }
        //总页数
        //(总记录数+分页数-1)/分页数

        long totalPage = (stayRegisterResp.getTotalRecord()+stayRegisterEntity.getPageSize()-1)/stayRegisterEntity.getPageSize();
        stayRegisterResp.setTotalPage(totalPage);
        return stayRegisterResp;
    }

    //listByBill
    @ApiOperation(value = "已结账旅客分页信息")
    @RequestMapping(value = "/listByBill",method = RequestMethod.POST)
    @ResponseBody
    // @ResponseBody封包，@RequestBody 解包
    public StayRegisterResp<StayRegisterInfo> getBillList(@Valid @RequestBody StayRegisterEntity stayRegisterEntity, BindingResult errors){

        // 后台校验 - Hibernate Validator插件
        ValidatorCheck.checkParameter(errors);
        // 数据库返回数据
        PageInfo<TbStayRegisterPro> list = stayRegisterService.selectByBill(stayRegisterEntity);

        ArrayList<StayRegisterInfo> data = new ArrayList<>();
        // 属性拷贝
        CopyParam.copyParam(list, data);

        StayRegisterResp<StayRegisterInfo> stayRegisterResp = new StayRegisterResp(data);

        stayRegisterResp.setPageNum(stayRegisterEntity.getPageNum());//当前页
        stayRegisterResp.setPageSize(stayRegisterEntity.getPageSize());//分页数
        stayRegisterResp.setTotalRecord(list.getTotal());
        //总页数，返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        //(总记录数+分页数-1)/分页数

        long totalPage = (stayRegisterResp.getTotalRecord()+stayRegisterEntity.getPageSize()-1)/stayRegisterEntity.getPageSize();
        stayRegisterResp.setTotalPage(totalPage);
        return stayRegisterResp;
    }

    @ApiOperation(value = "已结账旅客分页信息")
    @RequestMapping(value = "/listbyteam",method = RequestMethod.POST)
    @ResponseBody
    // @ResponseBody封包，@RequestBody 解包
    public StayRegisterResp<StayRegisterInfo> getTeamList(@Valid @RequestBody StayRegisterEntity stayRegisterEntity, BindingResult errors){

        // 后台校验 - Hibernate Validator插件
        ValidatorCheck.checkParameter(errors);
        // 数据库返回数据
        PageInfo<TbStayRegisterPro> list = stayRegisterService.selectByTeam(stayRegisterEntity);

        ArrayList<StayRegisterInfo> data = new ArrayList<>();
        // 属性拷贝
        CopyParam.copyParam(list, data);

        StayRegisterResp<StayRegisterInfo> stayRegisterResp = new StayRegisterResp(data);

        stayRegisterResp.setPageNum(stayRegisterEntity.getPageNum());//当前页
        stayRegisterResp.setPageSize(stayRegisterEntity.getPageSize());//分页数
        stayRegisterResp.setTotalRecord(list.getTotal());
        //总页数，返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        //(总记录数+分页数-1)/分页数

        long totalPage = (stayRegisterResp.getTotalRecord()+stayRegisterEntity.getPageSize()-1)/stayRegisterEntity.getPageSize();
        stayRegisterResp.setTotalPage(totalPage);
        return stayRegisterResp;
    }


    @ApiOperation(value = "选择所有房间")
    @RequestMapping(value = "/selectAllRoom",method = RequestMethod.POST)
    @ResponseBody
    // @ResponseBody封包，@RequestBody 解包
    public RoomSetResp<RoomSetPo> selectAllRoom(){
        List<RoomSetPo> roomSetPos = roomSetService.selectAllRoom();
        return new RoomSetResp<>(roomSetPos);
    }
}
