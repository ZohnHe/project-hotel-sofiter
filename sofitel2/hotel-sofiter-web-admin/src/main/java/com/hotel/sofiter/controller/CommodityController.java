package com.hotel.sofiter.controller;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.domain.commodity.*;
import com.hotel.sofiter.entity.resp.commodity.*;
import com.hotel.sofiter.pojo.AttributePojo;
import com.hotel.sofiter.pojo.TbCommodity;
import com.hotel.sofiter.service.AttributeService;
import com.hotel.sofiter.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/commodity")
@Api(tags = "房间管理/商品设置")
public class CommodityController {
    @Resource
    AttributeService attributeService;

    @Resource
    private CommodityService commodityService;
    @RequestMapping(value = "/tolist", method = RequestMethod.POST)
    @ApiOperation(value = "获取商品信息")
    @ResponseBody
    public CommodityPage<VoCommodityInfo> list(HttpServletRequest request, @RequestBody CommodityEntity commodityEntity) {
        //CommodityPage<TbCommodity> jj=new CommodityPage<TbCommodity>();
        /* 获取商品类型 */
        List<AttributePojo> tbAttributes = attributeService.selectCommodityType();
        /* 获取商品信息 */
        PageInfo<TbCommodity> list = commodityService.pageFuzzyselect(commodityEntity);
        /* 属性拷贝,可以使用Bean转换工具DozerBeanMapper */
        /* 作用是简化返回的数据 */
        List<VoCommodityInfo> data = new ArrayList<VoCommodityInfo>();
        if(list.getList() != null){
            for(TbCommodity tbCommodity:list.getList()){
                VoCommodityInfo bean = new VoCommodityInfo();
                try {
                    /* 把对应字段的属性值,拷贝过去*/
                    BeanUtils.copyProperties(tbCommodity, bean);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }
        /* 返回前端数据 */
        /* 设置商品信息 */
        CommodityPage<VoCommodityInfo> responseEntity = new CommodityPage(data);
        /* 页码 */
        responseEntity.setPageNum(list.getPageNum());
        /* 总数据条数 */
        responseEntity.setTotalRecord(list.getTotal());
        /* 设置商品类别 */
        responseEntity.setTbAttributes(tbAttributes);
        /* 数据总分页数 */
        long tobalPage = (responseEntity.getTotalRecord()+list.getPageSize()-1)/list.getPageSize();
        responseEntity.setTotalPage(tobalPage);
        return responseEntity;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除商品信息")
    @ResponseBody
    public CommodityDeleteResp deleteInt(HttpServletRequest request, @RequestBody CommodityDeleteEntity commodityDeleteEntity) {
        CommodityDeleteResp cdr = new CommodityDeleteResp();
        cdr.setResult(commodityService.deleteById(commodityDeleteEntity.getdeleteIds()));
        return cdr;
    }

    @RequestMapping(value = "/addname", method = RequestMethod.POST)
    @ApiOperation(value = "新增名称核实")
    @ResponseBody
    public CommodityCheckResp deleteInt(HttpServletRequest request, @RequestBody CommodityCheckNameEntity commodityCheckNameEntity) {
        CommodityCheckResp cdr = new CommodityCheckResp();
        cdr.setResult(commodityService.selectName(commodityCheckNameEntity.getCommodityName()));
        return cdr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增")
    @ResponseBody
    public CommodityAddResp deleteInt(HttpServletRequest request, @RequestBody CommodityAddEntity commodityAddEntity) {
        CommodityAddResp cdr = new CommodityAddResp();
        cdr.setResult(commodityService.insertAll(commodityAddEntity));
        return cdr;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    @ResponseBody
    public CommodityUpdateResp deleteInt(HttpServletRequest request, @RequestBody CommodityUpdateEntity commodityUpdateEntity) {
        CommodityUpdateResp cdr = new CommodityUpdateResp();
        cdr.setResult(commodityService.updateById(commodityUpdateEntity));
        return cdr;
    }
}
