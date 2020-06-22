package com.zty.project.controller;

import com.zty.project.dao.ConversionDao;
import com.zty.project.dao.StationDao;
import com.zty.project.entity.Conversion;
import com.zty.project.service.RiskshowService;
import com.zty.project.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "统计数据接口")
@RestController
@RequestMapping("statistics")
@CrossOrigin
public class StatisticsController {
    @Autowired
    private RiskshowService riskshowService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private StationDao stationDao;

    @Autowired
    private ConversionDao conversionDao;

    @ApiOperation(value = "查找积分前三" , notes = "")
    @GetMapping("/find_riskshow_awarda")
    public List<Map> find_riskshow_awarda() {
        return riskshowService.find_riskshow_awarda();
    }

    @ApiOperation(value = "积分奖励" , notes = "")
    @GetMapping("/find_riskshow_award")
    public int find_riskshow_award() {
        return riskshowService.find_riskshow_award();
    }

    @ApiOperation(value = "统计饼图(risk_id)" , notes = "")
    @GetMapping("/find_riskshow_b")
    public List<Map> find_riskshow_b() {
        return riskshowService.find_riskshow_b();
    }

    @ApiOperation(value = "统计饼图 (station_id)" , notes = "")
    @GetMapping("/find_riskshow_c")
    public List<Map> find_riskshow_c() {
        return riskshowService.find_riskshow_c();
    }

    @ApiOperation(value = "返回本月份" , notes = "")
    @GetMapping("/find_month")
    public int find_month() {
        return riskshowService.find_month();
    }

    @ApiOperation(value = "查询当月上旬数据的条数" , notes = "")
    @GetMapping("/find_riskshow_top")
    public int find_riskshow_top() {
        return riskshowService.find_riskshow_top();
    }

    @ApiOperation(value = "查询当月中旬数据的条数" , notes = "")
    @GetMapping("/find_riskshow_mid")
    public int find_riskshow_mid() {
        return riskshowService.find_riskshow_mid();
    }

    @ApiOperation(value = "查询当月下旬数据的条数" , notes = "")
    @GetMapping("/find_riskshow_end")
    public int find_riskshow_end() {
        return riskshowService.find_riskshow_end();
    }

    @ApiOperation(value = "查询当月上旬有效数据的条数" , notes = "")
    @GetMapping("/find_riskshow_top_y")
    public int find_riskshow_top_y() {
        return riskshowService.find_riskshow_top_y();
    }

    @ApiOperation(value = "查询当月中旬有效数据的条数" , notes = "")
    @GetMapping("/find_riskshow_mid_y")
    public int find_riskshow_mid_y() {
        return riskshowService.find_riskshow_mid_y();
    }

    @ApiOperation(value = "查询当月下旬有效数据的条数" , notes = "")
    @GetMapping("/find_riskshow_end_y")
    public int find_riskshow_end_y() {
        return riskshowService.find_riskshow_end_y();
    }

    @ApiOperation(value = "查询当前月上传隐患的条数" , notes = "")
    @PostMapping("/count_riskshow_all")
    public int count_riskshow_all() {
        return riskshowService.count_riskshow_all();
    }

    @ApiOperation(value = "查询当前月审核通过的隐患条数" , notes = "")
    @PostMapping("/count_riskshow_true")
    public int count_riskshow_true() {
        return riskshowService.count_riskshow_true();
    }

    @ApiOperation(value = "统计总人数" , notes = "")
    @PostMapping("/count_staff")
    public int count_staff() {
        return staffService.count_staff();
    }

    @ApiOperation(value = "统计男生人数" , notes = "")
    @PostMapping("/count_staff_man")
    public int count_staff_man() {
        return staffService.count_staff_man();
    }

    @ApiOperation(value = "统计女生人数" , notes = "")
    @PostMapping("/count_staff_girl")
    public int count_staff_girl() {
        return staffService.count_staff_girl();
    }

    @ApiOperation(value = "统计总站点数" , notes = "")
    @PostMapping("/count_station")
    public int count_station() {
        return stationDao.count_station();
    }

    @ApiOperation(value = "查找兑换信息" , notes = "")
    @PostMapping("/select_conversion")
    public List<Conversion> select_conversion() {
        return conversionDao.select_conversion();
    }
}
