package com.zty.project.dao;

import com.zty.project.entity.Riskshow;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RiskshowDao {
    //分页模糊查询隐患风险记录
    List<Riskshow> find_riskshow(Map map);

    //统计总条数
    long total(Map map);

    //增加隐患信息
    int add_riskshow(Map map);

    //整改上报
    int upd_riskshow(Map map);

    //删除隐患信息
    int del_riskshow(Map map);

    //查询个人隐患信息
    List<Riskshow> find_riskshow_sid(Map map);



    //前端展示数据
    //查找积分前三
    List<Map> find_riskshow_awarda();

    //积分奖励
    int find_riskshow_award();

    //统计饼图(risk_id)
    List<Map> find_riskshow_b();

    //统计饼图 (station_id)
    List<Map> find_riskshow_c();

    //返回本月份
    int find_month();

    //查询当月上旬数据的条数
    int find_riskshow_top();

    //查询当月中旬数据的条数
    int find_riskshow_mid();

    //查询当月下旬数据的条数
    int find_riskshow_end();

    //查询当月上旬有效数据的条数
    int find_riskshow_top_y();

    //查询当月中旬有效数据的条数
    int find_riskshow_mid_y();

    //查询当月下旬有效数据的条数
    int find_riskshow_end_y();

    //查询当前月上传隐患的条数
    int count_riskshow_all();

    //查询当前月审核通过的隐患条数
    int count_riskshow_true();
    //



    //修改隐患信息审核状态有效/无效
    int upd_state(Map map);
}
