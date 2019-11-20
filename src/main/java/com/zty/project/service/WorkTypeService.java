package com.zty.project.service;

import com.zty.project.dao.WorkTypeDao;
import com.zty.project.entity.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkTypeService {
    @Autowired
    private WorkTypeDao workTypeDao;

    //分页查询工种
    public List<WorkType> find_worktype(Map map) {
        return workTypeDao.find_worktype(map);
    }

    //统计条数
    public long total() {
        return workTypeDao.total();
    }

    //增加工种
    public int add_worktype(Map map) {
        return workTypeDao.add_worktype(map);
    }

    //删除工种
    public int del_worktype(Map map) {
        return workTypeDao.del_worktype(map);
    }

    //修改工种
    public int upd_worktype(Map map) {
        return workTypeDao.upd_worktype(map);
    }

    //下拉框查询工种信息
    public List<WorkType> select_worktype() {
        return workTypeDao.select_worktype();
    }
}
