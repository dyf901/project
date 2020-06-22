package com.zty.project.entity;

/*
员工信息实体类
staff  员工表
id   员工id
name   员工姓名
sex   年龄
nation   民族
card   身份证号
address   地址
department_id   所属部门
phone   手机号
sos_name   紧急联系人姓名
sos_ship   紧急联系人关系
sos_phone   紧急联系人电话
createtime   入职时间
worktype_id   工种
picture   员工照片
history   历史积分
end   剩余积分
password   登录密码
state   状态
type    班组


departmentname  部门名称
worktypename   工种名称
*/
public class Staff {
    private int id, history, end, department_id, worktype_id;
    private String name, nation, card, address, phone, sos_name, sos_ship, sos_phone, createtime, img_url, password, state, sex, new_url;
    private String departmentname, worktypename;
    private String type;

    public Staff() {
        super();
    }

    public Staff(int id, int history, int end, int department_id, int worktype_id, String name, String nation, String card, String address, String phone, String sos_name, String sos_ship, String sos_phone, String createtime, String img_url, String password, String state, String sex, String new_url, String departmentname, String worktypename, String type) {
        this.id = id;
        this.history = history;
        this.end = end;
        this.department_id = department_id;
        this.worktype_id = worktype_id;
        this.name = name;
        this.nation = nation;
        this.card = card;
        this.address = address;
        this.phone = phone;
        this.sos_name = sos_name;
        this.sos_ship = sos_ship;
        this.sos_phone = sos_phone;
        this.createtime = createtime;
        this.img_url = img_url;
        this.password = password;
        this.state = state;
        this.sex = sex;
        this.new_url = new_url;
        this.departmentname = departmentname;
        this.worktypename = worktypename;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getWorktype_id() {
        return worktype_id;
    }

    public void setWorktype_id(int worktype_id) {
        this.worktype_id = worktype_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSos_name() {
        return sos_name;
    }

    public void setSos_name(String sos_name) {
        this.sos_name = sos_name;
    }

    public String getSos_ship() {
        return sos_ship;
    }

    public void setSos_ship(String sos_ship) {
        this.sos_ship = sos_ship;
    }

    public String getSos_phone() {
        return sos_phone;
    }

    public void setSos_phone(String sos_phone) {
        this.sos_phone = sos_phone;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getWorktypename() {
        return worktypename;
    }

    public void setWorktypename(String worktypename) {
        this.worktypename = worktypename;
    }

    public String getNew_url() {
        return new_url;
    }

    public void setNew_url(String new_url) {
        this.new_url = new_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", history=" + history +
                ", end=" + end +
                ", department_id=" + department_id +
                ", worktype_id=" + worktype_id +
                ", name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", card='" + card + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", sos_name='" + sos_name + '\'' +
                ", sos_ship='" + sos_ship + '\'' +
                ", sos_phone='" + sos_phone + '\'' +
                ", createtime='" + createtime + '\'' +
                ", img_url='" + img_url + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", sex='" + sex + '\'' +
                ", new_url='" + new_url + '\'' +
                ", departmentname='" + departmentname + '\'' +
                ", worktypename='" + worktypename + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
