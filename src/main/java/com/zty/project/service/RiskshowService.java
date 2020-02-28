package com.zty.project.service;

import com.zty.project.dao.RiskshowDao;
import com.zty.project.entity.Riskshow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RiskshowService implements RiskshowDao {
    @Autowired
    private RiskshowDao riskshowDao;

    //分页模糊查询隐患风险记录
    @Override
    public List<Riskshow> find_riskshow(Map map) {
        return riskshowDao.find_riskshow(map);
    }

    //统计总条数
    @Override
    public long total(Map map) {
        return riskshowDao.total(map);
    }

    //增加隐患信息
    @Override
    public int add_riskshow(Map map) {
        return riskshowDao.add_riskshow(map);
    }

    //整改上报
    @Override
    public int upd_riskshow(Map map) {
        return riskshowDao.upd_riskshow(map);
    }

    //删除隐患信息
    @Override
    public int del_riskshow(Map map) {
        return riskshowDao.del_riskshow(map);
    }

    //查询个人隐患信息
    @Override
    public List<Riskshow> find_riskshow_sid(Map map) {
        return riskshowDao.find_riskshow_sid(map);
    }


    //前端展示页数据
    //查找积分前三
    @Override
    public List<Map> find_riskshow_awarda() {
        return riskshowDao.find_riskshow_awarda();
    }

    //积分奖励
    @Override
    public int find_riskshow_award() {
        return riskshowDao.find_riskshow_award();
    }

    //统计饼图(risk_id)
    @Override
    public List<Map> find_riskshow_b() {
        return riskshowDao.find_riskshow_b();
    }

    //统计饼图 (station_id)
    @Override
    public List<Map> find_riskshow_c() {
        return riskshowDao.find_riskshow_c();
    }

    //返回本月份
    @Override
    public int find_month() {
        return riskshowDao.find_month();
    }

    //查询当月上旬数据的条数
    @Override
    public int find_riskshow_top() {
        return riskshowDao.find_riskshow_top();
    }

    //查询当月中旬数据的条数
    @Override
    public int find_riskshow_mid() {
        return riskshowDao.find_riskshow_mid();
    }

    //查询当月下旬数据的条数
    @Override
    public int find_riskshow_end() {
        return riskshowDao.find_riskshow_end();
    }

    //查询当月上旬有效数据的条数
    @Override
    public int find_riskshow_top_y() {
        return riskshowDao.find_riskshow_top_y();
    }

    //查询当月中旬有效数据的条数
    @Override
    public int find_riskshow_mid_y() {
        return riskshowDao.find_riskshow_mid_y();
    }

    //查询当月下旬有效数据的条数
    @Override
    public int find_riskshow_end_y() {
        return riskshowDao.find_riskshow_end_y();
    }

    //查询当前月上传隐患的条数
    @Override
    public int count_riskshow_all() {
        return riskshowDao.count_riskshow_all();
    }

    //查询当前月审核通过的隐患条数
    @Override
    public int count_riskshow_true() {
        return riskshowDao.count_riskshow_true();
    }

    @Override
    public int upd_state(Map map) {
        return riskshowDao.upd_state(map);
    }


}
