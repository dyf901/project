package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * 兑换记录表实体类
 * conversion   兑换记录表
 * id      兑换id
 * did     部门id
 * sid       员工id
 * conversion_time   兑换时间
 * cid    商品id
 * send_active       派送状态
 * type       班组
 *
 * dname      部门名称
 * sname      员工姓名
 * cname      商品名称
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conversion {
    private int id, sid, did, cid;
    private String conversion_time, send_active, dname, sname, cname;
    private String type;

    public Conversion() {
        super();
    }

    public Conversion(int id, int sid, int did, int cid, String conversion_time, String send_active, String dname, String sname, String cname, String type) {
        this.id = id;
        this.sid = sid;
        this.did = did;
        this.cid = cid;
        this.conversion_time = conversion_time;
        this.send_active = send_active;
        this.dname = dname;
        this.sname = sname;
        this.cname = cname;
        this.type = type;
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "id=" + id +
                ", sid=" + sid +
                ", did=" + did +
                ", cid=" + cid +
                ", conversion_time='" + conversion_time + '\'' +
                ", send_active='" + send_active + '\'' +
                ", dname='" + dname + '\'' +
                ", sname='" + sname + '\'' +
                ", cname='" + cname + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
