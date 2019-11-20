package com.zty.project.entity;

/*
行为类型实体类
behavior   行为表
id   行为id
name   行为名称
detail   解释
remark   备注

*/
public class Behavior {
    private int id;
    private String name, detail, remark;

    public Behavior() {
        super();
    }

    public Behavior(int id, String name, String detail, String remark) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Behavior{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
