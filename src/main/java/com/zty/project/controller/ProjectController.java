package com.zty.project.controller;

import com.zty.project.dao.ProjectDao;
import com.zty.project.dao.ScheduleDao;
import com.zty.project.entity.Project;
import com.zty.project.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "项目接口")
@RestController
@RequestMapping("project")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ScheduleDao scheduleDao;

    @ApiOperation(value = "分页模糊查询项目信息", notes = "测试数据:{\"pageNo\": 1,\n" +
            "\"pageSize\":10}")
    @PostMapping("/find_project")
    public Page<Project> find_project(@RequestBody Map map) {
        System.out.println(map.get("id"));
        Page<Project> page = new Page<Project>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(projectDao.total(map));
        page.setItems(projectDao.find_project(map));
        System.out.println(projectDao.find_project(map));
        return page;
    }


    @ApiOperation(value = "增加项目", notes = "测试数据:{\"project_name\":\"围护结构-地下连续墙(06)\", \"start_time\":\"2019-06-11\", \"end_time\":\"2019-06-11\", \"gross\":25, \"station_id\":11, \"person\":200 }")
    @PostMapping("/add_project")
    public boolean add_project(@RequestBody Map map) {
        return projectDao.add_project(map) == 1;
    }

    @ApiOperation(value = "修改项目", notes = "测试数据:{\"project_name\":\"围护结构-地下连续墙\", \"start_time\":\"2019-06-11\", \"end_time\":\"2019-06-11\", \"gross\":25, \"station_id\":11, \"person\":200,\n" +
            "\"id\":61 }")
    @PostMapping("/upd_project")
    public boolean upd_project(@RequestBody Map map) {
        return projectDao.upd_project(map) == 1;
    }

    @ApiOperation(value = "删除项目", notes = "测试数据:{\"id\":61}")
    @PostMapping("/del_project")
    public boolean del_project(@RequestBody Map map) {
        return projectDao.del_project(map) == 1;
    }

    @ApiOperation(value = "修改项目进度信息", notes = "测试数据:{\"accomplish_day\":1,\n" +
            "\"id\":61,\n" +
            "\"station_id\":20}")
    @PostMapping("/upd_project_accomplish")
    public boolean upd_project_accomplish(@RequestBody Map map) {
        scheduleDao.add_schedule(map);
        map.put("accomplish_month", scheduleDao.find_accomplish_sum(map));
        return projectDao.upd_project_accomplish(map) == 1;
    }

    @ApiOperation(value = "下拉框查询对应站点的项目信息", notes = "测试数据:{\"station_id\":10}")
    @PostMapping("/select_project")
    public List<Project> select_project(@RequestBody Map map) {
        return projectDao.select_project(map);
    }

    @ApiOperation(value = "根据id查询项目信息", notes = "测试数据:{\"id\":61}")
    @PostMapping("/find_project_id")
    public Project find_project_id(@RequestBody Map map) {
        return projectDao.find_project_id(map);
    }

}
