package com.hotel.sofiter.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.entity.req.PreAddRespEntity;
import com.hotel.sofiter.entity.req.PreReqEntity;
import com.hotel.sofiter.entity.resp.predetermine.*;
import com.hotel.sofiter.pojo.*;
import com.hotel.sofiter.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "预定信息")
@RequestMapping(value = "/pre")
@Controller
public class PreController {

    @Resource
    PreService preService;

    @Resource
    AttributeService attributeService;

    @Resource
    ReceiveTargetService receiveTargetService;

    @Resource
    RoomSetService roomSetService;

    @Resource
    StayService stayRegisterService;


    int idP[];     //预订id
    int fangJianId[] ;

    @ApiOperation(value = "获取预定信息", notes = "旅客信息")
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public BaseRespEntity<PreGetListResp<PredetermineResp>> getPreList(@RequestBody PreReqEntity pre) {

        if (pre.getSearch() == null ){

            pre.setSearch("");
        }
        //TODO 首先获取全部

        Date date = new Date();
        //设置日期格式
        DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将当前时间转为字符串
        Timestamp timestamp = Timestamp.valueOf(dformat.format(date));

        List<PredeterminePojo> list = preService.getList();

        //计算数据库中 预定时间没过的旅客
        long time;
        //TODO 遍历获取出来的数据 然后看预定时间是否已经过时 如果已经过时 修改数据库中的remind
        for (int i = 0; i < list.size(); i++) {
            //这个时间应该是存放在数据库记录的时间把
            Timestamp huoQuShiJian = list.get(i).getArriveTime();           //获取到达时间
            time = timestamp.getTime() - huoQuShiJian.getTime();
            //计算时间差  如果当前时间大于 预定的时间 证明这个预定过期了  然后就修改他的remind
            if (time >= 0) {
                Integer id = list.get(i).getId();
                preService.updateRemind(id);
            }
        }




        PageInfo<PredeterminePojo> pageInfo = preService.pageFuzzyselect(pre);

        List<PredetermineResp> data = new ArrayList<>();

        for (PredeterminePojo predeterminePojo : pageInfo.getList()) {
            PredetermineResp resp = new PredetermineResp();
            BeanUtils.copyProperties(predeterminePojo,resp );
            resp.setTime(resp.getArriveTime().toString());
            data.add(resp);
        }

//        for (PredetermineResp predetermineResp : data) {
//            //TODO 方便前端展示 不需要判断直接赋值就好了
//            if (predetermineResp.getPassengerName()== null || !"".equals(predetermineResp.getPassengerName())){
//                predetermineResp.setPassengerName(predetermineResp.getReceivePrincipal());
//
//            }
//        }

        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).getPassengerName()== null || !"".equals(data.get(i).getPassengerName())){
//                System.out.println(data.get(i).getReceivePrincipal() +":" + data.get(i).getPassengerName());
//                data.get(i).setReceivePrincipal(data.get(i).getPassengerName());
            if (data.get(i).getReceivePrincipal() ==  null || "".equals(data.get(i).getReceivePrincipal())){

                data.get(i).setReceivePrincipal(data.get(i).getPassengerName());

            }

            }

        PreGetListResp preGetListResp = new PreGetListResp(data);

        preGetListResp.setPageNum(pre.getPageNum());

        preGetListResp.setPageSize(pre.getPageSize());

        preGetListResp.setTotalRecord(pageInfo.getTotal());

        long totalPage = preGetListResp.getTotalRecord()% preGetListResp.getPageSize()==0?preGetListResp.getTotalRecord()/preGetListResp.getPageSize():preGetListResp.getTotalRecord()/preGetListResp.getPageSize()+1;

        preGetListResp.setTotalPage(totalPage);

        return new BaseRespEntity(preGetListResp);
    }


