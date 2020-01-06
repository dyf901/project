package com.zty.project.entity;

/*
工种表实体类
worktype   工种表
id    工种id
name   工种名称
content    工作内容
department_id   所属部门
remark   备注
*/
public class WorkType {
    private int id, department_id;
    private String name, content, remark;
    private String department_name;

    public WorkType() {
        super();
    }

    public WorkType(int id, int department_id, String name, String content, String remark, String department_name) {
        this.id = id;
        this.department_id = department_id;
        this.name = name;
        this.content = content;
        this.remark = remark;
        this.department_name = department_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "WorkType{" +
                "id=" + id +
                ", department_id=" + department_id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", remake='" + remark + '\'' +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
