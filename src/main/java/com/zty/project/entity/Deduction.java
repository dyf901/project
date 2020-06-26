package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Deduction" , description = "减分信息表对象")
public class Deduction {
    @ApiModelProperty(value = "减分信息id" , name = "id")
    private int id;

    @ApiModelProperty(value = "员id" , name = "staff_id")
    private int staff_id;

    @ApiModelProperty(value = "减分原因" , name = "content")
    private String content;

    @ApiModelProperty(value = "扣除积分" , name = "integral")
    private int integral;

    @ApiModelProperty(value = "上传时间" , name = "uptime")
    private String uptime;

    @ApiModelProperty(value = "上传时间" , name = "staff_name")
    private String staff_name;

    public Deduction(){
        super();
    }

    public Deduction(int id, int staff_id, String content, int integral, String uptime, String staff_name) {
        this.id = id;
        this.staff_id = staff_id;
        this.content = content;
        this.integral = integral;
        this.uptime = uptime;
        this.staff_name = staff_name;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    @Override
    public String toString() {
        return "Deduction{" +
                "id=" + id +
                ", staff_id=" + staff_id +
                ", content='" + content + '\'' +
                ", integral=" + integral +
                ", uptime='" + uptime + '\'' +
                ", staff_name='" + staff_name + '\'' +
                '}';
    }
}
