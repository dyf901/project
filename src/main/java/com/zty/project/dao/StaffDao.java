package com.zty.project.dao;

import com.zty.project.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StaffDao {

    //分页模糊查询员工共信息
    List<Staff> find_staff(Map map);

    //分页模糊查询统计总数
    long total(Map map);

    //增加员工信息
    int add_staff(Map map);

    //删除员工信息
    int del_staff(Map map);

    //修改员工信息
    int upd_staff(Map map);

    //修改员工在职状态
    int upd_staff_state(Map map);

    //根据身份证号查询员工信息
    Staff find_staff_card(Map map);

    //根据身份证号card查询是否有这个员工
    int find_staff_cardcount(Map map);
}
