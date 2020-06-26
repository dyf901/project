package com.zty.project.service;

import com.zty.project.dao.CommodityDao;
import com.zty.project.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommodityService implements CommodityDao {
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public List<Commodity> FindCommodity(Map map) {
        return commodityDao.FindCommodity(map);
    }

    //分页查找所有商品信息
    @Override
    public List<Commodity> find_commodity(Map map) {
        return commodityDao.find_commodity(map);
    }

    //统计总数
    @Override
    public long total() {
        return commodityDao.total();
    }

    //增加商品
    @Override
    public int add_commodity(Map map) {
        return commodityDao.add_commodity(map);
    }

    @Override
    public int UpdateCommodity(Map map) {
        return commodityDao.UpdateCommodity(map);
    }

    //修改商品信息 状态改为0
    @Override
    public int update_commodity_active0(Map map) {
        return commodityDao.update_commodity_active0(map);
    }

    //修改商品信息 状态改为1
    @Override
    public int update_commodity_active1(Map map) {
        return commodityDao.update_commodity_active1(map);
    }

    //下拉框查询数据
    @Override
    public List<Commodity> select_commodity() {
        return commodityDao.select_commodity();
    }

    //根据id查询物品信息
    @Override
    public Commodity select_commodity_id(Map map) {
        return commodityDao.select_commodity_id(map);
    }
}
