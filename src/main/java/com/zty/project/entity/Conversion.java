package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
/*
* 兑换记录表实体类
* conversion   兑换记录表
* id      兑换id
* did     部门id
* sid       员工id
* conversion_time   兑换时间
* commodity_name    兑换的商品
* send_active       派送状态
*
* dname      部门名称
* sname      员工姓名
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conversion {
    private int id,sid,did;
    private String conversion_time,commodity_name,send_active;

    public Conversion(){
        super();
    }

    public Conversion(int id, int sid, int did, String conversion_time, String commodity_name, String send_active) {
        this.id = id;
        this.sid = sid;
        this.did = did;
        this.conversion_time = conversion_time;
        this.commodity_name = commodity_name;
        this.send_active = send_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getConversion_time() {
        return conversion_time;
    }

    public void setConversion_time(String conversion_time) {
        this.conversion_time = conversion_time;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getSend_active() {
        return send_active;
    }

    public void setSend_active(String send_active) {
        this.send_active = send_active;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "id=" + id +
                ", sid=" + sid +
                ", did=" + did +
                ", conversion_time='" + conversion_time + '\'' +
                ", commodity_name='" + commodity_name + '\'' +
                ", send_active='" + send_active + '\'' +
                '}';
    }
}
