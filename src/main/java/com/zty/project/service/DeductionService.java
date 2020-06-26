package com.zty.project.service;

import com.zty.project.dao.DeductionDao;
import com.zty.project.entity.Deduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeductionService implements DeductionDao {
    @Autowired
    private DeductionDao deductionDao;

    //增加减分信息
    @Override
    public int InsertDeduction(Map map) {
        return deductionDao.InsertDeduction(map);
    }

    //删除减分信息
    @Override
    public int DeleteDeduction(Map map) {
        return deductionDao.DeleteDeduction(map);
    }

    //分页查询减分信息
    @Override
    public List<Deduction> FindDeduction(Map map) {
        return deductionDao.FindDeduction(map);
    }

    //统计总数
    @Override
    public long Total() {
        return deductionDao.Total();
    }
}
