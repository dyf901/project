package com.zty.project.service;

import com.zty.project.dao.ProjectDao;
import com.zty.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;

    //分页模糊查询
    public List<Project> find_project(Map map) {
        return projectDao.find_project(map);
    }

    //统计总数
    public long total(Map map) {
        return projectDao.total(map);
    }

    //增加项目
    public int add_project(Map map) {
        return projectDao.add_project(map);
    }

    //修改项目
    public int upd_project(Map map) {
        return projectDao.upd_project(map);
    }

    //修改项目进度信息
    public int upd_project_accomplish(Map map) {
        return projectDao.upd_project_accomplish(map);
    }

    //删除项目
    public int del_project(Map map) {
        return projectDao.del_project(map);
    }

    //下拉框查询对应站点的项目信息
    public List<Project> select_project(Map map) {
        return projectDao.select_project(map);
    }

    //根据id查找项目信息
    public Project find_project_id(Map map) {
        return projectDao.find_project_id(map);
    }

}
