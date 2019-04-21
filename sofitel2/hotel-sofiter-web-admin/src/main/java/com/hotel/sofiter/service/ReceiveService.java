package com.hotel.sofiter.service;

import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.domain.receivetarget.ReceiveAddEntity;
import com.hotel.sofiter.domain.receivetarget.ReceiveQueryEntity;
import com.hotel.sofiter.domain.receivetarget.ReceiveUpdateEntity;
import com.hotel.sofiter.pojo.ReceiveTargetPo;

public interface ReceiveService {

	//列表展示查询，引进mybatis分页插件pagehelper，PageInfo为mybatis分页器pagehelper封装的
	public PageInfo<ReceiveTargetPo> pageFuzzyselect(ReceiveQueryEntity receiveQueryEntity);

	/**
	 * 根据id删除接待对象
	 * @param ids
	 * @return
	 */
//	public int deleteById(Integer id);
	public Integer deleteById(String[] ids);

	/**
	 * 插入接待对象
	 * @param receiveAddEntity
	 * @return
	 */
//	public int insertAll(ReceiveTargetPo receiveTargetPo);
	public int insertAll(ReceiveAddEntity receiveAddEntity);

	/**
	 * 根据id搜索接待对象
	 * @param id
	 * @return
	 */
	public ReceiveTargetPo selectById(Integer id);

	/**
	 * 修改接待对象
	 * @param receiveUpdateEntity
	 * @return
	 */
	public int updateById(ReceiveUpdateEntity receiveUpdateEntity);

	/**
	 * 接待对象分页
	 * @param receiveQueryEntity
	 * @return
	 */
	public PageInfo<ReceiveTargetPo> getReceiveList(ReceiveQueryEntity receiveQueryEntity);










	/*//分页需要
	public Page<ReceiveTargetPo> pageFuzzyselect(String teamName, Page<ReceiveTargetPo> vo);


	//ajax 验证是否存在 此团队编号
	public int selectYZ(String teamCode);


	//ajax查询 预订所用
	public List<ReceiveTargetPo> ajaxSelect(String teamName);*/
}
