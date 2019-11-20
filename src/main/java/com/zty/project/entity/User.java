package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*用户登录表*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String id;
    private String username;
    private String password;
    private String name;
    private String createTime;
    private String expiredDate;
    private int station_id;
    private int state;

    public User() {
        super();
    }

    public User(String id, String username, String password, String name, String createTime, String expiredDate, int station_id, int state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.createTime = createTime;
        this.expiredDate = expiredDate;
        this.station_id = station_id;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expiredDate='" + expiredDate + '\'' +
                ", state=" + state +
                '}';
    }
}
