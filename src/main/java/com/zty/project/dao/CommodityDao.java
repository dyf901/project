package com.zty.project.dao;

import com.zty.project.entity.Commodity;

import java.util.List;
import java.util.Map;

public interface CommodityDao {
    //分页查找所有商品信息
    List<Commodity> find_commodity(Map map);

    //统计总数
    long total();

    //增加商品
    int add_commodity(Map map);

    //修改商品信息
    int UpdateCommodity(Map map);

    //修改商品信息 状态改为0
    int update_commodity_active0(Map map);

    //修改商品信息 状态改为1
    int update_commodity_active1(Map map);

    //下拉框查询数据
    List<Commodity> select_commodity();

    //根据id查询物品信息
    Commodity select_commodity_id(Map map);
}
