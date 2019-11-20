package com.zty.project.dao;

import com.zty.project.entity.WorkType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WorkTypeDao {
    //分页查询工种
    List<WorkType> find_worktype(Map map);

    //统计条数
    long total();

    //增加工种
    int add_worktype(Map map);

    //删除工种
    int del_worktype(Map map);

    //修改工种
    int upd_worktype(Map map);

    //下拉框查询工种信息
    List<WorkType> select_worktype();
}
