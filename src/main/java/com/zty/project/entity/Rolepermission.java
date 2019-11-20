package com.zty.project.entity;

public class Rolepermission {
    private int id, rid, pid;

    public Rolepermission() {
        super();
    }

    public Rolepermission(int id, int rid, int pid) {
        this.id = id;
        this.rid = rid;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Rolepermission{" +
                "id=" + id +
                ", rid=" + rid +
                ", pid=" + pid +
                '}';
    }
}
