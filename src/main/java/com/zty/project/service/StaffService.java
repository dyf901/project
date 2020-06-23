package com.zty.project.service;


import com.zty.project.dao.StaffDao;
import com.zty.project.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("StaffService")
public class StaffService implements StaffDao {
    @Autowired
    private StaffDao staffDao;

    //分页模糊查询员工共信息
    @Override
    public List<Staff> find_staff(Map map) {
        return staffDao.find_staff(map);
    }

    //分页模糊查询统计总数
    @Override
    public long total(Map map) {
        return staffDao.total(map);
    }

    //增加员工信息
    @Override
    public int add_staff(Map map) {
        return staffDao.add_staff(map);
    }

    @Override
    public int InsertStaff(Staff staff) {
        return staffDao.InsertStaff(staff);
    }

    //删除员工信息
    @Override
    public int del_staff(Map map) {
        return staffDao.del_staff(map);
    }

    //修改员工信息
    @Override
    public int upd_staff(Map map) {
        return staffDao.upd_staff(map);
    }

    @Override
    public int UpdateStaffByCard(Staff staff) {
        return staffDao.UpdateStaffByCard(staff);
    }

    //修改员工在职状态
    @Override
    public int upd_staff_state(Map map) {
        return staffDao.upd_staff_state(map);
    }

    //根据身份证号查询员工信息
    @Override
    public Staff find_staff_card(Map map) {
        return staffDao.find_staff_card(map);
    }

    //根据身份证号card查询是否有这个员工
    @Override
    public int find_staff_cardcount(Map map) {
        return staffDao.find_staff_cardcount(map);
    }

    //根据id查询员工信息
    @Override
    public Staff find_id(Map map) {
        return staffDao.find_id(map);
    }

    //根据id修改员工剩余积分
    @Override
    public int upd_end(Map map) {
        return staffDao.upd_end(map);
    }

    @Override
    public Staff find_staff_phone(Map map) {
        return staffDao.find_staff_phone(map);
    }

    @Override
    public int upd_end_history(Map map) {
        return staffDao.upd_end_history(map);
    }

    @Override
    public int count_staff() {
        return staffDao.count_staff();
    }

    @Override
    public int count_staff_man() {
        return staffDao.count_staff_man();
    }

    @Override
    public int count_staff_girl() {
        return staffDao.count_staff_girl();
    }

    @Override
    public int CountByCard(String card) {
        return staffDao.CountByCard(card);
    }
}
