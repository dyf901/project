package com.zty.project.controller;

import com.zty.project.dao.DepartmentDao;
import com.zty.project.entity.Department;
import com.zty.project.entity.WorkType;
import com.zty.project.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "部门接口")
@RestController
@RequestMapping("department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentDao departmentDao;

    @ApiOperation(value = "分页查询部门类型信息", notes = "测试数据:{\"pageNo\": 1,\n" +
            "  \"pageSize\": 10}")
    @PostMapping("/find_department")
    public Page<Department> find_department(@RequestBody Map map) {
        Page<Department> page = new Page<Department>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(departmentDao.total());
        page.setItems(departmentDao.find_department(map));
        return page;
    }

    @ApiOperation(value = "增加部门类型信息", notes = "测试数据:{\"name\":\"施工部\",\n" +
            "\"deptnum\":\"DX308\",\n" +
            "\"depthead\":\"晋铁智能科技\",\n" +
            "\"headphone\":\"13000000000\",\n" +
            "\"remark\":\"主要负责场地施工\"}")
    @PostMapping("/add_department")
    public boolean add_department(@RequestBody Map map) {
        return departmentDao.add_department(map) == 1;
    }

    @ApiOperation(value = "删除部门类型信息", notes = "测试数据:{\"id\":1}")
    @PostMapping("/del_department")
    public boolean del_department(@RequestBody Map map) {
        return departmentDao.del_department(map) == 1;
    }

    @ApiOperation(value = "修改部门类型信息", notes = "测试数据:{\"id\":2,\n" +
            "\"deptnum\":\"1\",\n" +
            "\"name\":\"1\",\n" +
            "\"percount\":1,\n" +
            "\"depthead\":\"1\",\n" +
            "\"headphone\":\"1\",\n" +
            "\"remark\":\"1\"}")
    @PostMapping("/upd_department")
    public boolean upd_department(@RequestBody Map map) {
        return departmentDao.upd_department(map) == 1;
    }

    @ApiOperation(value = "下拉框查询部门", notes = "测试数据:")
    @PostMapping("/select_department")
    public List<Department> select_department() {
        return departmentDao.select_department();
    }
}
