package com.zty.project.entity;
/*
部门表实体类

department    部门表
        id   部门id
        deptnum   部门编号
        percount   部门人数
        depthead   部门负责人
        headphone   负责人联系电话
        remark   备注


*/

public class Department {
    private int id, percount;
    private String deptnum, depthead, headphone, remark, name;

    public Department() {
        super();
    }

    public Department(int id, int percount, String deptnum, String depthead, String headphone, String remark, String name) {
        this.id = id;
        this.percount = percount;
        this.deptnum = deptnum;
        this.depthead = depthead;
        this.headphone = headphone;
        this.remark = remark;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercount() {
        return percount;
    }

    public void setPercount(int percount) {
        this.percount = percount;
    }

    public String getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(String deptnum) {
        this.deptnum = deptnum;
    }

    public String getDepthead() {
        return depthead;
    }

    public void setDepthead(String depthead) {
        this.depthead = depthead;
    }

    public String getHeadphone() {
        return headphone;
    }

    public void setHeadphone(String headphone) {
        this.headphone = headphone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", percount=" + percount +
                ", deptnum='" + deptnum + '\'' +
                ", depthead='" + depthead + '\'' +
                ", headphone='" + headphone + '\'' +
                ", remark='" + remark + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
