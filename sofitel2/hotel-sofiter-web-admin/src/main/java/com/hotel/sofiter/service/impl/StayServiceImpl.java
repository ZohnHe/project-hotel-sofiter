package com.hotel.sofiter.service.impl;

import com.hotel.sofiter.dao.StayRegisterDao;
import com.hotel.sofiter.page.Page;
import com.hotel.sofiter.pojo.StayRegisterPo;
import com.hotel.sofiter.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class StayServiceImpl implements StayService {

    @Autowired
    private StayRegisterDao stayRegisterDao;

    @Override
    public int insertAll(StayRegisterPo stayRegisterPo) {
        return stayRegisterDao.insertAll(stayRegisterPo);
    }

    @Override
    public StayRegisterPo selectById(Integer id) {
        return null;
    }

    @Override
    public int insertStayregisterdetails(int stayRegisterID, int passengerID) {
        return 0;
    }

    @Override
    public int insertDeposit(StayRegisterPo stayRegisterPo) {
        return stayRegisterDao.insertDeposit(stayRegisterPo);
    }

    @Override
    public List<StayRegisterPo> selectDepositById(int id) {
        return null;
    }

    @Override
    public int insertConsumptiondetails(StayRegisterPo stayRegisterPo) {
        return 0;
    }

    @Override
    public Page<StayRegisterPo> pageConsumption(int consumptionStayRegisterID, Page<StayRegisterPo> vo) {
        return null;
    }

    @Override
    public int deleteConsumption(Integer id) {
        return 0;
    }

    @Override
    public int updateSumConst(int id, Double sumConst) {
        return 0;
    }

    @Override
    public List<StayRegisterPo> selectMoney(int id) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectChangRoom(int id) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectAll() {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectShuJuTongJi(Timestamp min, Timestamp max) {
        return null;
    }

    @Override
    public int updateRemind(int id, int remind) {
        return 0;
    }

    @Override
    public int updateChangRoom(StayRegisterPo stayRegisterPo) {
        return 0;
    }

    @Override
    public int pay(int id, String remarks, Timestamp payTime, int payWay) {
        return 0;
    }

    @Override
    public List<StayRegisterPo> selectFormTeamId(int receiveTargetID, int isBillID) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectFormTeamIdTwo(int isBillID) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectTeamDeposit(int receiveTargetID) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectTeamConsumption(int receiveTargetID) {
        return null;
    }

    @Override
    public List<StayRegisterPo> ajaxSelectTeamRoom(int receiveTargetID, String roomNumber) {
        return null;
    }

    @Override
    public List<StayRegisterPo> ajaxSelectTeamFormTime(int receiveTargetID, Timestamp min, Timestamp max) {
        return null;
    }

    @Override
    public List<StayRegisterPo> ajaxSelectTeamDeposit(int receiveTargetID, Timestamp min, Timestamp max) {
        return null;
    }

    @Override
    public List<StayRegisterPo> ajaxSelectTeamConsumption(int receiveTargetID, Timestamp min, Timestamp max) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectDepositJinJianBan(int id) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectConsumptionJinJianBan(int id) {
        return null;
    }

    @Override
    public StayRegisterPo selectInformationXiangQingBan(int id) {
        return null;
    }

    @Override
    public int changOverTeam(int id, int receiveTargetID) {
        return 0;
    }

    @Override
    public StayRegisterPo selectSumconst(int id) {
        return null;
    }

    @Override
    public int updateStayRegisterPredetermineID(Integer predetermineID, Integer id) {
        return this.stayRegisterDao.updateStayRegisterPredetermineID(predetermineID, id);
    }

    @Override
    public Page<StayRegisterPo> pageFuzzyselectOne(int receiveTargeTypeID, int isBillID, String roomNumber, Page<StayRegisterPo> vo) {
        return null;
    }

    @Override
    public Page<StayRegisterPo> pageFuzzyselectTwo(int receiveTargetID, int isBillID, String roomNumber, Page<StayRegisterPo> vo) {
        return null;
    }

    @Override
    public Page<StayRegisterPo> pageFuzzyselectThree(int isBillID, String roomNumber, Page<StayRegisterPo> vo) {
        return null;
    }

    @Override
    public Page<StayRegisterPo> pageFuzzyselectFour(Page<StayRegisterPo> vo) {
        return null;
    }

    @Override
    public Page<StayRegisterPo> pageFuzzyselectFive(Timestamp min, Timestamp max, Page<StayRegisterPo> vo) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectPayJingJianBanNot() {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectPayStayNumberNot() {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectPayXiaoFeiNot() {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectPayJingJianBan(Timestamp min, Timestamp max) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectPayStayNumber(Timestamp min, Timestamp max) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectPayXiaoFei(Timestamp min, Timestamp max) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectAllInformation(int id) {
        return null;
    }

    @Override
    public List<StayRegisterPo> selectXiaoFeiMingXi(int id) {
        return null;
    }
}
