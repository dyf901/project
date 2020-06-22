package com.zty.project.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.zty.project.dao.StationDao;
import com.zty.project.entity.Station;
import com.zty.project.page.Page;
import com.zty.project.service.StationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api(description = "站点接口")
@RestController
@RequestMapping("station")
@CrossOrigin
public class StationController {
    @Autowired
    private StationDao stationDao;

    @ApiOperation(value = "分页模糊查询站点信息" , notes = "{\"pageNo\": 1, \n" +
            " \"pageSize\":10}")
    @PostMapping("find_station")
    public Page<Station> find_station(@RequestBody Map map) {
        Page<Station> page = new Page<Station>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(stationDao.total());
        page.setItems(stationDao.find_station(map));
        return page;
    }

    @ApiOperation(value = "增加站点信息" , notes = "{\"station_name\":\"鹿城路站（06标）\", \"start_time\":\"2019-06-15\", \"end_time\":\"2020-06-15\", \"station_principal\":\"晋铁科技\", \"station_area\":200000}")
    @PostMapping("add_station")
    public boolean add_station(@RequestBody Map map) {
        map.put("station_time" , stationDao.count(map));
        return stationDao.add_station(map) == 1;
    }

    @ApiOperation(value = "修改站点信息" , notes = "{\"station_name\":\"鹿城路站\",\n" +
            "\"station_time\":365,\n" +
            "\"start_time\":\"2019-06-15\",\n" +
            "\"end_time\":\"2020-06-15\",\n" +
            "\"station_principal\":\"晋铁科技\",\n" +
            "\"station_area\":200000,\n" +
            "\"id\":1}")
    @PostMapping("upd_station")
    public boolean upd_station(@RequestBody Map map) {
        map.put("station_time" , stationDao.count(map));
        return stationDao.upd_station(map) == 1;
    }

    @ApiOperation(value = "删除站点信息" , notes = "测试数据:{\"id\":1}")
    @PostMapping("del_station")
    public boolean del_station(@RequestBody Map map) {
        return stationDao.del_station(map) == 1;
    }

    @ApiOperation(value = "下拉框查找站点信息" , notes = "测试数据:")
    @PostMapping("select_station")
    public List<Station> select_station() {
        return stationDao.select_station();
    }
}
