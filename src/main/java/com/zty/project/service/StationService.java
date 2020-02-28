package com.zty.project.service;

import java.util.List;
import java.util.Map;

import com.zty.project.dao.StationDao;
import com.zty.project.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StationService {
    @Autowired
    private StationDao stationDao;

    //分页模糊查询站点信息
    public List<Station> find_station(Map map) {
        return stationDao.find_station(map);
    }

    //增加站点信息
    public int add_station(Map map) {
        return stationDao.add_station(map);
    }

    //删除站点信息
    public int del_station(Map map) {
        return stationDao.del_station(map);
    }

    //修改站点信息
    public int upd_station(Map map) {
        return stationDao.upd_station(map);
    }

    //统计总数
    public long total() {
        return stationDao.total();
    }

    //下拉框查询站点信息
    public List<Station> select_station() {
        return stationDao.select_station();
    }

    //计算天数
    public int count(Map map) {
        return stationDao.count(map);
    }

    //统计站点总数
    public int count_station(){return stationDao.count_station();}
}
