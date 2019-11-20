package com.zty.project.service;

import com.zty.project.dao.DepartmentDao;
import com.zty.project.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    //分页查询部门信息
    public List<Department> find_department(Map map) {
        return departmentDao.find_department(map);
    }

    //统计条数
    public long total() {
        return departmentDao.total();
    }

    //增加部门种类
    public int add_department(Map map) {
        return departmentDao.add_department(map);
    }

    //删除部门种类
    public int del_department(Map map) {
        return departmentDao.del_department(map);
    }

    //修改部门种类
    public int upd_department(Map map) {
        return departmentDao.upd_department(map);
    }

    //增加部门人数
    public int upd_department_percount(Map map) {
        return departmentDao.upd_department_percount(map);
    }

    //根据部门id查询部门信息
    public Department find_department_id(Map map) {
        return departmentDao.find_department_id(map);
    }

    //下拉框查询部门信息
    public List<Department> select_department() {
        return departmentDao.select_department();
    }
}
