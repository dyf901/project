package com.zty.project.entity;

/*
行为记录实体类
behavior_record   行为记录表
id
staff_id   员工id
behavior_id   行为id
uptime   上传时间
remark   备注
*/
public class BehaviorRecord {
    private int id, staff_id, behavior_id;
    private String uptime, remark, integral;
    private String staff_name, staff_phone, staff_card;
    private String behavior_name;

    public BehaviorRecord() {
        super();
    }

    public BehaviorRecord(int id, int staff_id, int behavior_id, String uptime, String remark, String integral, String staff_name, String staff_phone, String staff_card, String behavior_name) {
        this.id = id;
        this.staff_id = staff_id;
        this.behavior_id = behavior_id;
        this.uptime = uptime;
        this.remark = remark;
        this.integral = integral;
        this.staff_name = staff_name;
        this.staff_phone = staff_phone;
        this.staff_card = staff_card;
        this.behavior_name = behavior_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getBehavior_id() {
        return behavior_id;
    }

    public void setBehavior_id(int behavior_id) {
        this.behavior_id = behavior_id;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public String getStaff_card() {
        return staff_card;
    }

    public void setStaff_card(String staff_card) {
        this.staff_card = staff_card;
    }

    public String getBehavior_name() {
        return behavior_name;
    }

    public void setBehavior_name(String behavior_name) {
        this.behavior_name = behavior_name;
    }

    @Override
    public String toString() {
        return "BehaviorRecord{" +
                "id=" + id +
                ", staff_id=" + staff_id +
                ", behavior_id=" + behavior_id +
                ", uptime='" + uptime + '\'' +
                ", remark='" + remark + '\'' +
                ", integral='" + integral + '\'' +
                ", staff_name='" + staff_name + '\'' +
                ", staff_phone='" + staff_phone + '\'' +
                ", staff_card='" + staff_card + '\'' +
                ", behavior_name='" + behavior_name + '\'' +
                '}';
    }
}
