package com.hotel.sofiter.dao;

import com.hotel.sofiter.pojo.TbReceiveTarget;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceiveDao {

	    public int deleteById(Integer id);


		public int insertAll(TbReceiveTarget receiveTargetPo);


		public	TbReceiveTarget selectById(Integer id);


		public int updateById(TbReceiveTarget receiveTargetPo);

		//分页模糊查询
	    public List<TbReceiveTarget> pageFuzzyselect(@Param("teamName") String teamName,
                                                     @Param("start") int start, @Param("pageSize") int pageSize);

	    //分页模糊查询总条数
	    public int countFuzzyselect(@Param("teamName") String teamName);
	    
	    
	    
	    //ajax 验证是否存在 此团队编号
	    public int selectYZ(String teamCode);
	    
	    
	    
	    //ajax查询 预订所用
	    public List<TbReceiveTarget> ajaxSelect(String teamName);

	
}
