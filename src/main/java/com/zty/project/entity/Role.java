package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*用户登录表
 * id   角色id
 * role_name  角色名称
 * state  状态
 *
 * 角色实体类
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    private int id;
    private String role_name;
    private int state;

    public Role() {
        super();
    }

    public Role(int id, String role_name, int state) {
        this.id = id;
        this.role_name = role_name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", state=" + state +
                '}';
    }
}
