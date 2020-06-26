package com.zty.project.dao;

import com.zty.project.entity.Deduction;

import java.util.List;
import java.util.Map;

public interface DeductionDao {
    //增加减分信息
    int InsertDeduction(Map map);

    //删除减分信息
    int DeleteDeduction(Map map);

    //分页查询减分信息
    List<Deduction> FindDeduction(Map map);

    //统计总数
    long Total();
}
