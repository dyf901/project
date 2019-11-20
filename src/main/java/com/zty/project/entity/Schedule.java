package com.zty.project.entity;

/*
 * 每日进度上传表实体类
 * 每日进度上传表
 * id  进度编号
 * station_id   站点id
 * project_id   项目id
 * accomplish_day   每日完成量
 * uptime   上传时间
 * */
public class Schedule {
    private int id, station_id, project_id, accomplish_day;
    private String uptime;

    public Schedule() {
        super();
    }

    public Schedule(int id, int station_id, int project_id, int accomplish_day, String uptime) {
        this.id = id;
        this.station_id = station_id;
        this.project_id = project_id;
        this.accomplish_day = accomplish_day;
        this.uptime = uptime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAccomplish_day() {
        return accomplish_day;
    }

    public void setAccomplish_day(int accomplish_day) {
        this.accomplish_day = accomplish_day;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", station_id=" + station_id +
                ", project_id=" + project_id +
                ", accomplish_day=" + accomplish_day +
                ", uptime='" + uptime + '\'' +
                '}';
    }
}
