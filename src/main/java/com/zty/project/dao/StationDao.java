package com.zty.project.dao;

import com.zty.project.entity.Station;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface StationDao {
    //查找所有站点信息
    List<Station> find_station(Map map);

    //怎加站点信息
    int add_station(Map map);

    //删除站点信息
    int del_station(Map map);

    //修改站点信息
    int upd_station(Map map);

    //统计总条数
    long total();

    //下拉框查找站点
    List<Station> select_station();

    //计算天数
    int count(Map map);
}
