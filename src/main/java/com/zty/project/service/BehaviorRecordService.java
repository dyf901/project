package com.zty.project.service;

import com.zty.project.dao.BehaviorRecordDao;
import com.zty.project.entity.BehaviorRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BehaviorRecordService {
    @Autowired
    private BehaviorRecordDao behaviorRecordDao;

    //分页查询行为记录
    public List<BehaviorRecord> find_behaviorrecord(Map map) {
        return behaviorRecordDao.find_behaviorrecord(map);
    }

    //统计行为记录条数
    public long total() {
        return behaviorRecordDao.total();
    }

    //增加行为记录
    public int add_behaviorrecord(Map map) {
        return behaviorRecordDao.add_behaviorrecord(map);
    }

    //删除行为记录
    public int del_behaviorrecord(Map map) {
        return behaviorRecordDao.del_behaviorrecord(map);
    }

    //修改行为记录
    public int upd_behaviorrecord(Map map) {
        return behaviorRecordDao.upd_behaviorrecord(map);
    }
}
