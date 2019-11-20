package com.zty.project.service;

import com.zty.project.dao.RiskDao;
import com.zty.project.entity.Risk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RiskService {
    @Autowired
    private RiskDao riskDao;

    //分页模糊查询风险类型信息
    public List<Risk> find_risk(Map map) {
        return riskDao.find_risk(map);
    }

    //统计总数
    public long total(Map map) {
        return riskDao.total(map);
    }

    //增加风险类型信息
    public int add_risk(Map map) {
        return riskDao.add_risk(map);
    }

    //修改风险类型信息
    public int upd_risk(Map map) {
        return riskDao.upd_risk(map);
    }

    //删除风险类型信息
    public int del_risk(Map map) {
        return riskDao.del_risk(map);
    }

    //下拉框查询风险信息
    public List<Risk> select_risk() {
        return riskDao.select_risk();
    }
}
