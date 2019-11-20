package com.zty.project.dao;

import com.zty.project.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartmentDao {
    //分页查询部门信息
    List<Department> find_department(Map map);

    //统计条数
    long total();

    //增加部门种类
    int add_department(Map map);

    //删除部门种类
    int del_department(Map map);

    //修改部门种类
    int upd_department(Map map);

    //增加部门人数
    int upd_department_percount(Map map);

    //根据部门id查询部门信息
    Department find_department_id(Map map);

    //下拉框查询部门信息
    List<Department> select_department();
}