//    public String get

    @ResponseBody
    @RequestMapping(value = "listone")
    public BaseRespEntity getListOne(){
        List<AttributePojo> list = attributeService.selectPredetermineState();

        return new BaseRespEntity(list);
    }

    @ApiOperation(value = "选择对象", notes = "返回旅游团信息")
    @ResponseBody
    @RequestMapping(value="/selectTarget", produces = "application/json; charset=utf-8")
    public Object selectTarget(String txtname){
        //TODO 选择对象 后台获取的数据 (旅游团)  txtname - 模糊查询用的 默认的是空 搜索框理
        if (txtname == null) {
            txtname="";
        }
        List<ReceiveTargetPo> list=receiveTargetService.ajaxSelect(txtname);
//        Gson gson=new Gson();
//        return gson.toJson(list);



        return JSON.toJSONString(list);
    }

    @ApiOperation(value = "删除信息", notes = "通过ID来删除")
    @ResponseBody
    @RequestMapping("/delete")
    public BaseRespEntity delete(String id , HttpServletResponse response){

//        System.out.println(id);
        //TODO 根据ID删除内容 多选删除。 所有用逗号分隔
//        ModelAndView mv=null;
        String[] FenGe=id.split(",");
        PreDeleteResp deleteResp = new PreDeleteResp(FenGe.length);
        for (int i = 0; i < FenGe.length; i++) {
            preService.deleteById(Integer.parseInt(FenGe[i]));
            Integer success = deleteResp.getSuccess();
            --success;
            deleteResp.setSuccess(success);
            if (success == 0){
                deleteResp.setSuccess(1);
            }
        }

        if (FenGe.length ==  0 && (id != null || !"".equals(id)) ){
            deleteResp.setSuccess(preService.deleteById(Integer.parseInt(id)));
        }

        if (deleteResp.getSuccess() == 1){
            deleteResp.setMsg("操作成功");
//            System.out.println(deleteResp.getMsg());

        }
        else{
            deleteResp.setMsg("删除失败");
        }

        return new BaseRespEntity(deleteResp);
    }

    @ApiOperation(value = "存储一个session", notes = "通过ID来删除")
    @ResponseBody
    @RequestMapping(value = "/setupdataid")
    public BaseRespEntity setSession(String id , HttpServletRequest request){

        request.getSession().setAttribute("id",id );

        PreDeleteResp deleteResp = new PreDeleteResp();

        if (id != null && !"".equals(id)){
            deleteResp.setMsg("即将跳转页面 请点击确定");
        }


        return new BaseRespEntity(deleteResp);
    }

    @ApiOperation(value = "获取上面存储的session", notes = "然后在这获取数revf据")
    @ResponseBody
    @RequestMapping(value = "/updatePre")
    public BaseRespEntity updatePre(HttpServletRequest request){
        String idi = (String)request.getSession().getAttribute("id");

        int id = 0;
            if ( idi == null || "".equals(idi)){
                id = 57;
            }else {
                id = Integer.parseInt(idi);
            }
        System.out.println(id);

        idP=null ;
        fangJianId=null ;


//        ModelAndView mv=null;
        int idid=0;
        PredeterminePojo zuwenPo=preService.findById(id);        //根据预订id来查询预订数据

        int lvKeId =zuwenPo.getPassengerID();                            //获取预订旅客id

        int teamId=zuwenPo.getPredetermineTargetID();                   //获取预订团队id

        List<PredeterminePojo> teamList=null;

        List<PredeterminePojo> lvKeList=null;

        List<AttributePojo> listOne =attributeService.selectPayWay();

        double yaJin=0;
        int zhengShu=0;
        String nameString="";
        //房间等级的集合
        List<RoomSetPo> roomSetPolist= new ArrayList<RoomSetPo>();

        RoomSetPo roomSetPo=null;

        int type=0;

//        mv=new ModelAndView("/predetermine/update");

        //如果没有这个旅客id 那么他就是团队的
        if (lvKeId==0) {

            idid=teamId; //自己创建的变量 = 预订团队id

            teamList =preService.findTeamId(teamId); //通过团队id 查

            //p.predetermineTargetID=#{predetermineTargetID,jdbcType=INTEGER}

            idP = new int[teamList.size()];//把集合中的id 存放到这个idP数组里边来

            fangJianId = new int[teamList.size()];

            for (int i = 0; i < teamList.size(); i++) {

                yaJin+=teamList.get(i).getDeposit(); //TODO 获取这个人的押金

                roomSetPo=roomSetService.selectById(teamList.get(i).getRoomID()); //TODO 通过房间ID查出一个房间的实体类

                roomSetPolist.add(roomSetPo);//添加到集合

                idP[i]=teamList.get(i).getId();//并且用数组记录他的订单ID

                fangJianId[i]=teamList.get(i).getRoomID();//房间数组记录 房间的ID
            }
            zhengShu = (int)yaJin;//这是这个集合总共押金

//            mv.addObject("listList",teamList);
            nameString=teamList.get(0).getReceiveTeamName(); //获取这个团队的名字

            type=1;//1 说明这个是团队

        }else {

            idid=lvKeId;


            lvKeList=preService.findLvKeId(lvKeId);

            idP=new int[lvKeList.size()];

            fangJianId=new int[lvKeList.size()];

            for (int i = 0; i < lvKeList.size(); i++) {

                yaJin+=lvKeList.get(i).getDeposit();
                //这东西为空？
                roomSetPo = roomSetService.selectById(lvKeList.get(i).getRoomID());

                roomSetPolist.add(roomSetPo);

                idP[i]=lvKeList.get(i).getId();

                fangJianId[i]=lvKeList.get(i).getRoomID();

            }
            zhengShu=(int)yaJin;
//            mv.addObject("listList",lvKeList);
            nameString = lvKeList.get(0).getPassengerName();

            type=2;//2是旅客
        }

        List<RoomGetListResp> data = new ArrayList<>();
        for (RoomSetPo setPo : roomSetPolist) {
            RoomGetListResp roomGetListResp = new RoomGetListResp();

            BeanUtils.copyProperties(setPo,roomGetListResp );
            data.add(roomGetListResp);
        }


        //TODO 装载数据
        PreUpdateResp updateResp = new PreUpdateResp(data);

        updateResp.setType(type);

        updateResp.setId(idid);

        updateResp.setTotalMoney(zhengShu);

        updateResp.setName(nameString);

        updateResp.setTotalRecord(1);

        updateResp.setPangduan(1);

        if (listOne != null)
        updateResp.setPayWayID(listOne.get(0).getFar_id());



        if(lvKeList== null){
            updateResp.setPredetermineDay(teamList.get(0).getPredetermineDay());
            updateResp.setTime(teamList.get(0).getArriveTime().toString());

        }else {
            updateResp.setPredetermineDay(lvKeList.get(0).getPredetermineDay());

            updateResp.setTime(lvKeList.get(0).getArriveTime().toString());


        }

//        updateResp


//        mv.addObject("id",idid);
//        mv.addObject("listOne",listOne);
//        mv.addObject("roomSetPolist",roomSetPolist);
//        mv.addObject("zhengShu",zhengShu);
//        mv.addObject("name",nameString);
//        mv.addObject("type",type);
//        mv.addObject("pangduan",1);
//        return mv;
        return new BaseRespEntity(updateResp);
    }

    @ApiOperation(value = "获取房间详细信息", notes = "")
    @ResponseBody
    @RequestMapping(value="/selectRoom",produces = "application/json; charset=utf-8")
    public Object selectRoom(String roomNumber){

        if(roomNumber==null){
            roomNumber="";
        }
        List<RoomSetPo> list=roomSetService.selectInformation(roomNumber);
//        Gson gson=new Gson();
////        return gson.toJson(list);

        return JSON.toJSONString(list);
    }

    //去新增界面
    @RequestMapping("/toadd")
    public BaseRespEntity toadd(Integer id, String name, Integer type){
        ModelAndView mv=null;
        List<AttributePojo> listOne =attributeService.selectPayWay(); //查出好像是一个房间集合？
        mv=new ModelAndView("/predetermine/add");
        mv.addObject("id",id);
        mv.addObject("name",name);
        mv.addObject("type",type);
        mv.addObject("listOne",listOne);
        PreAddRespEntity add = new PreAddRespEntity();
        return add(add);
    }

    //新增
    @ApiOperation(value = "预定修改接口", notes = "")
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseRespEntity add(@RequestBody PreAddRespEntity add){

        Integer id = add.getLvkeorteamId();
        Integer type = add.getTeamId();
        Integer pangduan = add.getPangduan();
        String roomIdShuZu = add.getRoomIdShuZu();
        System.out.println(roomIdShuZu);

        //TODO 前端转换不到Timestamp  手动转换~
        String time = add.getTime();
        //
        DateFormat dformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //设置日期格式
        dformat.setLenient(false);
        try {
            add.setArriveTime(new Timestamp(dformat.parse(time).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        System.out.println(add.getArriveTime().toString());

        PredeterminePojo po = new PredeterminePojo();

        BeanUtils.copyProperties(add, po);

//        ModelAndView mv=null;
        if(pangduan!=null){
            for (int i = 0; i < idP.length; i++) {
                preService.deleteById(idP[i]);
            }
            RoomSetPo roomSetPo =new RoomSetPo();
            roomSetPo.setRoomStateID(1);                       //将此房态设置为空房
            for (int i = 0; i < fangJianId.length; i++) {

                roomSetPo.setId(fangJianId[i]);
                roomSetService.updateByIdToRoomState(roomSetPo);    //修改此房态
            }
        }

        String[] FenGe=roomIdShuZu.split(",");             //分割为数组

        int changDu= FenGe.length;                          //获取数组长度

        double yaJin=po.getDeposit();                      //获取押金

        double yaJinFenGe = yaJin/changDu;                   //得到平均押金

        po.setDeposit(yaJinFenGe);                         //设po的押金

        po.setPredetermineStateID(66);                     //设置预订状态为未按排

        if(type==1){                                       //如果为团队

            po.setPassengerID(0);                          //设置预订旅客id为0

            po.setPredetermineTargetID(id);                //设置团队id

        }else if(type==2){                                 //判断是否为旅客

            po.setPassengerID(id);                         //给预订赋值旅客id

            po.setPredetermineTargetID(2);                 //设置团队id
        }
        RoomSetPo roomSetPo=new RoomSetPo();
        roomSetPo.setRoomStateID(4);                       //设置此房态为预订
        for(int i=0;i<changDu;i++){
            po.setRoomID(Integer.parseInt(FenGe[i]));      //给预订设置房间id
            preService.insertAll(po);             //新增预订单

            roomSetPo.setId(Integer.parseInt(FenGe[i]));   //更改房态的 获取房间id
            roomSetService.updateByIdToRoomState(roomSetPo);//修改房态为预订
        }
//        mv=new ModelAndView("redirect:/Predetermine/tolist.do");



        return new BaseRespEntity("200","操作成功");
    }


    @ResponseBody
    //修改房间，移除房间时更改房态
    @RequestMapping(value = "/arrangeRoom")
    public BaseRespEntity arrangeRoom(String id){

//        ModelAndView mv=null;
//        String id = preArrangeRomm.getId();


        Date date=new Date();
        DateFormat dformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //设置日期格式
        Timestamp timestamp=Timestamp.valueOf(dformat.format(date)) ;  //将当前时间转为字符串


        String[] FenGe=id.split(",");                                    //分割到数组
        StayRegisterPo stayRegisterPo=new StayRegisterPo();
        RoomSetPo roomSetPoToRoomState=new RoomSetPo();
        for (int i = 0; i < FenGe.length; i++) {

            this.preService.updatePredetermineStateID(Integer.parseInt(FenGe[i]));              //修改预订状态

            PredeterminePojo predeterminePo=this.preService.findById(Integer.parseInt(FenGe[i])); //查询预订信息

            RoomSetPo roomSetPo=this.roomSetService.selectById(predeterminePo.getRoomID());              //查询房间信息

            stayRegisterPo.setRoomID(predeterminePo.getRoomID());                                        //设置房间id

            stayRegisterPo.setRentOutTypeID(26);

            stayRegisterPo.setPassengerTypeID(29);

            if (predeterminePo.getPassengerID()==0) {                              //判断是否为团队还是散客

                stayRegisterPo.setBillUnitID(28);

            }else {

                stayRegisterPo.setBillUnitID(27);

            }
            stayRegisterPo.setReceiveTargetID(predeterminePo.getPredetermineTargetID());

            stayRegisterPo.setIsBillID(68);

            stayRegisterPo.setRegisterTime(timestamp);

            stayRegisterPo.setStayNumber(predeterminePo.getPredetermineDay());

            stayRegisterPo.setSumConst(roomSetPo.getStandardPriceDay()
                    *Integer.parseInt(predeterminePo.getPredetermineDay()));      //获取房价 乘以 住宿天数

            stayRegisterService.insertAll(stayRegisterPo); //新增成功时，获取刚新增的id。   //这个报错了

            Integer stayId=stayRegisterPo.getId();

            stayRegisterService.updateStayRegisterPredetermineID(Integer.parseInt(FenGe[i]), stayId);

            stayRegisterPo.setDepositStayRegisterID(stayId);

            stayRegisterPo.setDepositRegisterTime(timestamp);

            stayRegisterPo.setDepositPayWayID(predeterminePo.getPayWayID());

            stayRegisterPo.setDeposit(predeterminePo.getDeposit());

            stayRegisterService.insertDeposit(stayRegisterPo);

            roomSetPoToRoomState.setId(predeterminePo.getRoomID());      //给新的 Po 赋房间ID的值

            roomSetPoToRoomState.setRoomStateID(65);                     //给新的 Po 赋房态的值

            roomSetService.updateByIdToRoomState(roomSetPoToRoomState);  //根据 房间ID 来修改 当前被选中的房间的房态

        }


//        if (preArrangeRomm.getSuccess() == 1) {
//            mv=new ModelAndView("redirect:/StayRegister/tolist.do");
//        }else if (preArrangeRomm.getSuccess() == 2){

//            mv=new ModelAndView("redirect:/Predetermine/tolist.do");
//        }
//        return mv;
        return new BaseRespEntity("200","操作成功" );
    }


}

