package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * 项目实体类
 * project 项目表
 * id   项目编号
 * project_name   项目名称
 * start_time   开工时间
 * modify_time   修改时间
 * end_time   结工时间
 * accomplish_day   当天完成量
 * accomplish_month   当月完成量
 * accomplish_all   总完成量
 * gross   总工程量
 * station_id   站点编号
 * person   工人数量
 *
 *
 * station_name   站点名称
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {
    private int id, accomplish_day, accomplish_month, accomplish_all, gross, station_id, person;
    private String project_name, station_name;
    private String start_time, modify_time, end_time;


    public Project() {
        super();
    }

    public Project(int id, int accomplish_day, int accomplish_month, int accomplish_all, int gross, int station_id,
                   int person, String project_name, String station_name, String start_time, String modify_time,
                   String end_time) {
        super();
        this.id = id;
        this.accomplish_day = accomplish_day;
        this.accomplish_month = accomplish_month;
        this.accomplish_all = accomplish_all;
        this.gross = gross;
        this.station_id = station_id;
        this.person = person;
        this.project_name = project_name;
        this.station_name = station_name;
        this.start_time = start_time;
        this.modify_time = modify_time;
        this.end_time = end_time;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccomplish_day() {
        return accomplish_day;
    }

    public void setAccomplish_day(int accomplish_day) {
        this.accomplish_day = accomplish_day;
    }

    public int getAccomplish_month() {
        return accomplish_month;
    }

    public void setAccomplish_month(int accomplish_month) {
        this.accomplish_month = accomplish_month;
    }

    public int getAccomplish_all() {
        return accomplish_all;
    }

    public void setAccomplish_all(int accomplish_all) {
        this.accomplish_all = accomplish_all;
    }

    public int getGross() {
        return gross;
    }

    public void setGross(int gross) {
        this.gross = gross;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", accomplish_day=" + accomplish_day + ", accomplish_month=" + accomplish_month
                + ", accomplish_all=" + accomplish_all + ", gross=" + gross + ", station_id=" + station_id + ", person="
                + person + ", project_name=" + project_name + ", station_name=" + station_name + ", start_time="
                + start_time + ", modify_time=" + modify_time + ", end_time=" + end_time + "]";
    }
}
