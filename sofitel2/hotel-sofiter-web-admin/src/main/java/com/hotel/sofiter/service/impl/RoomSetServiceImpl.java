package com.hotel.sofiter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.sofiter.dao.RoomSetDao;
import com.hotel.sofiter.dao.TbRoomMapperExt;
import com.hotel.sofiter.domain.room.RoomAddEntity;
import com.hotel.sofiter.domain.room.RoomModifyEntity;
import com.hotel.sofiter.domain.room.RoomQueryEntity;
import com.hotel.sofiter.page.Page;
import com.hotel.sofiter.pojo.RoomSetPo;
import com.hotel.sofiter.service.RoomSetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service(value="roomSetService")
public class RoomSetServiceImpl implements RoomSetService {

	@Autowired
	private RoomSetDao roomSetDao;
	
	/*@Override
	public List<RoomSetPo> selectAll() {
		return roomSetDao.selectAll();
	}
*/
	@Override
	public int deleteById(Integer id) {
		return roomSetDao.deleteById(id);
	}

	@Override
	public int insertAll(RoomSetPo roomSetPo) {
		return roomSetDao.insertAll(roomSetPo);
	}

	@Override
	public RoomSetPo selectById(Integer id) {
		return roomSetDao.selectById(id);
	}

	@Override
	public int updateById(RoomSetPo roomSetPo) {
		return roomSetDao.updateById(roomSetPo);
	}

	//模糊查询
	/*@Override
	public List<RoomSetPo> fuzzyselectPo(String roomNumber) {
		return roomSetDao.fuzzyselectPo(roomNumber);
	}*/
   

//分页的模糊查询
	@Override
	public Page<RoomSetPo> pageFuzzyselect(String roomNumber, Page<RoomSetPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<RoomSetPo> list=this.roomSetDao.pageFuzzyselect(roomNumber, start, vo.getPageSize());
		vo.setResult(list);
		
		int count=this.roomSetDao.countFuzzyselect(roomNumber);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public List<RoomSetPo> selectAll() {
		return roomSetDao.selectAll();
	}

	@Override
	public List<RoomSetPo> selectByLeveId(Integer id) {
		return roomSetDao.selectByLeveId(id);
	}

	@Override
	public int updateByIdToRoomState(RoomSetPo roomSetPo) {
		return roomSetDao.updateByIdToRoomState(roomSetPo);
	}

	@Override
	public List<RoomSetPo> selectInformation(String roomNumber) {
		return roomSetDao.selectInformation(roomNumber);
	}

	@Override
	public List<RoomSetPo> levelSelectInformation(Integer guestRoomLevelID) {
		return this.roomSetDao.levelSelectInformation(guestRoomLevelID);
	}

	@Override
	public int selectYZ(String roomNumber) {
		return this.roomSetDao.selectYZ(roomNumber);
	}

	@Override
	public List<RoomSetPo> selectAllRoom() {
		return roomSetDao.selectAll();
	}


//	------------------------------------------------------------------------桂林


	@Resource
	TbRoomMapperExt tbRoomMapperExt;

	@Override
	public PageInfo<RoomSetPo> getRoomList(RoomQueryEntity roomQueryEntity) {
		PageHelper.startPage(roomQueryEntity.getPageNum(),roomQueryEntity.getPageSize());

		List<RoomSetPo> data = tbRoomMapperExt.selectAll();

		System.out.println(data.toString()+"-----data");
		System.out.println(new PageInfo<RoomSetPo>(data)+"---服务层分页数据");
		return new PageInfo<RoomSetPo>(data);

	}

	@Override
	public Integer roomsDelete(String[] roomIds) {
		return tbRoomMapperExt.roomsDelete(roomIds);
	}

	@Override
	public Integer roomsAdd(RoomAddEntity roomAddEntity) {

		RoomSetPo roomSetPo = new RoomSetPo();

		BeanUtils.copyProperties(roomAddEntity,roomSetPo);
		System.out.println(roomSetPo.toString()+"---添加的实体数据");
		return tbRoomMapperExt.insertAll(roomSetPo);

	}

	@Override
	public Integer roomsModify(RoomModifyEntity roomModifyEntity) {

		RoomSetPo roomSetPo = new RoomSetPo();
		BeanUtils.copyProperties(roomModifyEntity,roomSetPo);
		System.out.println(roomSetPo.toString()+"-----修改的实体数据");
		return tbRoomMapperExt.updateById(roomSetPo);

	}

}
