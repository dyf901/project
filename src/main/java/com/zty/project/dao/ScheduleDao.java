package com.zty.project.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ScheduleDao {
    //增加上传进度记录
    int add_schedule(Map map);

    //根据上传进度记录查询当月完成量
    int find_accomplish_sum(Map map);
}
