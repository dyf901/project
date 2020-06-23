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

    //增加员工信息
    int InsertStaff(Staff staff);

    //删除员工信息
    int del_staff(Map map);

    //修改员工信息
    int upd_staff(Map map);

    //根据card修改员工信息
    int UpdateStaffByCard(Staff staff);

    //修改员工在职状态
    int upd_staff_state(Map map);

    //根据身份证号查询员工信息
    Staff find_staff_card(Map map);

    //根据身份证号card查询是否有这个员工
    int find_staff_cardcount(Map map);

    //根据id查询员工信息
    Staff find_id(Map map);

    //根据id修改剩余积分
    int upd_end(Map map);

    //根据phone来查询员工信息
    Staff find_staff_phone(Map map);

    //根据id增加剩余和历史积分
    int upd_end_history(Map map);

    //统计总人数
    int count_staff();

    //统计男生人数
    int count_staff_man();

    //统计女生人数
    int count_staff_girl();

    int CountByCard(String card);
}
