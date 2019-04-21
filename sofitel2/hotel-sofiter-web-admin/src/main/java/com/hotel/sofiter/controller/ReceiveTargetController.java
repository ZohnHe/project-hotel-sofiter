package com.hotel.sofiter.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.common.utils.ValidatorCheck;
import com.hotel.sofiter.domain.receivetarget.ReceiveAddEntity;
import com.hotel.sofiter.domain.receivetarget.ReceiveDeleteEntity;
import com.hotel.sofiter.domain.receivetarget.ReceiveQueryEntity;
import com.hotel.sofiter.domain.receivetarget.ReceiveUpdateEntity;
import com.hotel.sofiter.entity.resp.receivetarget.*;
import com.hotel.sofiter.pojo.ReceiveTargetPo;
import com.hotel.sofiter.service.ReceiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "接待对象接口")
@Controller
@RequestMapping(value = "/receive")
public class ReceiveTargetController {

    @Autowired
    private ReceiveService receiveService;


    @ApiOperation(value = "接待对象分页信息",notes = "分页模糊查询")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    // @ResponseBody封包，@RequestBody 解包
    public ReceiveListResp<VoReceiveTargetPo> getReceiveList
            (HttpServletRequest request, @Valid @RequestBody ReceiveQueryEntity receiveQueryEntity,
             BindingResult errors){

        // 后台校验
        ValidatorCheck.checkParameter(errors);

        //service返回的数据集
        PageInfo<ReceiveTargetPo> list = receiveService.pageFuzzyselect(receiveQueryEntity);

        //属性拷贝，返回为给前端的回应
        List<VoReceiveTargetPo> data = new ArrayList<VoReceiveTargetPo>();
        if (list.getList() != null) {
            //4.7.6改为PbGoodsInfo记得对应的mybatis那边对应路径也要改变
            for (ReceiveTargetPo pbPassenger : list.getList()) {
                VoReceiveTargetPo bean = new VoReceiveTargetPo();
                //4.7.6 记得抛异常，4.7.7看Ext.xml

                String time = pbPassenger.getRegisterTime().toString();
                pbPassenger.setTime(time);

                try {
                    BeanUtils.copyProperties(pbPassenger, bean);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }
        System.out.println("33333333333333333333333333333");
        //4.2 接口返回参数，数据库返回属性的类型，data为返回参数实体中的泛型那个
        ReceiveListResp<VoReceiveTargetPo> responseEntity = new ReceiveListResp(data);

        //4.3 完善responseEntity其他参数
        responseEntity.setPageNum(receiveQueryEntity.getPageNum());//当前页
        responseEntity.setPageSize(receiveQueryEntity.getPageSize());//分页数
        responseEntity.setTotalRecord(list.getTotal());  //总页数，返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647

        //(总记录数+分页数-1)/分页数
        long totalPage = (responseEntity.getTotalRecord()+receiveQueryEntity.getPageSize()-1)/receiveQueryEntity.getPageSize();
        responseEntity.setTotalPage(totalPage);
        System.out.println(":" + responseEntity);
        return responseEntity;




        /*// 后台校验 - Hibernate Validator插件
        ValidatorCheck.checkParameter(errors);

        // 数据库返回数据
        PageInfo<ReceiveTargetPo> list = receiveService.getReceiveList(receiveQueryEntity);

        List<VoReceiveTargetPo> data = new ArrayList<>();

        if (list.getList() != null) {
            for (ReceiveTargetPo receiveTargetPo : list.getList()) {

                // 渲染前端数据实体
                VoReceiveTargetPo voReceiveTargetPo = new VoReceiveTargetPo();
                // 复制属性
                BeanUtils.copyProperties(receiveTargetPo, voReceiveTargetPo);
                // 加入数组
                data.add(voReceiveTargetPo);
            }
        }

        // 商品列表响应实体
        ReceiveListResp1<VoReceiveTargetPo> receiveResp = new ReceiveListResp1(data);

        receiveResp.setPageNum(receiveQueryEntity.getPageNum());
        receiveResp.setPageSize(receiveQueryEntity.getPageSize());
        receiveResp.setTotalRecord(list.getTotal());
        //总页数 = (总记录数+分页数-1)/分页数
        long totalPage = (receiveResp.getTotalRecord()+receiveResp.getPageSize()-1)/receiveResp.getPageSize();
        receiveResp.setTotalPage(totalPage);
        return receiveResp;*/
    }


    /*@ApiOperation(value = "接待对象添加",notes = "接待对象添加")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ReceiveAddResp addReceive(HttpServletRequest request, HttpServletResponse response){
        String targetTypeID = request.getParameter("targetTypeID");
        String principal = request.getParameter("principal");
        String teamName = request.getParameter("teamName");
        String teamCode = request.getParameter("teamCode");
        String contactPhoneNUmber = request.getParameter("contactPhoneNUmber");
        System.out.println(targetTypeID+":"+principal+":"+teamName+":"+teamCode+":"+contactPhoneNUmber);

        return null;

    }*/

    @ApiOperation(value = "接待对象添加",notes = "接待对象添加")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ReceiveAddResp addReceive(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody ReceiveAddEntity receiveAddEntity, BindingResult errors){
        System.out.println("11111111111111111111111111111111111111111111111");
        // 后台校验
        ValidatorCheck.checkParameter(errors);

        ReceiveAddResp addResp = new ReceiveAddResp();
        System.out.println("222222222222222222222222222222222222222222222222222222");

        ReceiveTargetPo receiveTargetPo = new ReceiveTargetPo();
        BeanUtils.copyProperties(receiveAddEntity, receiveTargetPo);
        System.out.println(receiveTargetPo);

        System.out.println("ReceiveTargetController : " + receiveAddEntity);
        // service
        Integer addNum = receiveService.insertAll(receiveAddEntity);
        System.out.println(addNum);
        addResp.setResult(addNum);


        return addResp;

    }


    @ApiOperation(value = "接待对象删除",notes = "接待对象删除")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ReceiveDeleteResp deleteReceive(HttpServletRequest request, @Valid @RequestBody ReceiveDeleteEntity receiveDeleteEntity, BindingResult errors){

        // 后台校验
        ValidatorCheck.checkParameter(errors);

        ReceiveDeleteResp deleteResp = new ReceiveDeleteResp();
        // service
        Integer delNum = receiveService.deleteById(receiveDeleteEntity.getReceiveId());
        deleteResp.setResult(delNum);

        return deleteResp;
    }


    @ApiOperation(value = "接待对象修改",notes = "接待对象修改")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ReceiveUpdateResp updateReceive(HttpServletRequest request, @Valid @RequestBody ReceiveUpdateEntity receiveUpdateEntity, BindingResult errors){

        // 后台校验
        ValidatorCheck.checkParameter(errors);

        ReceiveUpdateResp updateResp = new ReceiveUpdateResp();
        // service
        Integer updateNum = receiveService.updateById(receiveUpdateEntity);
        updateResp.setResult(updateNum);

        return updateResp;
    }

    @RequestMapping(value = "/updateMiddle",method = RequestMethod.POST)
    @ResponseBody
    public void updateReceiveMiddle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateId = request.getParameter("updateId0");
//        System.out.println(updateId);
        request.getSession().setAttribute("updateId" , updateId);
        System.out.println("11:" + request.getSession().getAttribute("updateId"));



    }

    @RequestMapping(value = "/updateMiddles",method = RequestMethod.GET)
    @ResponseBody
    public void updateReceiveMiddles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object updateId0 = request.getSession().getAttribute("updateId");
        Integer updateId = 0;

        if ( !"null".equals(updateId0) && !"".equals(updateId0)){
            updateId = Integer.parseInt(updateId0.toString());
        }

        ReceiveTargetPo receiveTargetPo = receiveService.selectById(updateId);
        System.out.println(receiveTargetPo);

        //调用JSON工具包把user信息转换为JSON数据
        String json = JSON.toJSONString(receiveTargetPo);
        System.out.println(json);

        response.getWriter().write(json);
        return;

    }


    /*@RequestMapping("/list")
    public ModelAndView ReceiveList(HttpServletRequest request, Integer currentPage, String txtname){
        ModelAndView mv=null;
        mv=new ModelAndView("/receive/list");
        System.out.println(mv);
        Page<ReceiveTargetPo> vo = new Page<ReceiveTargetPo>();
        //currentPage:当前页数
        if (currentPage==null) {
            currentPage=1;
        }else if (currentPage==0) {
            currentPage=1;
        }
        if(txtname==null)
        {
            txtname="";
        }
        vo.setCurrentPage(currentPage);
        System.out.println(txtname + ":" + vo);
        vo=this.receiveService.pageFuzzyselect(txtname, vo);
        System.out.println(txtname + ":" + vo);
        mv.addObject("list",vo);
        mv.addObject("txtname",txtname);
        return mv;
    }*/



}
