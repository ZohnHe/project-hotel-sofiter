package com.hotel.sofiter.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.common.utils.BaseResponse;
import com.hotel.sofiter.domain.room.RoomAddEntity;
import com.hotel.sofiter.domain.room.RoomDeleteEntity;
import com.hotel.sofiter.domain.room.RoomModifyEntity;
import com.hotel.sofiter.domain.room.RoomQueryEntity;
import com.hotel.sofiter.entity.resp.room.*;
import com.hotel.sofiter.pojo.RoomSetPo;
import com.hotel.sofiter.service.RoomSetService;
import com.hotel.sofiter.service.utils.RequestAssets;
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
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "房间管理模块/客房设置")  //swagger分类标题注解
@RequestMapping(value = "/roomSet")
public class RoomController {

    @Resource
    RoomSetService roomService;

    //分页和模糊查询
    @ApiOperation(value = "获取房间列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<RoomListResp<VoRoomInfo>> getRoomList(HttpServletRequest request, @RequestBody RoomQueryEntity roomQueryEntity, @Valid BindingResult errors) {
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        PageInfo<RoomSetPo> roomList = roomService.getRoomList(roomQueryEntity);

        /* 属性拷贝,可以使用Bean转换工具DozerBeanMapper */
        List<VoRoomInfo> data = new ArrayList<VoRoomInfo>();
        if (roomList.getList() != null) {
            for (RoomSetPo rsp : roomList.getList()) {
                VoRoomInfo bean = new VoRoomInfo();
                try {
                    BeanUtils.copyProperties(rsp, bean);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }

        RoomListResp<VoRoomInfo> responseEntity = new RoomListResp(data);

        responseEntity.setPageNum(roomQueryEntity.getPageNum());

        responseEntity.setPageSize(roomQueryEntity.getPageSize());

        responseEntity.setTotalRecord(roomList.getTotal());  //返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647

        long totalPage = (responseEntity.getTotalRecord() + roomQueryEntity.getPageSize() - 1) / roomQueryEntity.getPageSize(); //(总记录数+分页数-1)/分页数

        responseEntity.setTotalPage(totalPage);
        //System.out.println(Arrays.toString(responseEntity)+"返回给前端的数据");

        return new BaseResponse(responseEntity);
    }

    @ApiOperation(value = "删除指定房间", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<RoomDeleteResp> roomsDelete(HttpServletRequest request, @RequestBody RoomDeleteEntity roomDeleteEntity, @Valid BindingResult errors) {
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        RoomDeleteResp roomDeleteResp = new RoomDeleteResp();

        roomDeleteResp.setResult(roomService.roomsDelete(roomDeleteEntity.getRoomIds()));

        return new BaseResponse(roomDeleteResp);

    }

    @ApiOperation(value = "添加房间", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<RoomAddResp> roomsAdd(HttpServletRequest request, @RequestBody RoomAddEntity roomAddEntity, @Valid BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        RoomAddResp roomAddResp=new RoomAddResp();

        roomAddResp.setResult(roomService.roomsAdd(roomAddEntity));

        return new BaseResponse(roomAddResp);
    }

    @ApiOperation(value = "修改房间信息", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<RoomModifyResp> roomsModify(HttpServletRequest request, @RequestBody RoomModifyEntity roomModifyEntity, @Valid BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);
        System.out.println(roomModifyEntity);

        RoomModifyResp roomModifyResp = new RoomModifyResp();

        roomModifyResp.setResult(roomService.roomsModify(roomModifyEntity));

        return new BaseResponse(roomModifyResp);
    }

    @ApiOperation(value = "获取修改房间数据的ID", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/updateMiddle",method = RequestMethod.POST)
    @ResponseBody
    public void updateMiddle(HttpServletRequest request, HttpServletResponse response) {
        String updateId = request.getParameter("updateId0");
        request.getSession().setAttribute("updateId" , updateId);
        System.out.println("保存在session上的修改房间数据的ID:" + request.getSession().getAttribute("updateId"));

    }

    @ApiOperation(value = "传给前端修改房间的数据json", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/updateMiddles",method = RequestMethod.GET)
    @ResponseBody
    public void updateMiddles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object updateId0 = request.getSession().getAttribute("updateId");
        Integer updateId = 0;

        if ( !"null".equals(updateId0) && !"".equals(updateId0)){
            updateId = Integer.parseInt(updateId0.toString());
        }
        RoomSetPo toUpdateRoomSet = roomService.selectById(updateId);
        System.out.println("获取要修改的roomSet对象:"+toUpdateRoomSet.toString());

        //调用JSON工具包把user信息转换为JSON数据
        String json = JSON.toJSONString(toUpdateRoomSet);
        System.out.println("把对象信息转换为JSON数据:"+json);

        response.getWriter().write(json);
        return;

       /* Integer updateId0 = (Integer) request.getSession().getAttribute("updateId");
        //获取要修改的roomSet对象
        RoomSet toUpdateRoomSet = roomService.selectById(updateId0);

        System.out.println("获取要修改的roomSet对象:"+toUpdateRoomSet);

        //调用JSON工具包把对象信息转换为JSON数据
        String json = JSON.toJSONString(toUpdateRoomSet);
        System.out.println("把对象信息转换为JSON数据:"+json);

        response.getWriter().write(json);*/


    }
}
