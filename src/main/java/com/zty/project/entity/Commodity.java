package com.zty.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * 商品表实体类
 * commodity   商品表
 * id    商品id
 * commodity_name    商品名称
 * up_time   上架时间
 * price     价格
 * url       商品图片
 * active    状态
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Commodity {
    private int id, price, active;
    private String commodity_name, up_time, url;

    public Commodity() {
        super();
    }

    public Commodity(int id, int price, int active, String commodity_name, String up_time, String url) {
        this.id = id;
        this.price = price;
        this.active = active;
        this.commodity_name = commodity_name;
        this.up_time = up_time;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getUp_time() {
        return up_time;
    }

    public void setUp_time(String up_time) {
        this.up_time = up_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", price=" + price +
                ", active=" + active +
                ", commodity_name='" + commodity_name + '\'' +
                ", up_time='" + up_time + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
