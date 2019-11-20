package com.zty.project.service;

import com.zty.project.dao.BehaviorDao;
import com.zty.project.entity.Behavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BehaviorService {
    @Autowired
    private BehaviorDao behaviorDao;

    //分页查询行为类型信息
    public List<Behavior> find_behavior(Map map) {
        return behaviorDao.find_behavior(map);
    }

    //统计总条数
    public long total() {
        return behaviorDao.total();
    }

    //增加行为类型信息
    public int add_behavior(Map map) {
        return behaviorDao.add_behavior(map);
    }

    //修改行为类型信息
    public int upd_behavior(Map map) {
        return behaviorDao.upd_behavior(map);
    }

    //删除行为类型信息
    public int del_behavior(Map map) {
        return behaviorDao.del_behavior(map);
    }

    //下拉框查询行为类型信息
    public List<Behavior> select_behavior() {
        return behaviorDao.select_behavior();
    }
}
