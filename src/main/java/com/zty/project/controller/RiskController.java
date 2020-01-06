package com.zty.project.controller;

import com.zty.project.dao.RiskDao;
import com.zty.project.entity.Risk;
import com.zty.project.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "隐患风险类型信息")
@RestController
@RequestMapping("risk")
@CrossOrigin
public class RiskController {
    @Autowired
    private RiskDao riskDao;

    @ApiOperation(value = "分页模糊查询风险类型信息", notes = "测试数据:{\"pageNo\": 1, \"pageSize\":10}")
    @PostMapping("/find_risk")
    public Page<Risk> find_risk(@RequestBody Map map) {
        Page<Risk> page = new Page<Risk>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(riskDao.total(map));
        page.setItems(riskDao.find_risk(map));
        return page;
    }

    @ApiOperation(value = "增加风险类型信息", notes = "测试数据:")
    @PostMapping("/add_risk")
    public boolean add_risk(@RequestBody Map map) {
        return riskDao.add_risk(map) == 1;
    }

    @ApiOperation(value = "修改风险类型信息", notes = "测试数据:")
    @PostMapping("/upd_risk")
    public boolean upd_risk(@RequestBody Map map) {
        return riskDao.upd_risk(map) == 1;
    }

    @ApiOperation(value = "删除风险类型信息", notes = "测试数据:")
    @PostMapping("/del_risk")
    public boolean del_risk(@RequestBody Map map) {
        return riskDao.del_risk(map) == 1;
    }

    @ApiOperation(value = "下拉框查询风险类型信息", notes = "测试数据:")
    @PostMapping("/select_risk")
    public List<Risk> select_risk() {
        return riskDao.select_risk();
    }
}
