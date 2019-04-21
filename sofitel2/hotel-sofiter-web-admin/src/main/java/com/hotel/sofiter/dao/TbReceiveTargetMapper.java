package com.hotel.sofiter.dao;

import com.hotel.sofiter.domain.receivetarget.ReceiveAddEntity;
import com.hotel.sofiter.domain.receivetarget.ReceiveUpdateEntity;
import com.hotel.sofiter.pojo.ReceiveTargetPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbReceiveTargetMapper {

    /**
     * 分页查询
     * @return
     */
//    public List<ReceiveTargetPo> pageFuzzyselect(@Param("start") int start, @Param("pageSize") int pageSize);
//    public List<ReceiveTargetPo> pageFuzzyselect();
      public List<ReceiveTargetPo> pageFuzzyselect
      (@Param("orderStr") String orderStr, @Param("search") String receiveName);

    /**
     * 添加接待对象
     * @param receiveAddEntity
     * @return
     */
//    public int insertAll(ReceiveTargetPo receiveTargetPo);
    public int insertAll(ReceiveAddEntity receiveAddEntity);

    /**
     * 根据id删除接待对象
     * @param receiveIds
     * @return
     */
//    public int deleteById(Integer receiveId);
    public Integer deleteById(@Param("receiveIds") String[] receiveIds);


    public ReceiveTargetPo selectById(Integer id);

    /**
     * 修改接待对象
     * @param receiveUpdateEntity
     * @return
     */
    public int updateById(ReceiveUpdateEntity receiveUpdateEntity);

    /*//分页模糊查询
    public List<ReceiveTargetPo> pageFuzzyselect(@Param("teamName") String teamName,
                                                 @Param("start") int start, @Param("pageSize") int pageSize);

    //分页模糊查询总条数
    public int countFuzzyselect(@Param("teamName") String teamName);



    //ajax 验证是否存在 此团队编号
    public int selectYZ(String teamCode);



    //ajax查询 预订所用
    public List<TbReceiveTarget> ajaxSelect(String teamName);*/

}