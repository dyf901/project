package com.zty.project.controller;

import com.zty.project.dao.BehaviorDao;
import com.zty.project.entity.Behavior;
import com.zty.project.entity.Department;
import com.zty.project.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "行为接口")
@RestController
@RequestMapping("behavior")
@CrossOrigin
public class BehaviorController {
    @Autowired
    private BehaviorDao behaviorDao;

    @ApiOperation(value = "分页查询行为类型信息", notes = "测试数据:{\"pageNo\": 1,\n" +
            "  \"pageSize\": 10}")
    @PostMapping("/find_behavior")
    public Page<Behavior> find_behavior(@RequestBody Map map) {
        Page<Behavior> page = new Page<Behavior>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setItems(behaviorDao.find_behavior(map));
        page.setTotal(behaviorDao.total());
        return page;
    }

    @ApiOperation(value = "增加行为类型信息", notes = "测试数据:{{\"name\":\"表扬\",\n" +
            "\"detail\":\"给予员工达标的嘉奖\",\n" +
            "\"remark\":\"请详细记录受嘉奖的行为。\"}}")
    @PostMapping("/add_behavior")
    public boolean add_behavior(@RequestBody Map map) {
        return behaviorDao.add_behavior(map) == 1;
    }

    @ApiOperation(value = "修改行为类型信息", notes = "测试数据:{\"id\":8,\n" +
            "\"name\":\"聚众闹事\",\n" +
            "\"detail\":\"肆意挑衅，随意殴打、骚扰他人或任意损毁、占用公共财物\",\n" +
            "\"remark\":\"123\"}")
    @PostMapping("/upd_behavior")
    public boolean upd_behavior(@RequestBody Map map) {
        return behaviorDao.upd_behavior(map) == 1;
    }

    @ApiOperation(value = "删除行为类型信息", notes = "测试数据:{\"id\":9}")
    @PostMapping("/del_behavior")
    public boolean del_behavior(@RequestBody Map map) {
        return behaviorDao.del_behavior(map) == 1;
    }

    @ApiOperation(value = "下拉框查询行为类型", notes = "测试数据:")
    @PostMapping("/select_behavior")
    public List<Behavior> select_behavior() {
        return behaviorDao.select_behavior();
    }

}
