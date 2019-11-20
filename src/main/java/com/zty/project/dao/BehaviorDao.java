package com.zty.project.dao;

import com.zty.project.entity.Behavior;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BehaviorDao {

    //分页查询行为类型信息
    List<Behavior> find_behavior(Map map);

    //统计总条数
    long total();

    //增加行为类型信息
    int add_behavior(Map map);

    //修改行为类型信息
    int upd_behavior(Map map);

    //删除行为类型信息
    int del_behavior(Map map);

    //下拉框查询行为类型信息
    List<Behavior> select_behavior();
}
