package com.zty.project.dao;

import com.zty.project.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProjectDao {
    //分页模糊查询
    List<Project> find_project(Map map);

    //统计总数
    long total(Map map);

    //增加项目
    int add_project(Map map);

    //修改项目
    int upd_project(Map map);

    //修改项目进度信息
    int upd_project_accomplish(Map map);

    //删除项目
    int del_project(Map map);

    //下拉框查询对应站点的项目信息
    List<Project> select_project(Map map);

    //根据id查找项目信息
    Project find_project_id(Map map);

}
