package com.zty.project.controller;

import com.zty.project.dao.WorkTypeDao;
import com.zty.project.entity.WorkType;
import com.zty.project.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "工种接口")
@RestController
@RequestMapping("worktype")
@CrossOrigin
public class WorkTypeController {
    @Autowired
    private WorkTypeDao workTypeDao;

    @ApiOperation(value = "分页查询工种" , notes = "测试数据:{\"pageNo\": 1,\n" +
            "  \"pageSize\": 10}")
    @PostMapping("/find_worktype")
    public Page<WorkType> find_worktype(@RequestBody Map map) {
        Page<WorkType> page = new Page<WorkType>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setItems(workTypeDao.find_worktype(map));
        page.setTotal(workTypeDao.total());
        return page;
    }

    @ApiOperation(value = "增加工种" , notes = "测试数据:{{\"name\":\"电工\", \n" +
            "\"content\":\"负责维修施工中遇到的电路问题\", \n" +
            "\"department_id\":1,\n" +
            "\"remark\":\"高危工种\"}}")
    @PostMapping("/add_worktype")
    public boolean add_worktype(@RequestBody Map map) {
        return workTypeDao.add_worktype(map) == 1;
    }

    @ApiOperation(value = "删除工种" , notes = "测试数据:{\"id\":3}")
    @PostMapping("/del_worktype")
    public boolean del_worktype(@RequestBody Map map) {
        return workTypeDao.del_worktype(map) == 1;
    }

    @ApiOperation(value = "修改工种" , notes = "测试数据:{\"id\":1,\n" +
            "\"name\":\"焊工\",\n" +
            "\"content\":\"对主管每日安排的产品进行焊接作业\",\n" +
            "\"department_id\":\"1\",\n" +
            "\"remark\":\"remark\"}")
    @PostMapping("/upd_worktype")
    public boolean upd_worktype(@RequestBody Map map) {
        return workTypeDao.upd_worktype(map) == 1;
    }

    @ApiOperation(value = "下拉框查询工种" , notes = "测试数据:")
    @PostMapping("/select_worktype")
    public List<WorkType> select_worktype() {
        return workTypeDao.select_worktype();
    }
}
