package com.hotel.sofiter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.hotel.sofiter.dao.TbReceiveTargetMapper;
import com.hotel.sofiter.domain.receivetarget.ReceiveAddEntity;
import com.hotel.sofiter.domain.receivetarget.ReceiveQueryEntity;
import com.hotel.sofiter.domain.receivetarget.ReceiveUpdateEntity;
import com.hotel.sofiter.pojo.ReceiveTargetPo;
import com.hotel.sofiter.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value="receiveService")
public class ReceiveServiceImpl implements ReceiveService {

	@Autowired
	private TbReceiveTargetMapper tbReceiveTargetMapper;
//	@Resource
//	private ReceiveDao receiveDao;


    /*@Resource
    TbReceiveTargetMapper tbReceiveTargetMapper;*/
    @Override
    public PageInfo<ReceiveTargetPo> pageFuzzyselect(ReceiveQueryEntity receiveQueryEntity) {

        PageHelper.startPage(receiveQueryEntity.getPageNum(),receiveQueryEntity.getPageSize());

        /*用mybatis分页插件来实现自动分页*/
        int start = receiveQueryEntity.getPageNum();
        int pageSize = receiveQueryEntity.getPageSize();
        PageHelper.startPage(start,pageSize);

//        List<ReceiveTargetPo> data = tbReceiveTargetMapper.pageFuzzyselect();

        /*4.7.5添加orderStr,排序*/
        String orderStr = getOrderStr(receiveQueryEntity);

        String searchName = receiveQueryEntity.getSearch();
        List<ReceiveTargetPo> data = tbReceiveTargetMapper.pageFuzzyselect(orderStr,searchName);

        return new PageInfo<ReceiveTargetPo>(data);
    }


    /*4.7.5添加orderStr,排序*/
    private String getOrderStr(ReceiveQueryEntity receiveQueryEntity){
        /*4.7多用StringBuffer少用string有内存泄漏*/
        StringBuffer stringBuffer = new StringBuffer();
        /*从前端复制返回数据类型来改，可以用switch来做（78天视频有），前端传回的参数为1234分别对应id,goodsType...*/
       /* 从data.html查columns: [
                  { "data": "id" },
                  { "data": "targetTypeID" },
                  { "data": "teamName" },
                  { "data": "teamCode" },
                  { "data": "principal" },
                  { "data": "registerTime" },
                  { "data": "contactPhoneNUmber" }
      ]*/
        /*4.7.5记得加是否为空的判断，不然可能就被卡在那了，用!StringUtil.isEmpty做字符串为空判断*/
        if(!StringUtil.isEmpty(receiveQueryEntity.getOrder())) {
            String strs[] = {"id","targetTypeID","teamName","teamCode","principal","registerTime","contactPhoneNUmber"};
            stringBuffer.append(" order by "+strs[Integer.parseInt(receiveQueryEntity.getOrder())]+" " + receiveQueryEntity.getDir());
        }
        return stringBuffer.toString();
    }


    /*@Override
	public int deleteById(Integer id) {
		return tbReceiveTargetMapper.deleteById(id);
	}*/
	@Override
	public Integer deleteById(String[] receiveIds) {
		return tbReceiveTargetMapper.deleteById(receiveIds);
	}

	@Override
//	public int insertAll(ReceiveTargetPo receiveTargetPo) {
	public int insertAll(ReceiveAddEntity receiveAddEntity) {
        /*ReceiveAddEntity receiveAddEntity1 = new ReceiveAddEntity
                (receiveAddEntity.getTargetTypeID(),receiveAddEntity.getPrincipal(),
                        receiveAddEntity.getTeamName(),receiveAddEntity.getTeamCode(),
                        null,receiveAddEntity.getContactPhoneNUmber());*/

        System.out.println("ReceiveServiceImpl : " + receiveAddEntity);
        return tbReceiveTargetMapper.insertAll(receiveAddEntity);

	}

	@Override
	public ReceiveTargetPo selectById(Integer id) {
		return tbReceiveTargetMapper.selectById(id);
	}

	@Override
	public int updateById(ReceiveUpdateEntity receiveUpdateEntity) {
		return tbReceiveTargetMapper.updateById(receiveUpdateEntity);
	}

	@Override
	public PageInfo<ReceiveTargetPo> getReceiveList(ReceiveQueryEntity receiveQueryEntity) {
		// (当前页，每页的数量)
		PageHelper.startPage(receiveQueryEntity.getPageNum(),receiveQueryEntity.getPageSize());
		// 数据库查询
//		List<ReceiveTargetPo> data = tbReceiveTargetMapper.selectAll();

//		return new PageInfo<ReceiveTargetPo>(data);
        return null;
	}

	/*@Override
	public Page<ReceiveTargetPo> pageFuzzyselect(String teamName, Page<ReceiveTargetPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<ReceiveTargetPo> list=tbReceiveTargetMapper.pageFuzzyselect(teamName, start, vo.getPageSize());
		vo.setResult(list);
		int count=tbReceiveTargetMapper.countFuzzyselect(teamName);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public List<TbReceiveTarget> ajaxSelect(String teamName) {
		return tbReceiveTargetMapper.ajaxSelect(teamName);
	}

	@Override
	public int selectYZ(String teamCode) {
		return this.tbReceiveTargetMapper.selectYZ(teamCode);
	}*/

}
