package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * 隐患风险信息类
 *
 * 隐患风险类型表
 * id  风险序号
 * risk_category   风险源类别
 * risk_description   具体风险描述
 * risk_grade   风险等级
 * risk_duration   风险预计持续时段
 * construction   施工控制设施
 * construction_person   施工责任人
 * construction_phone   施工责任人电话
 * supervisor   监理控制设施
 * supervisor_person   监理责任人
 * supervisor_phone   监理责任人电话
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Risk {
    private int id;
    private String risk_category, risk_description, risk_grade, risk_duration, construction, construction_person, construction_phone, supervisor, supervisor_person, supervisor_phone;

    public Risk() {
        super();
    }

    public Risk(int id, String risk_category, String risk_description, String risk_grade, String risk_duration, String construction, String construction_person, String construction_phone, String supervisor, String supervisor_person, String supervisor_phone) {
        this.id = id;
        this.risk_category = risk_category;
        this.risk_description = risk_description;
        this.risk_grade = risk_grade;
        this.risk_duration = risk_duration;
        this.construction = construction;
        this.construction_person = construction_person;
        this.construction_phone = construction_phone;
        this.supervisor = supervisor;
        this.supervisor_person = supervisor_person;
        this.supervisor_phone = supervisor_phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRisk_category() {
        return risk_category;
    }

    public void setRisk_category(String risk_category) {
        this.risk_category = risk_category;
    }

    public String getRisk_description() {
        return risk_description;
    }

    public void setRisk_description(String risk_description) {
        this.risk_description = risk_description;
    }

    public String getRisk_grade() {
        return risk_grade;
    }

    public void setRisk_grade(String risk_grade) {
        this.risk_grade = risk_grade;
    }

    public String getRisk_duration() {
        return risk_duration;
    }

    public void setRisk_duration(String risk_duration) {
        this.risk_duration = risk_duration;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getConstruction_person() {
        return construction_person;
    }

    public void setConstruction_person(String construction_person) {
        this.construction_person = construction_person;
    }

    public String getConstruction_phone() {
        return construction_phone;
    }

    public void setConstruction_phone(String construction_phone) {
        this.construction_phone = construction_phone;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSupervisor_person() {
        return supervisor_person;
    }

    public void setSupervisor_person(String supervisor_person) {
        this.supervisor_person = supervisor_person;
    }

    public String getSupervisor_phone() {
        return supervisor_phone;
    }

    public void setSupervisor_phone(String supervisor_phone) {
        this.supervisor_phone = supervisor_phone;
    }

    @Override
    public String toString() {
        return "Risk{" +
                "id=" + id +
                ", risk_category='" + risk_category + '\'' +
                ", risk_description='" + risk_description + '\'' +
                ", risk_grade='" + risk_grade + '\'' +
                ", risk_duration='" + risk_duration + '\'' +
                ", construction='" + construction + '\'' +
                ", construction_person='" + construction_person + '\'' +
                ", construction_phone='" + construction_phone + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", supervisor_person='" + supervisor_person + '\'' +
                ", supervisor_phone='" + supervisor_phone + '\'' +
                '}';
    }
}
