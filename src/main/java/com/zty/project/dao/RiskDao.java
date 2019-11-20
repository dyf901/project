package com.zty.project.dao;

import com.zty.project.entity.Risk;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RiskDao {
    //分页模糊查询风险类型信息
    List<Risk> find_risk(Map map);

    //统计总数
    long total(Map map);

    //增加风险类型信息
    int add_risk(Map map);

    //修改风险类型信息
    int upd_risk(Map map);

    //删除风险类型信息
    int del_risk(Map map);

    //下拉框查询风险信息
    List<Risk> select_risk();
}
