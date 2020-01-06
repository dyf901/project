package com.zty.project.service;

import com.zty.project.dao.ConversionDao;
import com.zty.project.entity.Conversion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ConversionService {
    @Autowired
    private ConversionDao conversionDao;

    //查看兑换信息
    public List<Conversion> find_conversion(){
        return conversionDao.find_conversion();
    }

    //统计总数
    public long total(){
        return conversionDao.total();
    }

    //增加兑换信息
    public int add_conversion(Map map){
        return conversionDao.add_conversion(map);
    }

    //查找个人的兑换信息
    public List<Conversion> find_conversion_sid(Map map){
        return conversionDao.find_conversion_sid(map);
    }
}
