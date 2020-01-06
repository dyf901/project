package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * 隐患风险记录实体类
 *
 * 隐患风险记录表
 * id   序号
 * sid   员工id
 * risk_id   风险类型编号
 * station_id   站点id
 * project_id   项目id
 * description   具体描述
 * uptime   上传时间
 * active   状态
 * state   审核状态（是否有效）
 * remark   备注(整改信息)
 * price   分配的积分
 * url,url1,url2,url3,url4,url5,url6,url7,url8   风险图片(地址)
 * url_rectify,url_rectify1,url_rectify2,url_rectify3,url_rectify4,url_rectify5,url_rectify6,url_rectify7,url_rectify8   整改后的图片（地址）
 *
 * staff_name   员工姓名
 * risk_category    风险源名称
 * station_name     站点名称
 * project_name     项目名称
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Riskshow {
    private int id, sid, risk_id, station_id, project_id, price;
    private String description, uptime, active, state, remark;
    private String url, url1, url2, url3, url4, url5, url6, url7, url8;
    private String url_rectify, url_rectify1, url_rectify2, url_rectify3, url_rectify4, url_rectify5, url_rectify6, url_rectify7, url_rectify8;
    private String staff_name,risk_category,station_name,project_name;

    public Riskshow() {
        super();
    }

    public Riskshow(int id, int sid, int risk_id, int station_id, int project_id, int price, String description, String uptime, String active, String state, String remark, String url, String url1, String url2, String url3, String url4, String url5, String url6, String url7, String url8, String url_rectify, String url_rectify1, String url_rectify2, String url_rectify3, String url_rectify4, String url_rectify5, String url_rectify6, String url_rectify7, String url_rectify8, String staff_name, String risk_category, String station_name, String project_name) {
        this.id = id;
        this.sid = sid;
        this.risk_id = risk_id;
        this.station_id = station_id;
        this.project_id = project_id;
        this.price = price;
        this.description = description;
        this.uptime = uptime;
        this.active = active;
        this.state = state;
        this.remark = remark;
        this.url = url;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.url4 = url4;
        this.url5 = url5;
        this.url6 = url6;
        this.url7 = url7;
        this.url8 = url8;
        this.url_rectify = url_rectify;
        this.url_rectify1 = url_rectify1;
        this.url_rectify2 = url_rectify2;
        this.url_rectify3 = url_rectify3;
        this.url_rectify4 = url_rectify4;
        this.url_rectify5 = url_rectify5;
        this.url_rectify6 = url_rectify6;
        this.url_rectify7 = url_rectify7;
        this.url_rectify8 = url_rectify8;
        this.staff_name = staff_name;
        this.risk_category = risk_category;
        this.station_name = station_name;
        this.project_name = project_name;
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

    public int getRisk_id() {
        return risk_id;
    }

    public void setRisk_id(int risk_id) {
        this.risk_id = risk_id;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public String getUrl5() {
        return url5;
    }

    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    public String getUrl6() {
        return url6;
    }

    public void setUrl6(String url6) {
        this.url6 = url6;
    }

    public String getUrl7() {
        return url7;
    }

    public void setUrl7(String url7) {
        this.url7 = url7;
    }

    public String getUrl8() {
        return url8;
    }

    public void setUrl8(String url8) {
        this.url8 = url8;
    }

    public String getUrl_rectify() {
        return url_rectify;
    }

    public void setUrl_rectify(String url_rectify) {
        this.url_rectify = url_rectify;
    }

    public String getUrl_rectify1() {
        return url_rectify1;
    }

    public void setUrl_rectify1(String url_rectify1) {
        this.url_rectify1 = url_rectify1;
    }

    public String getUrl_rectify2() {
        return url_rectify2;
    }

    public void setUrl_rectify2(String url_rectify2) {
        this.url_rectify2 = url_rectify2;
    }

    public String getUrl_rectify3() {
        return url_rectify3;
    }

    public void setUrl_rectify3(String url_rectify3) {
        this.url_rectify3 = url_rectify3;
    }

    public String getUrl_rectify4() {
        return url_rectify4;
    }

    public void setUrl_rectify4(String url_rectify4) {
        this.url_rectify4 = url_rectify4;
    }

    public String getUrl_rectify5() {
        return url_rectify5;
    }

    public void setUrl_rectify5(String url_rectify5) {
        this.url_rectify5 = url_rectify5;
    }

    public String getUrl_rectify6() {
        return url_rectify6;
    }

    public void setUrl_rectify6(String url_rectify6) {
        this.url_rectify6 = url_rectify6;
    }

    public String getUrl_rectify7() {
        return url_rectify7;
    }

    public void setUrl_rectify7(String url_rectify7) {
        this.url_rectify7 = url_rectify7;
    }

    public String getUrl_rectify8() {
        return url_rectify8;
    }

    public void setUrl_rectify8(String url_rectify8) {
        this.url_rectify8 = url_rectify8;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getRisk_category() {
        return risk_category;
    }

    public void setRisk_category(String risk_category) {
        this.risk_category = risk_category;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    @Override
    public String toString() {
        return "Riskshow{" +
                "id=" + id +
                ", sid=" + sid +
                ", risk_id=" + risk_id +
                ", station_id=" + station_id +
                ", project_id=" + project_id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", uptime='" + uptime + '\'' +
                ", active='" + active + '\'' +
                ", state='" + state + '\'' +
                ", remark='" + remark + '\'' +
                ", url='" + url + '\'' +
                ", url1='" + url1 + '\'' +
                ", url2='" + url2 + '\'' +
                ", url3='" + url3 + '\'' +
                ", url4='" + url4 + '\'' +
                ", url5='" + url5 + '\'' +
                ", url6='" + url6 + '\'' +
                ", url7='" + url7 + '\'' +
                ", url8='" + url8 + '\'' +
                ", url_rectify='" + url_rectify + '\'' +
                ", url_rectify1='" + url_rectify1 + '\'' +
                ", url_rectify2='" + url_rectify2 + '\'' +
                ", url_rectify3='" + url_rectify3 + '\'' +
                ", url_rectify4='" + url_rectify4 + '\'' +
                ", url_rectify5='" + url_rectify5 + '\'' +
                ", url_rectify6='" + url_rectify6 + '\'' +
                ", url_rectify7='" + url_rectify7 + '\'' +
                ", url_rectify8='" + url_rectify8 + '\'' +
                ", staff_name='" + staff_name + '\'' +
                ", risk_category='" + risk_category + '\'' +
                ", station_name='" + station_name + '\'' +
                ", project_name='" + project_name + '\'' +
                '}';
    }
}
