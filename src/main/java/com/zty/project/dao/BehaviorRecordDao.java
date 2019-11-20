package com.zty.project.dao;

import com.zty.project.entity.BehaviorRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BehaviorRecordDao {
    //分页查询行为记录
    List<BehaviorRecord> find_behaviorrecord(Map map);

    //统计行为记录条数
    long total();

    //增加行为记录
    int add_behaviorrecord(Map map);

    //删除行为记录
    int del_behaviorrecord(Map map);

    //修改行为记录
    int upd_behaviorrecord(Map map);
}
