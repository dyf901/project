package com.zty.project.service;

import com.zty.project.dao.ScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    //增加上传进度记录
    public int add_schedule(Map map) {
        return scheduleDao.add_schedule(map);
    }

    //根据上传进度记录查询当月完成量
    public int find_accomplish_sum(Map map) {
        return scheduleDao.find_accomplish_sum(map);
    }
}
