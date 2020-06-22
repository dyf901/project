package com.zty.project.dao;

import com.zty.project.entity.Conversion;

import java.util.List;
import java.util.Map;

public interface ConversionDao {
    //查看兑换信息
    List<Conversion> find_conversion(Map map);

    //统计总数
    long total();

    //增加兑换信息
    int add_conversion(Map map);

    //查找个人的兑换信息
    List<Conversion> find_conversion_sid(Map map);

    //查找兑换信息
    List<Conversion> select_conversion();
}
